package com.theanilpaudel.architecturesample.utils;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by anilpaudel on 12/5/16.
 */

public class ApiManager {

    // static adapter to be used in entire app
    static volatile Retrofit retrofit = null;
    //dynamic endpoints if needed to change base url
    private static DynamicEndPoint dynamicEndPoint;

    private ApiManager() {
    }

    // singleton for RestAdapter
    public static Retrofit getAdapter() {
        if (retrofit == null) {
            synchronized (ApiManager.class) {
                if (retrofit == null) {
                    dynamicEndPoint = new DynamicEndPoint(LinkConfig.BASE_URL);
                    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
                    // set your desired log level
                    logging.setLevel(HttpLoggingInterceptor.Level.BODY);
                    OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(logging).build();

                     retrofit = new Retrofit.Builder()
                            .baseUrl(dynamicEndPoint.getUrl())
                            .client(httpClient)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();
                }
            }
        }
        return retrofit;
    }

    /**Method to get url used by DynamicEndPoint*/
    public static String getBaseUrl() {
        getAdapter();
        return dynamicEndPoint.getUrl();
    }
    /**Method to set Base url for our endpoint*/
    public static void setBaseUrl(String url) {
        getAdapter();
        synchronized (ApiManager.class) {
            dynamicEndPoint.changeEndPoint(url);
        }
    }


}
