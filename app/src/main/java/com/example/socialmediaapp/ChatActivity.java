package com.example.socialmediaapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class ChatActivity extends AppCompatActivity {
RecyclerView recyclerView;
    TextInputEditText editMessage;
    MaterialButton buttonSend;
    ArrayList<MessageModel> models=new ArrayList<>();;
    MessageAdapter adapter=new MessageAdapter();;
    FirebaseAuth auth=FirebaseAuth.getInstance();

  DatabaseReference ref=FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        initUi();
        onClick();
      setupRecycleView();
    }
    private void initUi(){
        recyclerView=findViewById(R.id.recycle);
        editMessage=findViewById(R.id.message_editText);
        buttonSend=findViewById(R.id.send_button);
    }
    private void setupRecycleView(){
        adapter.setAdapter(models);
        recyclerView.setAdapter(adapter);
        ref.child("messages").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                models.clear();
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
               for(DataSnapshot data:dataSnapshot.getChildren()){
                   models.add(data.getValue(MessageModel.class));}
            }}

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void onClick(){
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message=editMessage.getText().toString();
                if(!message.isEmpty()) sendMessage(message);

            }
        });

    }
    private void sendMessage(String message){
        ref.child("messages").child(auth.getUid()).push().child("message").setValue(message);
        editMessage.setText("");
    }



}