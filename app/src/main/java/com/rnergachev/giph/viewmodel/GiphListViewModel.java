package com.rnergachev.giph.viewmodel;

import android.databinding.ObservableArrayList;
import android.util.Log;

import com.rnergachev.giph.base.BaseViewModel;
import com.rnergachev.giph.data.GiphyRepo;
import com.rnergachev.giph.data.model.GiphData;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Giph list view model
 */
public class GiphListViewModel implements BaseViewModel {
    public final ObservableArrayList<GiphData> itemsList;
    private final GiphyRepo repo;
    private final CompositeDisposable subscriptions;

    @Inject
    public GiphListViewModel(GiphyRepo repo) {
        itemsList = new ObservableArrayList<>();
        this.repo = repo;
        this.subscriptions = new CompositeDisposable();
    }

    /**
     * Loads items into list
     */
    public void loadItems() {
        subscriptions.add(repo.getTrending(1).subscribe(
            list -> {
                itemsList.clear();
                itemsList.addAll(list);
            }, e -> Log.e(getClass().getName(), "Update failed", e)
        ));
    }


    @Override
    public void clear() {
        subscriptions.clear();
        subscriptions.dispose();
    }
}
