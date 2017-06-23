package com.example.edwardfouxvictorious.randomapifaces.list_activity;

import com.example.edwardfouxvictorious.randomapifaces.list_activity.mvp.RandomFacesPresenter;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface RandomUserSearchRequest {
    @GET(RandomFacesPresenter.URL_PATH)
    Call<RandomUserResponse> getRandomSearchList(@QueryMap Map<String, String> search);
}
