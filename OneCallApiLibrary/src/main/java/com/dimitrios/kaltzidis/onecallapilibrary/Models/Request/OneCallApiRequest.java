package com.dimitrios.kaltzidis.onecallapilibrary.Models.Request;

import java.util.ArrayList;

public class OneCallApiRequest {
    private double latitude, longitude;
    private MeasurementUnit units;
    private ArrayList<WeatherPart> exclude = new ArrayList<>();
    private Language lang;

    private OneCallApiRequest() {
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public MeasurementUnit getMeasurementUnits() {
        return units;
    }

    public ArrayList<WeatherPart> getExcludeWeatherParts() {
        return exclude;
    }

    public Language getLanguage() {
        return lang;
    }

    public static class Builder{

        private double latitude, longitude;
        private MeasurementUnit units = MeasurementUnit.metric;
        private ArrayList<WeatherPart> exclude = new ArrayList<>();
        private Language lang = Language.en;

        public Builder(double latitude, double longitude){
            this.latitude = latitude;
            this.longitude = longitude;
        }

        /** Sets the measurement units of the results. Default is metric.
         * @param units  The results measurement units
         * @return self
         */
        public Builder unit(MeasurementUnit units){
            this.units = units;

            return this;
        }

        /** Sets the language of the results. Default is english.
         * @param language  The results language
         * @return self
         */
        public Builder lang(Language language){
            this.lang =language;

            return this;
        }

        /** Adds a weather part to exclude from response. Do exclude the same weather part twice.
         * @param weatherPart  The weather part to exclude from response
         * @return self
         */
        public Builder exlude(WeatherPart weatherPart){
            this.exclude.add(weatherPart);

            return this;
        }

        public OneCallApiRequest build(){
            OneCallApiRequest oneCallApiRequest = new OneCallApiRequest();
            oneCallApiRequest.exclude = this.exclude;
            oneCallApiRequest.lang = this.lang;
            oneCallApiRequest.latitude = this.latitude;
            oneCallApiRequest.longitude = this.longitude;
            oneCallApiRequest.units = this.units;

            return oneCallApiRequest;
        }
    }
}
