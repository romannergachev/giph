package com.rnergachev.giph.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Giph content
 */
public class GiphData implements Parcelable {
    @SerializedName("image_original_url")
    private String originalUrl;
    @SerializedName("fixed_height_small_url")
    private String smallUrl;
    @SerializedName("fixed_height_small_still_url")
    private String smallStillUrl;

    public GiphData() {}

    public GiphData(String originalUrl, String smallUrl, String smallStillUrl) {
        this.originalUrl = originalUrl;
        this.smallUrl = smallUrl;
        this.smallStillUrl = smallStillUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public String getSmallUrl() {
        return smallUrl;
    }

    public String getSmallStillUrl() {
        return smallStillUrl;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.originalUrl);
        dest.writeString(this.smallUrl);
        dest.writeString(this.smallStillUrl);
    }

    protected GiphData(Parcel in) {
        this.originalUrl = in.readString();
        this.smallUrl = in.readString();
        this.smallStillUrl = in.readString();
    }

    public static final Creator<GiphData> CREATOR = new Creator<GiphData>() {
        @Override
        public GiphData createFromParcel(Parcel source) {
            return new GiphData(source);
        }

        @Override
        public GiphData[] newArray(int size) {
            return new GiphData[size];
        }
    };
}
