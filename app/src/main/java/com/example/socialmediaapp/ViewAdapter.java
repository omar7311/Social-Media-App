package com.example.socialmediaapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewAdapter extends FragmentStateAdapter {
    int count;

    public ViewAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, int count) {
        super(fragmentManager, lifecycle);
        this.count = count;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new Chat_Fragment();
            case 1:
                return new Status_Fragment();
            case 2:
                return new Calls_Fragment();
        }
        return new Fragment();
    }

    @Override
    public int getItemCount() {
        return count;
    }
}
