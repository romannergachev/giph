package com.rnergachev.giph.viewmodel;

import com.rnergachev.giph.data.GiphyRepo;
import com.rnergachev.giph.data.model.RandomGiphData;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import io.reactivex.Single;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * {@link DetailGiphViewModel} unit test
 */

@RunWith(MockitoJUnitRunner.class)
public class DetailGiphViewModelUnitTest {

    @Mock
    private GiphyRepo repo;
    private DetailGiphViewModel vm;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        vm = new DetailGiphViewModel(repo);
    }

    @Test
    public void vm_should_load_random() {
        RandomGiphData data = new RandomGiphData();
        when(repo.getRandom())
            .thenReturn(Single.just(data));

        vm.loadRandom();

        verify(repo, atLeastOnce()).getRandom();
    }
}
