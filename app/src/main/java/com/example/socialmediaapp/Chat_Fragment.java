package com.example.socialmediaapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class Chat_Fragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<ChatModel> chatModels = new ArrayList<>();

    public Chat_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycle_chat);
        addFakeData();
        setRecyclerView();
    }

    private void setRecyclerView() {
        ChatAdapter adapter = new ChatAdapter(chatModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
    private void addFakeData(){
        chatModels.add(new ChatModel(R.drawable.mascot_1,"omar ahmed"));
        chatModels.add(new ChatModel(R.drawable.mascot_1,"omar ahmed"));
        chatModels.add(new ChatModel(R.drawable.mascot_1,"omar ahmed"));
        chatModels.add(new ChatModel(R.drawable.mascot_1,"omar ahmed"));
        chatModels.add(new ChatModel(R.drawable.mascot_1,"omar ahmed"));
        chatModels.add(new ChatModel(R.drawable.mascot_1,"omar ahmed"));
        chatModels.add(new ChatModel(R.drawable.mascot_1,"omar ahmed"));
        chatModels.add(new ChatModel(R.drawable.mascot_1,"omar ahmed"));
        chatModels.add(new ChatModel(R.drawable.mascot_1,"omar ahmed"));
        chatModels.add(new ChatModel(R.drawable.mascot_1,"omar ahmed"));
        chatModels.add(new ChatModel(R.drawable.mascot_1,"omar ahmed"));
        chatModels.add(new ChatModel(R.drawable.mascot_1,"omar ahmed"));
        chatModels.add(new ChatModel(R.drawable.mascot_1,"omar ahmed"));
        chatModels.add(new ChatModel(R.drawable.mascot_1,"omar ahmed"));
        chatModels.add(new ChatModel(R.drawable.mascot_1,"omar ahmed"));
        chatModels.add(new ChatModel(R.drawable.mascot_1,"omar ahmed"));
    }

}