package com.dimitrios.kaltzidis.onecallapilibrary;

import com.dimitrios.kaltzidis.onecallapilibrary.Models.Request.OneCallApiRequest;
import com.dimitrios.kaltzidis.onecallapilibrary.Models.Request.WeatherPart;
import com.dimitrios.kaltzidis.onecallapilibrary.Models.Response.OneCallApiResponse;
import com.dimitrios.kaltzidis.onecallapilibrary.Utilities.OneCallApiService;
import com.dimitrios.kaltzidis.onecallapilibrary.Utilities.OneCallApiServiceBuilder;

import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OneCallApiClient {

    private String apiKey;

    public OneCallApiClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public void makeOneCallApiRequest(OneCallApiRequest request, OnWeatherResponseReceivedListener callback) {
        OneCallApiService oneCallApiService = OneCallApiServiceBuilder.getOneCallApiService();

        String exclude = null;

        if (request.getExcludeWeatherParts().size() > 0) {
            exclude = request.getExcludeWeatherParts().stream().map(WeatherPart::name)
                    .collect(Collectors.joining(","));
        }

        oneCallApiService.getWeatherForLocation(request.getLatitude(), request.getLongitude(), exclude, request.getMeasurementUnits().name(), request.getLanguage().name(), apiKey).enqueue(new Callback<OneCallApiResponse>() {
            @Override
            public void onResponse(Call<OneCallApiResponse> call, Response<OneCallApiResponse> response) {
                if(response.isSuccessful()){
                    callback.onSuccessfulResponse(response.body());
                    return;
                }

                callback.onFailedResponse(new Throwable(response.message()));
            }

            @Override
            public void onFailure(Call<OneCallApiResponse> call, Throwable t) {
                callback.onFailedResponse(t);
            }
        });    }

}
