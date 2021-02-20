package com.dimitrios.kaltzidis.onecallapilibrary.Utilities;


import com.dimitrios.kaltzidis.onecallapilibrary.Models.Response.OneCallApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OneCallApiService {
    @GET("data/2.5/onecall")
    Call<OneCallApiResponse> getWeatherForLocation(@Query("lat") double lat, @Query("lon") double lon, @Query("exclude") String exclude, @Query("units") String units, @Query("lang") String lang, @Query("appid") String appKey);
}
