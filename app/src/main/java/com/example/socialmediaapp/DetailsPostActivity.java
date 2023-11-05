package com.example.socialmediaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsPostActivity extends AppCompatActivity {
    TextView id, userId, title, body;
    RecyclerView recyclerView;
    CommentAdapter commentAdapter=new CommentAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_post);
        init();
        int postId=getIntent().getIntExtra("key",0);
       getPostDetails(postId);
        getComemnts(postId);
    }
    void getPostDetails(int postId){
        RetrofitClient.getService().getPost(postId).enqueue(new Callback<ResponsePostsItem>() {
            @Override
            public void onResponse(Call<ResponsePostsItem> call, Response<ResponsePostsItem> response) {

                if(response.isSuccessful()) bindUi(response.body());
            }

            @Override
            public void onFailure(Call<ResponsePostsItem> call, Throwable t) {

            }
        });
    }
    void getComemnts(int postId){
        RetrofitClient.getService().getComments(postId).enqueue(new Callback<List<ResponseComments>>() {
            @Override
            public void onResponse(Call<List<ResponseComments>> call, Response<List<ResponseComments>> response) {
                if(response.isSuccessful()) setupRecycle(response.body());
            }

            @Override
            public void onFailure(Call<List<ResponseComments>> call, Throwable t) {

            }
        });
    }
    void init() {
        id = findViewById(R.id.id);
        userId = findViewById(R.id.user_id);
        title = findViewById(R.id.title);
        body = findViewById(R.id.body);
        recyclerView=findViewById(R.id.recycle_comments);
    }
    void bindUi(ResponsePostsItem responsePostsItem){
        id.setText(String.valueOf(responsePostsItem.getId()));
        userId.setText(String.valueOf(responsePostsItem.getUserId()));
        title.setText(responsePostsItem.getTitle());
        body.setText(responsePostsItem.getBody());

    }
    void setupRecycle(List<ResponseComments> responseComments){
        commentAdapter.setComment(responseComments);
        recyclerView.setAdapter(commentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}