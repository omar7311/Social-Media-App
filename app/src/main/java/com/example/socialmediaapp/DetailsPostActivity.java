package com.example.socialmediaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsPostActivity extends AppCompatActivity {
    TextView id, userId, title, body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_post);
        init();
        int postId=getIntent().getIntExtra("key",0);
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
    void init() {
        id = findViewById(R.id.id);
        userId = findViewById(R.id.user_id);
        title = findViewById(R.id.title);
        body = findViewById(R.id.body);
    }
    void bindUi(ResponsePostsItem responsePostsItem){
        id.setText(String.valueOf(responsePostsItem.getId()));
        userId.setText(String.valueOf(responsePostsItem.getUserId()));
        title.setText(responsePostsItem.getTitle());
        body.setText(responsePostsItem.getBody());

    }
}