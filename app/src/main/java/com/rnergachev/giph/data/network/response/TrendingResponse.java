package com.rnergachev.giph.data.network.response;

import com.rnergachev.giph.data.model.GiphData;

import java.util.List;

/**
 * Retrofit Trending response
 */
public class TrendingResponse {
    private List<GiphData> data;

    public TrendingResponse() {

    }

    public TrendingResponse(List<GiphData> data) {
        this.data = data;
    }

    public List<GiphData> getData() {
        return data;
    }
}
