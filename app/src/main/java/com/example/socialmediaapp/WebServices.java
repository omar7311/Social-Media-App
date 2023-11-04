package com.example.socialmediaapp;

import java.util.List;

import retrofit2.Call;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WebServices {

    @GET("posts")
    Call<List<ResponsePostsItem>> getPosts();
    @GET("posts/{id}")
    Call<ResponsePostsItem> getPost(@Path("id") int id);
}
