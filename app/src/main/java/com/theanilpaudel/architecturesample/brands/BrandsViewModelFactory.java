package com.theanilpaudel.architecturesample.brands;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import javax.inject.Inject;

public class BrandsViewModelFactory implements ViewModelProvider.Factory{
    private final BrandsRepository brandsRepository;

    @Inject
    public BrandsViewModelFactory(BrandsRepository brandsRepository) {
        this.brandsRepository = brandsRepository;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new BrandsViewModel(brandsRepository);
    }
}
