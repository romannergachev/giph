package com.rnergachev.giph.viewmodel;

import android.databinding.ObservableField;
import android.util.Log;

import com.rnergachev.giph.base.BaseViewModel;
import com.rnergachev.giph.data.GiphyRepo;
import com.rnergachev.giph.data.model.GiphData;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Detail giph view model
 */
public class DetailGiphViewModel implements BaseViewModel {
    public ObservableField<GiphData> giph;
    private final GiphyRepo repo;
    private final CompositeDisposable subscriptions;

    @Inject
    public DetailGiphViewModel(GiphyRepo repo) {
        this.giph = new ObservableField<>(new GiphData());
        this.repo = repo;
        this.subscriptions = new CompositeDisposable();
    }

    /**
     * Loads random giph
     */
    public void loadRandom() {
        subscriptions.add(repo.getRandom().subscribe(
            giph -> this.giph.set(giph),
            e -> Log.e(getClass().getName(), "Update failed", e)
        ));
    }

    @Override
    public void clear() {
        subscriptions.clear();
        subscriptions.dispose();
    }
}
