package com.rnergachev.giph;

import android.app.Application;
import android.databinding.DataBindingUtil;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.rnergachev.giph.binding.GiphDataBindingComponent;
import com.rnergachev.giph.di.ApplicationComponent;
import com.rnergachev.giph.di.ApplicationModule;
import com.rnergachev.giph.di.DaggerApplicationComponent;
import com.squareup.picasso.Picasso;

/**
 * Application class, used to include dagger, picasso and define default data binding component
 */

public class GiphApplication extends Application {

    public ApplicationComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();

        Picasso picasso = new Picasso.Builder(this)
            .downloader(new OkHttp3Downloader(this, Integer.MAX_VALUE))
            .indicatorsEnabled(false)
            .loggingEnabled(false)
            .build();
        Picasso.setSingletonInstance(picasso);
        DataBindingUtil.setDefaultComponent(new GiphDataBindingComponent());
    }

}