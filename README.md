# OpenWeather, OneCallAPI

This is an android library to get the weather forecaset from OpenWeather using their [OneCall API](https://openweathermap.org/api/one-call-api).

## Install the library

To get the library into your build:

### Gradle

#### Step 1. Add the JitPack repository to your build file

````
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
````

#### Step 2. Add the dependency

````
	dependencies {
	        implementation 'com.github.DimitrisKaltzidis:Open-Weather-One-Call-API:Version'
	}
````

### Maven

#### Step 1. Add the JitPack repository to your build file

````
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
````

#### Step 2. Add the dependency

````
	<dependency>
	    <groupId>com.github.DimitrisKaltzidis</groupId>
	    <artifactId>Open-Weather-One-Call-API</artifactId>
	    <version>Version</version>
	</dependency>
````

### Version

Replace the Version in the code above with the latest. Latest version: [![](https://jitpack.io/v/DimitrisKaltzidis/Open-Weather-One-Call-API.svg)](https://jitpack.io/#DimitrisKaltzidis/Open-Weather-One-Call-API)

## How to use

### Step 1. Get your API key 
Make sure you registered and got your API key from [openweathermap](https://openweathermap.org/). 

### Step 2. Create an OneCallApiClient
Create the client with your api key from openweathermap.

````
  OneCallApiClient oneCallApiClient = new OneCallApiClient("YOUR_API_KEY_HERE");
````

### Step 3. Prepare an OneCallApiRequest

Use the OneCallApiRequest.Builder class to build your request. The builder constructor requires the latitude and longitude 
of the location of your interest.

````
 OneCallApiRequest oneCallApiRequest = new OneCallApiRequest.Builder(37.971580, 23.726766)
                .unit(MeasurementUnit.metric)
                .lang(Language.el)
                .exlude(WeatherPart.minutely)
                .exlude(WeatherPart.daily)
                .build();
````

The builder contains methods to tailor the request to your needs such as:

`unit()` to configure the units the results will be in. 
Possible values are:  `standard, metric, imperial`

`lang()` to configure the lang the results will be in.
For a list of possible values check this doc: [Multilingual support](https://openweathermap.org/api/one-call-api#multi)

`exlude()` to configure the excluded Weather parts from the results.
Possible values are:  `current, minutely, hourly, daily, alerts`
Make sure you don't exclude the same Weather part twice.


### Step 4. Make the call and get the result

The final step to get your result is to call the `makeOneCallApiRequest` method of the `OneCallApiClient`.
The result of the call will be available using the `OnWeatherResponseReceivedListener`.
Feel free to implement the interface and get your Weather response. The `OnWeatherResponseReceivedListener`
contains two methods the `onSuccessfulResponse` where you can find the `response` if the call to retrieve the 
forecast was successful and the `onFailedResponse` if the call failed. Hopefully the `Throwable t` will give you
an idea regarding what went wrong 😊.

````
 oneCallApiClient.makeOneCallApiRequest(oneCallApiRequest, new OnWeatherResponseReceivedListener() {
            @Override
            public void onSuccessfulResponse(OneCallApiResponse response) {
                // Feel free to use the response as you like.
            }

            @Override
            public void onFailedResponse(Throwable t) {
                // The call failed the throwable will contain information regarding what went wrong. 
            }
        });
````

## To sum up
Feel free to use this library as you like. 
You can find additional information regarding the OneCallAPI [here](https://openweathermap.org/api/one-call-ap) 


