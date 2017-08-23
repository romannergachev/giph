package com.rnergachev.giph.data.network.response;

import com.rnergachev.giph.data.model.GiphData;

import java.util.ArrayList;
import java.util.List;

/**
 * Retrofit Trending response
 */
public class TrendingResponse {

    private static class Description {

        private GiphData images;

        Description(GiphData images) {
            this.images = images;
        }

        public GiphData getData() {
            return images;
        }
    }

    private List<Description> data;

    public TrendingResponse() {

    }

    public TrendingResponse(List<Description> data) {
        this.data = data;
    }

    public List<GiphData> getData() {
        ArrayList<GiphData> result = new ArrayList<>(data.size());
        for (Description description : data) {
            result.add(description.getData());
        }

        return result;
    }
}
