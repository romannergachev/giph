package com.rnergachev.giph.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rnergachev on 23/08/2017.
 */

public class ImageParams implements Parcelable {

    private String url;
    private int width;
    private int height;

    private ImageParams(String url, int width, int height) {
        this.url = url;
        this.width = width;
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    protected ImageParams(Parcel in) {
        url = in.readString();
        width = in.readInt();
        height = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeInt(width);
        dest.writeInt(height);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ImageParams> CREATOR = new Creator<ImageParams>() {
        @Override
        public ImageParams createFromParcel(Parcel in) {
            return new ImageParams(in);
        }

        @Override
        public ImageParams[] newArray(int size) {
            return new ImageParams[size];
        }
    };
}
