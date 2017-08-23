package com.rnergachev.giph.data;

import android.content.Context;

import com.rnergachev.giph.data.model.GiphData;
import com.rnergachev.giph.data.model.RandomGiphData;
import com.rnergachev.giph.data.network.GiphyApi;
import com.rnergachev.giph.data.network.response.RandomResponse;
import com.rnergachev.giph.data.network.response.TrendingResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.Schedulers;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

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

    @Test
    public void repo_should_get_trending() {
        List<TrendingResponse.Description> descriptions = new ArrayList<>();
        descriptions.add(new TrendingResponse.Description(new GiphData()));
        descriptions.add(new TrendingResponse.Description(new GiphData()));
        TrendingResponse response = new TrendingResponse(descriptions);

        when(api.getTrending(anyString(), anyInt(), anyInt()))
            .thenReturn(Single.just(response));

        TestObserver<List<GiphData>> testObserver = repo.getTrending(0).test();
        testObserver
            .awaitTerminalEvent();
        testObserver
            .assertNoErrors()
            .assertValue(val -> val.size() == 2);
    }

    @Test
    public void repo_should_get_random() {
        RandomResponse response = new RandomResponse(new RandomGiphData("url", "smallUrl", "smallStillUrl"));

        when(api.getRandom(anyString()))
            .thenReturn(Single.just(response));

        TestObserver<RandomGiphData> testObserver = repo.getRandom().test();
        testObserver
            .awaitTerminalEvent();
        testObserver
            .assertNoErrors()
            .assertValue(val -> val.getSmallStillUrl().equals(response.getData().getSmallStillUrl()));
    }



    @After
    public void cleanUp() {
        RxAndroidPlugins.reset();
    }
}
