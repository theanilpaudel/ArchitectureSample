package com.theanilpaudel.architecturesample;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.theanilpaudel.architecturesample.brands.BrandsViewModel;
import com.theanilpaudel.architecturesample.entity.Brand;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Inject
    BrandsViewModel brandsViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MainApplication)getApplication()).getNetComponent().inject(this);

//        BrandsViewModel brandsViewModel = ViewModelProviders.of(this).get(BrandsViewModel.class);
//        BrandsViewModel brandsViewModel = new BrandsViewModel()
        brandsViewModel.callService();

        LiveData<List<Brand>> brandsLiveData = brandsViewModel.getBrandsLiveData();
        brandsLiveData.observe(this, new Observer<List<Brand>>() {
            @Override
            public void onChanged(@Nullable List<Brand> brands) {
                Log.d(TAG, "onCreate: "+brands.get(0).getName());
            }
        });


    }
}
