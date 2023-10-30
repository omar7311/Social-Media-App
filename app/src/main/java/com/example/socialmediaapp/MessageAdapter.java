package com.example.socialmediaapp;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageHolder> {

    FirebaseAuth auth=FirebaseAuth.getInstance();
    ArrayList<MessageModel> messageModelArrayList;
    public MessageAdapter(ArrayList<MessageModel> messageModels) {
        this.messageModelArrayList = messageModels;
    }

    @NonNull
    @Override
    public MessageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message,parent,false);
        return new MessageHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MessageHolder holder, int position) {
      MessageModel messageModel=messageModelArrayList.get(position);
        holder.message.setText(messageModel.getMessage());
    }


    @Override
    public int getItemCount() {
        return messageModelArrayList==null ? 0:messageModelArrayList.size();
    }

    static class MessageHolder extends RecyclerView.ViewHolder{
        MaterialTextView message;
        public MessageHolder(@NonNull View itemView) {
            super(itemView);
            message=itemView.findViewById(R.id.message_textView);
        }
    }
}
