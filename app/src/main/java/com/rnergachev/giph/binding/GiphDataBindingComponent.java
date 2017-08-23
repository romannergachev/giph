package com.rnergachev.giph.binding;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingComponent;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.rnergachev.giph.data.model.ImageParams;
import com.squareup.picasso.Picasso;

/**
 * Binding component for Picasso
 */

public class GiphDataBindingComponent implements DataBindingComponent {
    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, ImageParams params) {
        Picasso.with(view.getContext()).load(params.getUrl()).into(view);
    }

    @BindingAdapter({"gifUrl"})
    public static void loadGif(ImageView view, String url) {
        Glide.with(view.getContext()).asGif().load(url).into(view);
    }
}
