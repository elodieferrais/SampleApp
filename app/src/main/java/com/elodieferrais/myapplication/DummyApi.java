package com.elodieferrais.myapplication;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface DummyApi {
    @GET("people")
    Observable<DummyObject> getPeople();
}
