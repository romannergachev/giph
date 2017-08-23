package com.rnergachev.giph.data.network;

import com.rnergachev.giph.data.network.response.RandomResponse;
import com.rnergachev.giph.data.network.response.TrendingResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Retrofit api definition
 */
public interface GiphyApi {
    /**
     * Returns trending gifs
     *
     * @return {@link Single< TrendingResponse >}
     */
    @GET("trending")
    Single<TrendingResponse> getTrending(@Query("api_key") String key, @Query("limit") int limit, @Query("offset") int offset);

    /**
     * Returns random gif
     *
     * @return {@link Single< RandomResponse >}
     */
    @GET("random")
    Single<RandomResponse> getRandom(@Query("api_key") String key);
}
