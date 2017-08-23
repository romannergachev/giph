package com.rnergachev.giph.data;

import android.content.Context;

import com.rnergachev.giph.R;
import com.rnergachev.giph.data.model.GiphData;
import com.rnergachev.giph.data.model.RandomGiphData;
import com.rnergachev.giph.data.network.GiphyApi;
import com.rnergachev.giph.data.network.response.RandomResponse;
import com.rnergachev.giph.data.network.response.TrendingResponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Main repo
 */
public class GiphyRepo {
    private GiphyApi api;
    private String key;
    private static final int limit = 50;

    @Inject
    public GiphyRepo(GiphyApi api, Context context) {
        this.api = api;
        this.key = context.getString(R.string.key);
    }

    /**
     * Load list of trending giphs
     * @return {@link Single} list of giphs
     */
    public Single<List<GiphData>> getTrending(int offset) {
        return api.getTrending(key, limit, offset).map(TrendingResponse::getData)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * Load random giph
     * @return {@link Single} random giph
     */
    public Single<RandomGiphData> getRandom() {
        return api.getRandom(key)
            .map(RandomResponse::getData)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());

    }
}
