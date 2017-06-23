package com.example.edwardfouxvictorious.randomapifaces;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Abstract class for the network
 * @param <T>
 */
public abstract class ApiCallback<T> implements Callback<T> {
    public ApiCallback() {
        super();
    }

    public abstract void onSuccess(T response);

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        onSuccess(response.body());
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {

    }
}
