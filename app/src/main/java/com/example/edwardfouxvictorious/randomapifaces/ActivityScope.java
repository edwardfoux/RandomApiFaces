package com.example.edwardfouxvictorious.randomapifaces;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 *  Custom scope definition for Dagger2 usage. Signifies components are 'singletons' for the life of
 *  a given Android {@code Activity}
 *
 *  Allows non-singleton components involved in a specific feature to depend on {@code @Singleton}
 *  annotated components.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {}
