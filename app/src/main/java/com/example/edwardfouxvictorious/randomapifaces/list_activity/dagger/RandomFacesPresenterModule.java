package com.example.edwardfouxvictorious.randomapifaces.list_activity.dagger;

import com.example.edwardfouxvictorious.randomapifaces.ActivityScope;
import com.example.edwardfouxvictorious.randomapifaces.list_activity.MainActivity;
import com.example.edwardfouxvictorious.randomapifaces.list_activity.mvp.RandomSearchView;

import dagger.Module;
import dagger.Provides;

@Module
public class RandomFacesPresenterModule {

    @ActivityScope
    @Provides
    @SuppressWarnings("TypeMayBeWeakened")
    RandomSearchView providesRandomSearchView(MainActivity mainActivity) {
        return mainActivity;
    }
}
