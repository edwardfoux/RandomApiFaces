package com.example.edwardfouxvictorious.randomapifaces.list_activity.mvp;

import com.example.edwardfouxvictorious.randomapifaces.pojo.RandomFace;

import java.util.List;

public interface RandomSearchView {
    void showResult(List<RandomFace> randomFaceList);
    void showProgressView();
    void hideProgressView();
    void showErrorMessage(String message);
    void openFacePage(RandomFace randomFace);
}
