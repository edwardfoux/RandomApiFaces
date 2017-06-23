package com.example.edwardfouxvictorious.randomapifaces.list_activity.dagger;


import android.app.Activity;

import com.example.edwardfouxvictorious.randomapifaces.list_activity.MainActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents =
        {
                MainActivitySubcomponent.class
        })
public abstract class RandomFacesBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity>
    bindMainActivityInjectorFactory(MainActivitySubcomponent.Builder builder);
}