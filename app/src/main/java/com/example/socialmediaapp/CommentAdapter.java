package com.example.socialmediaapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentHolder> {

    List<ResponseComments> commentsList;
    void setComment( List<ResponseComments> commentsList){
        this.commentsList=commentsList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CommentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment ,parent,false);
        return new CommentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentHolder holder, int position) {
      ResponseComments responseComments= commentsList.get(position);
      holder.userName.setText(responseComments.getName());
      holder.comment.setText(responseComments.getBody());
    }

    @Override
    public int getItemCount() {
        return commentsList==null ? 0:commentsList.size();
    }

    static class CommentHolder extends RecyclerView.ViewHolder{
     TextView userName,comment;
        public CommentHolder(@NonNull View itemView) {
            super(itemView);
            userName=itemView.findViewById(R.id.user_name);
            comment=itemView.findViewById(R.id.user_comment);
        }
    }
}
