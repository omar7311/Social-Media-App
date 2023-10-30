package com.example.socialmediaapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.chatHolder> {

    ArrayList<ChatModel> listChat;

    public ChatAdapter(ArrayList<ChatModel> listChat) {
        this.listChat = listChat;
    }

    @NonNull
    @Override
    public chatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat, parent, false);
        return new chatHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull chatHolder holder, int position) {
        ChatModel chatModel = listChat.get(position);
        holder.userNameChat.setText(chatModel.getUserNameChat());
        holder.userImageChat.setImageResource(chatModel.getUserImageChat());
    }


    @Override
    public int getItemCount() {
        return listChat.size();
    }

    static class chatHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView userNameChat;
        ImageView userImageChat;


        public chatHolder(@NonNull View itemView) {
            super(itemView);
            userImageChat = itemView.findViewById(R.id.user_image_chat);
            userNameChat = itemView.findViewById(R.id.user_name_chat);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            v.getContext().startActivity(new Intent(v.getContext(), ChatActivity.class));

        }

    }
}
