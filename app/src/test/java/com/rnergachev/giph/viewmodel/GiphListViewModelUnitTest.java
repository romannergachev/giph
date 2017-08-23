package com.rnergachev.giph.viewmodel;

import com.rnergachev.giph.data.GiphyRepo;
import com.rnergachev.giph.data.model.RandomGiphData;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

/**
 * {@link GiphListViewModel} unit test
 */

@RunWith(MockitoJUnitRunner.class)
public class GiphListViewModelUnitTest {
    @Mock
    private GiphyRepo repo;
    private GiphListViewModel vm;
    private ArrayList<RandomGiphData> data;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        vm = new GiphListViewModel(repo);
        data = new ArrayList<>();
        data.add(new RandomGiphData());
        data.add(new RandomGiphData());
    }
}
