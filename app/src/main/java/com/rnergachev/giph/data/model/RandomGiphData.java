package com.rnergachev.giph.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Giph content
 */
public class RandomGiphData {
    @SerializedName("image_original_url")
    private String originalUrl;
    @SerializedName("fixed_height_small_still_url")
    private String smallStillUrl;

    public RandomGiphData() {}

    public RandomGiphData(String originalUrl, String smallUrl, String smallStillUrl) {
        this.originalUrl = originalUrl;
        this.smallStillUrl = smallStillUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public String getSmallStillUrl() {
        return smallStillUrl;
    }
}
