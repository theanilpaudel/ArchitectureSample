package com.theanilpaudel.architecturesample.brands;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.theanilpaudel.architecturesample.entity.Brand;

import java.util.List;

import javax.inject.Inject;

public class BrandsViewModel extends ViewModel{
    BrandsRepository brandsRepository;
    LiveData<List<Brand>> brandsLiveData;
    @Inject
    public BrandsViewModel(BrandsRepository brandsRepository) {
        this.brandsRepository = brandsRepository;
    }

    public void callService(){
       brandsLiveData = brandsRepository.getListOfBrands();
    }

    public LiveData<List<Brand>> getBrandsLiveData() {
        return brandsLiveData;
    }


}
