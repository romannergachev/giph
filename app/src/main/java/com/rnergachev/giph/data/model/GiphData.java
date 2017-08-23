package com.rnergachev.giph.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Giph content
 */
public class GiphData implements Parcelable {

    @SerializedName("original")
    private ImageParams original;
    @SerializedName("original_still")
    private ImageParams smallStill;

    public GiphData() {}

    public GiphData(ImageParams originalUrl, ImageParams smallUrl, ImageParams smallStillUrl) {
        this.original = originalUrl;
        this.smallStill = smallStillUrl;
    }

    public ImageParams getOriginal() {
        return original;
    }

    public ImageParams getSmallStill() {
        return smallStill;
    }

    protected GiphData(Parcel in) {
        original = in.readParcelable(ImageParams.class.getClassLoader());
        smallStill = in.readParcelable(ImageParams.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(original, flags);
        dest.writeParcelable(smallStill, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<GiphData> CREATOR = new Creator<GiphData>() {
        @Override
        public GiphData createFromParcel(Parcel in) {
            return new GiphData(in);
        }

        @Override
        public GiphData[] newArray(int size) {
            return new GiphData[size];
        }
    };
}
