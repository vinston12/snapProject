package com.example.snapchatcopy.AfterLoginActivity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.snapchatcopy.R;

public class StoryFragment extends Fragment {

    public static StoryFragment newInstance(){
        StoryFragment storyFragment = new StoryFragment();
        return storyFragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.story_fragment, container, false);

    }
}

