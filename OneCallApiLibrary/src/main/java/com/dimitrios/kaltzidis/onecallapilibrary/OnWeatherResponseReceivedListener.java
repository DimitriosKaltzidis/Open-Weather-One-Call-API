package com.dimitrios.kaltzidis.onecallapilibrary;

import com.dimitrios.kaltzidis.onecallapilibrary.Models.Response.OneCallApiResponse;

public interface OnWeatherResponseReceivedListener {

    void onSuccessfulResponse(OneCallApiResponse response);

    void onFailedResponse(Throwable t);
}
