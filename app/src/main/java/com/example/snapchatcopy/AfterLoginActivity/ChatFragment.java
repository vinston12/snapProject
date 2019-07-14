package com.example.snapchatcopy.AfterLoginActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.snapchatcopy.R;

public class ChatFragment extends Fragment {


    private View PrivateChatView;
    private RecyclerView recyclerView;

    public static ChatFragment newInstance(){
       ChatFragment chatFragment = new ChatFragment();
       return chatFragment;
    }
    public ChatFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       PrivateChatView =  inflater.inflate(R.layout.chat_fragment, container, false);


       recyclerView = (RecyclerView) PrivateChatView.findViewById(R.id.ChatDialogsList);
       recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
       //xd

       return PrivateChatView;

    }
}


