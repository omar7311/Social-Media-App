package com.example.socialmediaapp;

import java.util.List;

import retrofit2.Call;

import retrofit2.http.GET;

public interface WebServices {

    @GET("posts")
    Call<List<ResponsePostsItem>> getPosts();
}
