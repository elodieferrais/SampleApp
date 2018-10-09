package com.elodieferrais.myapplication;


import com.squareup.moshi.Moshi;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class DummyService {

    Observable<DummyObject> getPeople() {

        return new Retrofit
            .Builder()
            .baseUrl("https://swapi.co/api/")
            .addConverterFactory(MoshiConverterFactory.create(new Moshi.Builder().build()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(DummyApi.class)
            .getPeople();
    }
}
