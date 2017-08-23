package com.rnergachev.giph.di;

import com.rnergachev.giph.activity.DetailGiphActivity;
import com.rnergachev.giph.activity.GiphListActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Application component for dagger
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(GiphListActivity activity);
    void inject(DetailGiphActivity activity);
}
