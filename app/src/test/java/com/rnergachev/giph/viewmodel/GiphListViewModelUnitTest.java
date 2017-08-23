package com.rnergachev.giph.viewmodel;

import com.rnergachev.giph.data.GiphyRepo;
import com.rnergachev.giph.data.model.GiphData;
import com.rnergachev.giph.data.model.RandomGiphData;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import io.reactivex.Single;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * {@link GiphListViewModel} unit test
 */

@RunWith(MockitoJUnitRunner.class)
public class GiphListViewModelUnitTest {
    @Mock
    private GiphyRepo repo;
    private GiphListViewModel vm;
    private ArrayList<GiphData> data;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        vm = new GiphListViewModel(repo);
        data = new ArrayList<>();
        data.add(new GiphData());
        data.add(new GiphData());
    }

    @Test
    public void vm_should_load_trending() throws InterruptedException {
        when(repo.getTrending(anyInt()))
            .thenReturn(Single.just(data));

        vm.loadItems(0);

        verify(repo, atLeastOnce()).getTrending(0);
        assertEquals(2, vm.itemsList.size());
    }
}
