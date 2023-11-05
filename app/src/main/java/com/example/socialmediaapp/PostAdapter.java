package com.example.socialmediaapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {
  private static List<ResponsePostsItem> postsItems;

    void setList(List<ResponsePostsItem> postsItems){
        this.postsItems=postsItems;
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

    static class PostHolder extends RecyclerView.ViewHolder {
        TextView title,body;

        public PostHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            body=itemView.findViewById(R.id.body);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(v.getContext(), DetailsPostActivity.class);
                    intent.putExtra("key",postsItems.get(getLayoutPosition()).getId());
                   v.getContext().startActivity(intent);


                }
            });
        }
    }
}
