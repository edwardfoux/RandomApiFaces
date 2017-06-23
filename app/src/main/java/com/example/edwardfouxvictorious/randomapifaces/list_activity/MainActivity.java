package com.example.edwardfouxvictorious.randomapifaces.list_activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.edwardfouxvictorious.randomapifaces.face_activity.FaceActivity;
import com.example.edwardfouxvictorious.randomapifaces.R;
import com.example.edwardfouxvictorious.randomapifaces.list_activity.mvp.RandomFacesPresenter;
import com.example.edwardfouxvictorious.randomapifaces.list_activity.mvp.RandomSearchView;
import com.example.edwardfouxvictorious.randomapifaces.pojo.RandomFace;

import java.util.List;

public class MainActivity extends AppCompatActivity implements RandomSearchView {
    public static final String DATA = "data";
    public static final String ERROR_401 = "401";
    public static final String ERROR_500 = "500";

    private RecyclerView recyclerView;
    private RandomFacesPresenter albumSearchPresenter;
    private RandomFacesAdapter albumSearchAdapter;
    private View progressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.random_face_activity);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        progressView = findViewById(R.id.progress_view);

        albumSearchPresenter = new RandomFacesPresenter(this);
        albumSearchAdapter = new RandomFacesAdapter(new ItemCLickListener(albumSearchPresenter));


        recyclerView.setAdapter(albumSearchAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        if(!isConnectedToInternet()) {
            Toast.makeText(this, R.string.no_internet, Toast.LENGTH_SHORT).show();
            return ;
        }

        if (savedInstanceState != null) {
            RandomUserResponse randomUserResponse = savedInstanceState.getParcelable(DATA);
            albumSearchPresenter.onCreateCalled(randomUserResponse);
        } else {
            albumSearchPresenter.provideSearchResults();
        }
    }

    /**
     * Persists the state of the list during the screen rotation
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        RandomUserResponse randomUserResponse = new RandomUserResponse();
        randomUserResponse.setResults(albumSearchAdapter.getList());
        outState.putParcelable(DATA, randomUserResponse);
    }

    @Override
    public void showResult(List<RandomFace> albumList) {
        albumSearchAdapter.setList(albumList);
        albumSearchAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMessage(String message) {
        String errorMessage;
        switch (message) {
            case ERROR_401: errorMessage = getResources().getString(R.string.error_401);
                break;
            case ERROR_500: errorMessage = getResources().getString(R.string.error_500);
                break;
            default:
                errorMessage = getResources().getString(R.string.error_default);
        }
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void openFacePage(RandomFace randomFace) {
        Intent intent = new Intent(MainActivity.this, FaceActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(FaceActivity.FACE, randomFace);
        intent.putExtras(bundle);

        startActivity(intent);
    }

    @Override
    public void showProgressView() {
        progressView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressView() {
        progressView.setVisibility(View.GONE);
    }

    private boolean isConnectedToInternet() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

    }

    private static class ItemCLickListener implements RandomFacesAdapter.ItemClickListener {
        RandomFacesPresenter randomFacesPresenter;

        public ItemCLickListener(RandomFacesPresenter randomFacesPresenter) {
            this.randomFacesPresenter = randomFacesPresenter;
        }

        @Override
        public void onItemCLicked(RandomFace randomFace) {
            randomFacesPresenter.onFaceClicked(randomFace);
        }
    }
}
