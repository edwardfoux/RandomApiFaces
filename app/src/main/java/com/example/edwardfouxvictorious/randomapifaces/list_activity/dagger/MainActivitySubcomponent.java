package com.example.edwardfouxvictorious.randomapifaces.list_activity.dagger;

import com.example.edwardfouxvictorious.randomapifaces.ActivityScope;
import com.example.edwardfouxvictorious.randomapifaces.list_activity.MainActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ActivityScope
@Subcomponent(modules =
        {
                RandomFacesPresenterModule.class
        })
public interface MainActivitySubcomponent extends AndroidInjector<MainActivity>{
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {}
}
