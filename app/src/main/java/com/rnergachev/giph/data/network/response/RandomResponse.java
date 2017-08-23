package com.rnergachev.giph.data.network.response;

import com.rnergachev.giph.data.model.GiphData;

/**
 * Retrofit Random response
 */
public class RandomResponse {
    private GiphData data;

    public RandomResponse() {

    }

    public RandomResponse(GiphData data) {
        this.data = data;
    }

    public GiphData getData() {
        return data;
    }
}
