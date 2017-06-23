package com.example.edwardfouxvictorious.randomapifaces;


import com.example.edwardfouxvictorious.randomapifaces.list_activity.dagger.RandomFacesBindingModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component( modules =
        {
                // Application Scope modules
                AndroidSupportInjectionModule.class,
                ApplicationModule.class,

                // Activity subcomponent binding modules
                RandomFacesBindingModule.class,
        })
public interface ApplicationComponent {

    void inject(RandomFacesApplication randomFacesApplication);
}
