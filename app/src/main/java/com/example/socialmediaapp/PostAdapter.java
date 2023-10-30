package com.example.socialmediaapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {

    ArrayList<PostModel> postModels;

    public PostAdapter(ArrayList<PostModel> postModels) {
        this.postModels = postModels;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent,false);
        return new PostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        PostModel postModel = postModels.get(position);
        holder.postCaption.setText(postModel.getPostCaption());
        holder.userName.setText(postModel.getUserName());
        holder.userImage.setImageResource(postModel.getUserImage());
        holder.postImage.setImageResource(postModel.getPostImage());
    }

    @Override
    public int getItemCount() {
        return postModels.size();
    }

    static class PostHolder extends RecyclerView.ViewHolder {
        ImageView userImage, postImage;
        TextView userName, postCaption;

        public PostHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.user_name);
            userImage = itemView.findViewById(R.id.user_image);
            postImage = itemView.findViewById(R.id.post_image);
            postCaption = itemView.findViewById(R.id.user_caption);
        }
    }
}
