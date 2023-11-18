package com.example.socialmediaapp;


import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.AndroidException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import de.hdodenhof.circleimageview.CircleImageView;


public class ProfileFragment extends Fragment  {
    ImageView backgroundImage;
    CircleImageView profileImage;
    MaterialButton uploadProfileImage,uploadBackgroundImage;
    StorageReference storageReference;
    Uri uriProfileImage ,uriBackgroundImage;
    private ActivityResultLauncher<String> getContentProfileImage = registerForActivityResult(
            new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri o) {
                    if (o != null) {
                        uriProfileImage=o;
                        profileImage.setImageURI(o);
                        uploadProfileImage.setEnabled(true);
                    }
                }
            });
    private ActivityResultLauncher<String> getContentBackgroundImage = registerForActivityResult(
            new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri o) {
                    if (o != null) {
                        uriBackgroundImage=o;
                        backgroundImage.setImageURI(o);
                        uploadBackgroundImage.setEnabled(true);
                    }
                }
            });
    private ActivityResultLauncher<String> requestPermissionLauncherProfileImage = registerForActivityResult(
            new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    getContentProfileImage.launch("image/*");
                } else {
                    uiExplain("Request Permission", "this task is not done without permission");
                }
            });
    private ActivityResultLauncher<String> requestPermissionLauncherBackgroundImage = registerForActivityResult(
            new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    getContentBackgroundImage.launch("image/*");
                } else {
                    uiExplain("Request Permission", "this task is not done without permission");
                }
            });
    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        onClick();

    }
    private void initUI(View view){
        backgroundImage = (AppCompatImageView) view.findViewById(R.id.background_image);
        profileImage = (CircleImageView) view.findViewById(R.id.profile_image);
        uploadProfileImage=(MaterialButton) view.findViewById(R.id.upload_profile_image);
        uploadBackgroundImage=(MaterialButton) view.findViewById(R.id.upload_background_image);
        storageReference= FirebaseStorage.getInstance().getReference("users_image");
    }
    private void setUploadProfileImage(){
        final StorageReference newStorage=storageReference.child(System.currentTimeMillis()+"");
        newStorage.putFile(uriProfileImage);


    }
    private void setUploadBackgroundImage(){
        final StorageReference newStorage=storageReference.child(System.currentTimeMillis()+"");
        newStorage.putFile(uriBackgroundImage);

    }
    private void onClick(){
        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkGalleryPermission(v);
            }
        });
        backgroundImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkGalleryPermission(v);
            }
        });
        uploadProfileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUploadProfileImage();
            }
        });
        uploadBackgroundImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUploadBackgroundImage();
            }
        });
    }
    private void uiExplain(String title, String message) {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }


    private void checkGalleryPermission(View view) {
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            if(view.getId()==R.id.profile_image) getContentProfileImage.launch("image/*");
            if (view.getId()==R.id.background_image) getContentBackgroundImage.launch("image/*");
        } else {
            if(view.getId()==R.id.profile_image)  requestPermissionLauncherProfileImage.
                    launch(Manifest.permission.READ_EXTERNAL_STORAGE);
            if (view.getId()==R.id.background_image)  requestPermissionLauncherBackgroundImage.
                    launch(Manifest.permission.READ_EXTERNAL_STORAGE);
        }
    }




}