package com.example.socialmediaapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {
  List<ResponsePostsItem> postsItems;

 PostAction postAction;
    void setList(List<ResponsePostsItem> postsItems,PostAction postAction){
        this.postsItems=postsItems;
        this.postAction=postAction;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post,parent,false);
        return new PostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        holder.body.setText(postsItems.get(position).getBody());
        holder.title.setText(postsItems.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return postsItems==null? 0:postsItems.size();
    }
    public interface PostAction{
        void postClick(ResponsePostsItem postsItem);
    }
     class PostHolder extends RecyclerView.ViewHolder {
        TextView title,body;

        public PostHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            body=itemView.findViewById(R.id.body);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  // v.getContext().startActivity(new);
                  postAction.postClick(postsItems.get(getLayoutPosition()));

                }
            });
        }
    }
}
