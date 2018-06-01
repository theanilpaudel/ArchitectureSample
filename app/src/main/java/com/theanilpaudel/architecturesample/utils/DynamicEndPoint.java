package com.theanilpaudel.architecturesample.utils;

/**
 * Created by anilpaudel on 12/5/16.
 */

public class DynamicEndPoint implements EndPoint {
    //http://stackoverflow.com/a/27816635/739306
    //http://stackoverflow.com/a/23279628/739306
    //Retrofit 1.9.0

    String baseUrl;

    public DynamicEndPoint(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void changeEndPoint(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String getUrl() {
        return baseUrl;
    }

    @Override
    public String getName() {
        return "default";
    }
}
