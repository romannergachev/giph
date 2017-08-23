package com.rnergachev.giph.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.rnergachev.giph.GiphApplication;
import com.rnergachev.giph.R;
import com.rnergachev.giph.adapter.GiphListAdapter;
import com.rnergachev.giph.base.BaseActivity;
import com.rnergachev.giph.data.model.GiphData;
import com.rnergachev.giph.data.model.RandomGiphData;
import com.rnergachev.giph.handler.EndlessRecyclerViewScrollListener;
import com.rnergachev.giph.handler.GiphListAdapterHandler;
import com.rnergachev.giph.viewmodel.GiphListViewModel;

/**
 * Giph List activity
 */

public class GiphListActivity extends BaseActivity<GiphListViewModel> implements GiphListAdapterHandler {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RecyclerView view = (RecyclerView) findViewById(R.id.itemsList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        view.setLayoutManager(layoutManager);
        view.setAdapter(new GiphListAdapter(getViewModel(), this));
        view.addOnScrollListener(new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                getViewModel().loadItems(totalItemsCount);
            }
        });
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        if (savedInstanceState == null) {
            getViewModel().loadItems(0);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.giphs_activity;
    }

    @Override
    public void onClick(GiphData giph) {
        Intent intent = new Intent(this, DetailGiphActivity.class);
        intent.putExtra(getString(R.string.detailed_giph), giph);
        startActivity(intent);
    }

    @Override
    protected void injectDependencies() {
        ((GiphApplication) getApplication()).appComponent.inject(this);
    }
}
