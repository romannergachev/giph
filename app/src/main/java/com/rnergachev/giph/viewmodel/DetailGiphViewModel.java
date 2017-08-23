package com.rnergachev.giph.viewmodel;

import android.databinding.ObservableField;
import android.util.Log;

import com.rnergachev.giph.base.BaseViewModel;
import com.rnergachev.giph.data.GiphyRepo;
import com.rnergachev.giph.data.model.RandomGiphData;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Detail giph view model
 */
public class DetailGiphViewModel implements BaseViewModel {
    public ObservableField<RandomGiphData> giph;
    private final GiphyRepo repo;
    private final CompositeDisposable subscriptions;

    @Inject
    public DetailGiphViewModel(GiphyRepo repo) {
        this.giph = new ObservableField<>();
        this.repo = repo;
        this.subscriptions = new CompositeDisposable();
    }

    /**
     * Loads random giph
     */
    public void loadRandom() {
        subscriptions.add(repo.getRandom().delay(10, TimeUnit.SECONDS).subscribe(
            giph -> {
                this.giph.set(giph);
                loadRandom();
            },
            e -> Log.e(getClass().getName(), "Update failed", e)
        ));
    }

    @Override
    public void clear() {
        subscriptions.dispose();
    }
}
