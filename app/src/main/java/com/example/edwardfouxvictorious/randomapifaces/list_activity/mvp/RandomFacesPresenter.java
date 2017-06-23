package com.example.edwardfouxvictorious.randomapifaces.list_activity.mvp;

import android.support.annotation.VisibleForTesting;

import com.example.edwardfouxvictorious.randomapifaces.ApiCallback;
import com.example.edwardfouxvictorious.randomapifaces.list_activity.RandomUserResponse;
import com.example.edwardfouxvictorious.randomapifaces.list_activity.RandomUserSearchRequest;
import com.example.edwardfouxvictorious.randomapifaces.pojo.RandomFace;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class RandomFacesPresenter {

    private static final String BASE_URL = "https://randomuser.me/";
    public static final String URL_PATH = "api/";
    private static final String RESULT = "results";
    private static final String ITEMS_PER_PAGE = "10";

    @VisibleForTesting
    RandomSearchView randomSearchView;

    public RandomFacesPresenter(RandomSearchView randomSearchView) {
        this.randomSearchView = randomSearchView;
    }

    public void onCreateCalled(RandomUserResponse randomUserResponse) {
        processResponse(randomUserResponse);
    }

    public void provideSearchResults() {
        randomSearchView.showProgressView();
        getData();
    }

    private void getData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RandomUserSearchRequest randomUserSearchRequest = retrofit.create(RandomUserSearchRequest.class);

        Map<String, String> map = new HashMap<>();
        map.put(RESULT, ITEMS_PER_PAGE);
        Call<RandomUserResponse> call = randomUserSearchRequest.getRandomSearchList(map);

        call.enqueue(new DataLoaderCallback(this));
    }

    private void processResponse(RandomUserResponse response) {
        randomSearchView.hideProgressView();

        List<RandomFace> albumList = response.getResults();
        if (albumList == null) {
            randomSearchView.showResult(new ArrayList<RandomFace>());
        } else {
            randomSearchView.showResult(response.getResults());
        }
    }

    public void onFaceClicked(RandomFace randomFace) {
        randomSearchView.openFacePage(randomFace);
    }

    private void showErrorMessage(String message) {
        randomSearchView.showErrorMessage(message);
    }

    @VisibleForTesting
    static class DataLoaderCallback extends ApiCallback<RandomUserResponse> {
        WeakReference<RandomFacesPresenter> ref;

        @VisibleForTesting
        DataLoaderCallback(RandomFacesPresenter
                                   presenter) {
            this.ref = new WeakReference<>(presenter);
        }

        @Override
        public void onSuccess(RandomUserResponse response) {
            RandomFacesPresenter albumSearchPresenter = ref.get();
            if (albumSearchPresenter == null) return;

            albumSearchPresenter.processResponse(response);
        }

        @Override
        public void onFailure(Throwable t) {
            RandomFacesPresenter randomFacesPresenter = ref.get();
            if (randomFacesPresenter == null) return;

            randomFacesPresenter.processResponse(new RandomUserResponse());
            if (t != null) {
                randomFacesPresenter.showErrorMessage(t.getMessage());
            }
        }
    }
}