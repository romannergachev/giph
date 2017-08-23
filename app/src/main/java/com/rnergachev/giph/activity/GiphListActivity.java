package com.rnergachev.giph.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rnergachev.giph.GiphApplication;
import com.rnergachev.giph.R;
import com.rnergachev.giph.adapter.GiphListAdapter;
import com.rnergachev.giph.base.BaseActivity;
import com.rnergachev.giph.data.model.GiphData;
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
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(new GiphListAdapter(getViewModel(), this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        getViewModel().loadItems();
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
