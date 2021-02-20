package com.dimitrios.kaltzidis.openweathermaponecallapiclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.dimitrios.kaltzidis.onecallapilibrary.Models.Request.Language;
import com.dimitrios.kaltzidis.onecallapilibrary.Models.Request.MeasurementUnit;
import com.dimitrios.kaltzidis.onecallapilibrary.Models.Request.OneCallApiRequest;
import com.dimitrios.kaltzidis.onecallapilibrary.Models.Request.WeatherPart;
import com.dimitrios.kaltzidis.onecallapilibrary.Models.Response.OneCallApiResponse;
import com.dimitrios.kaltzidis.onecallapilibrary.OnWeatherResponseReceivedListener;
import com.dimitrios.kaltzidis.onecallapilibrary.OneCallApiClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OneCallApiClient oneCallApiClient = new OneCallApiClient("YOUR_API_KEY_HERE");
        OneCallApiRequest oneCallApiRequest = new OneCallApiRequest.Builder(37.971580, 23.726766)
                .unit(MeasurementUnit.metric)
                .lang(Language.el)
                .exlude(WeatherPart.minutely)
                .exlude(WeatherPart.daily)
                .build();

        oneCallApiClient.makeOneCallApiRequest(oneCallApiRequest, new OnWeatherResponseReceivedListener() {
            @Override
            public void onSuccessfulResponse(OneCallApiResponse response) {
                Log.e("MainActivity", ""+ response.getCurrent().getFeelsLike());
            }

            @Override
            public void onFailedResponse(Throwable t) {
                Log.e("MainActivity", t.getMessage());
            }
        });
    }
}