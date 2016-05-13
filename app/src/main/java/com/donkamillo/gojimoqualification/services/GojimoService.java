package com.donkamillo.gojimoqualification.services;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by DonKamillo on 13.05.2016.
 */
public class GojimoService {
    private static final String API_URL = "https://api.gojimo.net";

    public static Gojimo getService() {
        return new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(Gojimo.class);
    }
}
