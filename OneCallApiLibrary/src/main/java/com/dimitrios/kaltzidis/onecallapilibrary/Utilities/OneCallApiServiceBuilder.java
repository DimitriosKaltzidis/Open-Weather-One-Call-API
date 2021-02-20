package com.dimitrios.kaltzidis.onecallapilibrary.Utilities;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OneCallApiServiceBuilder {

    public static OneCallApiService getOneCallApiService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

         return retrofit.create(OneCallApiService.class);
    }
}
