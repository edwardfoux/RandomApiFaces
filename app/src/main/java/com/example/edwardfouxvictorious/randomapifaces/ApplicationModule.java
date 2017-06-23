package com.example.edwardfouxvictorious.randomapifaces;


import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private RandomFacesApplication randomFacesApplication;

    public ApplicationModule(RandomFacesApplication randomFacesApplication) {
        this.randomFacesApplication = randomFacesApplication;
    }

    @Singleton
    @Provides
    @Named("application.context")
    Context providesContext() {
        return randomFacesApplication.getApplicationContext();
    }
}
