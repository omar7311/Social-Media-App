package com.example.socialmediaapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
RecyclerView recyclerView;
ArrayList<PostModel> posts=new ArrayList<>();
    public HomeFragment() {
        // Required empty public constructor
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
        recyclerView=view.findViewById(R.id.recycle_posts);
        addFakeData();
        setUpRecyclerView();

    }
    private void setUpRecyclerView(){
        PostAdapter adapter=new PostAdapter(posts);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
    private void addFakeData(){
        posts.add(new PostModel(R.drawable.donut,R.drawable.mascot_1,
                "asdasdasdasdadasdadadadacxvxcvvvvvvvvvvvvvvvvvvvvv","omar ahmed"));
        posts.add(new PostModel(R.drawable.donut,R.drawable.mascot_1,
                "asdasdasdasdadasdadadadacxvxcvvvvvvvvvvvvvvvvvvvvv","omar ahmed"));
        posts.add(new PostModel(R.drawable.donut,R.drawable.mascot_1,
                "asdasdasdasdadasdadadadacxvxcvvvvvvvvvvvvvvvvvvvvv","omar ahmed"));
        posts.add(new PostModel(R.drawable.donut,R.drawable.mascot_1,
                "asdasdasdasdadasdadadadacxvxcvvvvvvvvvvvvvvvvvvvvv","omar ahmed"));
        posts.add(new PostModel(R.drawable.donut,R.drawable.mascot_1,
                "asdasdasdasdadasdadadadacxvxcvvvvvvvvvvvvvvvvvvvvv","omar ahmed"));
        posts.add(new PostModel(R.drawable.donut,R.drawable.mascot_1,
                "asdasdasdasdadasdadadadacxvxcvvvvvvvvvvvvvvvvvvvvv","omar ahmed"));
    }
}