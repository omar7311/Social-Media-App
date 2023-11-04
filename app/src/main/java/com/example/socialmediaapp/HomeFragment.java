package com.example.socialmediaapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment  {
    RecyclerView recyclerView;
    PostAdapter postAdapter = new PostAdapter();

    public HomeFragment() {
        // Required empty public constructor
    }

    private void getPosts() {
        RetrofitClient.getService().getPosts().enqueue(new Callback<List<ResponsePostsItem>>() {
            @Override
            public void onResponse(Call<List<ResponsePostsItem>> call, Response<List<ResponsePostsItem>> response) {
                if (response.isSuccessful()) {
                    Log.d("tag", "response success");
                    postAdapter.setList(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<ResponsePostsItem>> call, Throwable t) {

            }
        });
        Log.d("tag", "after callback");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPosts();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycle_posts);
        recyclerView.setAdapter(postAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}


