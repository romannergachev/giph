package com.rnergachev.giph.data.network.response;

import com.rnergachev.giph.data.model.RandomGiphData;

/**
 * Retrofit Random response
 */
public class RandomResponse {
    private RandomGiphData data;

    public RandomResponse() {

    }

    public RandomResponse(RandomGiphData data) {
        this.data = data;
    }

    public RandomGiphData getData() {
        return data;
    }
}
