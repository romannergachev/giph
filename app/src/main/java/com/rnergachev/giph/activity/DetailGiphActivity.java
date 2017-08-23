package com.rnergachev.giph.activity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.databinding.Observable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.rnergachev.giph.GiphApplication;
import com.rnergachev.giph.R;
import com.rnergachev.giph.base.BaseActivity;
import com.rnergachev.giph.data.model.GiphData;
import com.rnergachev.giph.data.model.RandomGiphData;
import com.rnergachev.giph.viewmodel.DetailGiphViewModel;

/**
 * Giph Activity
 */

public class DetailGiphActivity extends BaseActivity<DetailGiphViewModel> {
    @Override
    protected int getLayoutId() {
        return R.layout.detail_activity;
    }

    @Override
    protected DetailGiphViewModel createViewModel() {
        GiphData giph = getIntent().getParcelableExtra(getString(R.string.detailed_giph));
        DetailGiphViewModel vm = viewModelProvider.get();
        vm.giph.set(new RandomGiphData(giph.getOriginal().getUrl(), "", ""));
        return vm;
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        if (savedInstanceState == null) {
            getViewModel().loadRandom();
        }
    }

    @Override
    protected void injectDependencies() {
        ((GiphApplication) getApplication()).appComponent.inject(this);
    }
}
