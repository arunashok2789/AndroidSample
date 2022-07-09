package com.example.HeroProject.di.component;

import com.example.HeroProject.activity.MainActivity;
import com.example.HeroProject.di.module.ApiModule;
import com.example.HeroProject.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;
@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
}
