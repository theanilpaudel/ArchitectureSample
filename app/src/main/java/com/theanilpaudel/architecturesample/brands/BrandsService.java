package com.theanilpaudel.architecturesample.brands;

import com.theanilpaudel.architecturesample.entity.Brand;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BrandsService {
    @GET("listBrand")
    Call<List<Brand>> getBrands();
}
