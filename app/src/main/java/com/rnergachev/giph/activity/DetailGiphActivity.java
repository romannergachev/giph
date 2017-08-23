package com.rnergachev.giph.activity;

import com.rnergachev.giph.GiphApplication;
import com.rnergachev.giph.R;
import com.rnergachev.giph.base.BaseActivity;
import com.rnergachev.giph.data.model.GiphData;
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
        vm.giph.set(giph);
        return vm;
    }

    @Override
    protected void onStart() {
        super.onStart();
        getViewModel().loadRandom();
    }

    @Override
    protected void injectDependencies() {
        ((GiphApplication) getApplication()).appComponent.inject(this);
    }
}
