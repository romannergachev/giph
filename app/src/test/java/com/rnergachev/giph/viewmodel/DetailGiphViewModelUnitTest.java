package com.rnergachev.giph.viewmodel;

import com.rnergachev.giph.data.GiphyRepo;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

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
}
