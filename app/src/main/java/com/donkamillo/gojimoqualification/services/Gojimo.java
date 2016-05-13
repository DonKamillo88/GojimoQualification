package com.donkamillo.gojimoqualification.services;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by DonKamillo on 13.05.2016.
 */
public interface Gojimo {

    @GET("/api/v4/qualifications")
    Call<List<GojimoResponse>> getData();
}
