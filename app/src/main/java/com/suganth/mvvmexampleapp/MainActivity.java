package com.suganth.mvvmexampleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.suganth.mvvmexampleapp.adapters.RecyclerAdapter;
import com.suganth.mvvmexampleapp.models.NicePlace;
import com.suganth.mvvmexampleapp.viewmodels.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

import static androidx.lifecycle.ViewModelProviders.*;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton cdmFab;
    private RecyclerView mRecyclerView;
    private RecyclerAdapter mAdapter;
    private ProgressBar mProgressBar;
    private MainActivityViewModel mMainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFab = findViewById(R.id.floatingActionButton);
        mRecyclerView = findViewById(R.id.recycler_view);
        mProgressBar = findViewById(R.id.progress_bar);
        mMainActivityViewModel =  ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mMainActivityViewModel.init();
        mMainActivityViewModel.isUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean)
                {
                    showProgressBar();
                }
                else {
                    hideProgressBar();
                    mRecyclerView.smoothScrollToPosition(mMainActivityViewModel.getNicePlace().getValue().size()-1);
                }
            }
        });

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMainActivityViewModel.addNewValue(
                        new NicePlace(
                                "https://i.imgur.com/ZcLLrkY.jpg",
                                "Washington"
                        )
                );
            }
        });

        mMainActivityViewModel.getNicePlace().observe(this, new Observer<List<NicePlace>>() {
            @Override
            public void onChanged(List<NicePlace> nicePlaces) {
                mAdapter.notifyDataSetChanged();
            }
        });

        initRecyclerView();
    }

    private void initRecyclerView()
    {
        mAdapter = new RecyclerAdapter( mMainActivityViewModel.getNicePlace().getValue(),this);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void showProgressBar()
    {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar()
    {
        mProgressBar.setVisibility(View.GONE);
    }
}