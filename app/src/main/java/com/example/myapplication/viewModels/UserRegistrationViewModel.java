package com.example.myapplication.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.api.RetrofitInstance;
import com.example.myapplication.api.RetrofitService;
import com.example.myapplication.models.UserRegistration;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRegistrationViewModel extends ViewModel {
    private final MutableLiveData<UserRegistration> userRegistrationMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<UserRegistration> getUserRegistrationMutableLiveData() {
        return userRegistrationMutableLiveData;
    }

    public void userRegistration(UserRegistration userRegistration) {
        RetrofitService retrofitService = RetrofitInstance.getRetrofitInstance().create(RetrofitService.class);
        Call<UserRegistration> call = retrofitService.userRegistration(userRegistration);
        call.enqueue(new Callback<UserRegistration>() {
            @Override
            public void onResponse(Call<UserRegistration> call, Response<UserRegistration> response) {
                if (response.isSuccessful()) {
                    userRegistrationMutableLiveData.postValue(response.body());
                } else {
                    userRegistrationMutableLiveData.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<UserRegistration> call, Throwable t) {
                userRegistrationMutableLiveData.postValue(null);
            }
        });
    }
}
