package com.example.HeroProject.di.module;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    String baseURL = "https://simplifiedcoding.net/demos/";

    public ApiModule(String baseURL) {
        this.baseURL = baseURL;
    }

    @Provides
    @Singleton
    Cache provideHttpCache(Application application){
        int cacheSize = 10 * 10 * 1024;
        Cache cache = new Cache(application.getCacheDir(),cacheSize);
        return cache;
    }
    @Provides
    @Singleton
    Gson provideGson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    OkHttpClient provideHttpClient(Cache cache){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.cache(cache);
        return builder.build();
    }
    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient){
      Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl(baseURL)
                                .addConverterFactory(GsonConverterFactory.create(gson))
                                .client(okHttpClient)
                                 .build();
      return retrofit;
    }
}
