package com.example.edwardfouxvictorious.randomapifaces.list_activity.mvp;

import com.example.edwardfouxvictorious.randomapifaces.list_activity.RandomUserResponse;
import com.example.edwardfouxvictorious.randomapifaces.pojo.RandomFace;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class RandomFacesPresenterTest {

    private RandomSearchView randomSearchView = Mockito.mock(RandomSearchView.class);
    private RandomFacesPresenter randomFacesPresenter;

    @Before
    public void setup() {
        randomFacesPresenter = new RandomFacesPresenter(randomSearchView);
    }

    @Test
    public void onCreateCalled() {
        RandomUserResponse randomUserResponse = Mockito.mock(RandomUserResponse.class);
        List<RandomFace> list = new ArrayList<>();
        Mockito.when(randomUserResponse.getResults()).thenReturn(list);

        randomFacesPresenter.onCreateCalled(randomUserResponse);

        Mockito.verify(randomSearchView, Mockito.times(1)).showResult(list);
    }

    @Test
    public void onCreateCalledWithEmptyData() {
        RandomUserResponse randomUserResponse = Mockito.mock(RandomUserResponse.class);
        Mockito.when(randomUserResponse.getResults()).thenReturn(null);

        randomFacesPresenter.onCreateCalled(randomUserResponse);

        Mockito.verify(randomSearchView, Mockito.times(1)).showResult(Matchers.anyListOf(RandomFace.class));
    }

    @Test
    public void onFaceClicked() {
        RandomFace randomFace = Mockito.mock(RandomFace.class);
        randomFacesPresenter.onFaceClicked(randomFace);

        Mockito.verify(randomSearchView, Mockito.times(1)).openFacePage(randomFace);
    }

    @Test
    public void onSuccessCalled() {
        randomFacesPresenter = Mockito.spy(randomFacesPresenter);
        RandomFacesPresenter.DataLoaderCallback callback = new RandomFacesPresenter.DataLoaderCallback(randomFacesPresenter);
        RandomUserResponse randomUserResponse = Mockito.mock(RandomUserResponse.class);

        callback.onSuccess(randomUserResponse);

        Mockito.verify(randomFacesPresenter, Mockito.times(1)).processResponse(randomUserResponse);
    }

    @Test
    public void onFailedCalled() {
        randomFacesPresenter = Mockito.spy(randomFacesPresenter);
        RandomFacesPresenter.DataLoaderCallback callback = new RandomFacesPresenter.DataLoaderCallback(randomFacesPresenter);
        Throwable throwable = Mockito.mock(Throwable.class);
        Mockito.when(throwable.getMessage()).thenReturn("error message");

        callback.onFailure(null, throwable);

        Mockito.verify(randomFacesPresenter, Mockito.times(1)).showErrorMessage("error message");
    }


}
