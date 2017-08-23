package com.rnergachev.giph.data;

import android.content.Context;

import com.rnergachev.giph.data.network.GiphyApi;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;

/**
 * {@link GiphyRepo} unit test
 */

@RunWith(MockitoJUnitRunner.class)
public class GiphyRepoUnitTest {
    @Mock
    private GiphyApi api;
    @Mock
    Context context;
    private GiphyRepo repo;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        repo = new GiphyRepo(api, context);
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(__ -> Schedulers.trampoline());
    }

    @After
    public void cleanUp() {
        RxAndroidPlugins.reset();
    }
}
