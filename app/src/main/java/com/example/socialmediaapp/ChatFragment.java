package com.example.socialmediaapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

public class ChatFragment extends Fragment {
    ViewAdapter viewAdapter;
    TabLayout tabLayout;
    ViewPager2 viewPager;

    public ChatFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        iniUI(view);
       setUpTabLayout();
    }
    private void iniUI(View view){
        tabLayout = view.findViewById(R.id.tab_layout);
        viewPager = view.findViewById(R.id.view_pager);
        viewAdapter = new ViewAdapter(getChildFragmentManager(), this.getLifecycle(), 3);
    }
    private void setUpTabLayout(){
        viewPager.setAdapter(viewAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
       viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
          @Override
           public void onPageSelected(int position) {
              super.onPageSelected(position);
               tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
    }
}