package com.theanilpaudel.architecturesample.brands;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.theanilpaudel.architecturesample.entity.Brand;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class BrandsRepository {
    public static final String TAG = "BrandsRepository";
    MutableLiveData<List<Brand>> mutableLiveData;
    Retrofit retrofit;

    @Inject
    public BrandsRepository(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public LiveData<List<Brand>> getListOfBrands() {
//       Retrofit retrofit = ApiManager.getAdapter();
        final BrandsService brandsService = retrofit.create(BrandsService.class);
        Log.d(TAG, "getListOfBrands: 00000000000 "+retrofit);

        mutableLiveData = new MutableLiveData<>();

        Call<List<Brand>> retrofitCall = brandsService.getBrands();
        retrofitCall.enqueue(new Callback<List<Brand>>() {
            @Override
            public void onResponse(Call<List<Brand>> call, Response<List<Brand>> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Brand>> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return mutableLiveData;
        /*Observable<Response<List<Brand>>> observable = brandsService.getBrands();
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<Response<List<Brand>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Response<List<Brand>> value) {
                        int responseCode = value.code();
                        if (responseCode == 403) {
                            //error
                        } else if (responseCode == 200) {
                            Log.d(TAG, "onNext: "+value.body().get(0));
                        } else {
                            //error
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        if (e instanceof HttpException || e instanceof ConnectException) {
                            //("No Internet Connection");
                        } else if (e instanceof UnknownHostException || e instanceof SocketTimeoutException) {
                            //("Couldn't connect to server");
                        } else {
                            //("Error Occured");
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });*/
    }
}
