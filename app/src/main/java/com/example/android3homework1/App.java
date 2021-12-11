package com.example.android3homework1;

import android.app.Application;

import com.example.android3homework1.data.remote.FilmApi;
import com.example.android3homework1.data.remote.RetrofitClient;

public class App extends Application {
    private RetrofitClient retrofitClient;
    public static FilmApi api;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = new RetrofitClient();
        api = retrofitClient.provideFilmApi();
    }
}
