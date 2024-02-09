package com.example.myapplication.viewModels;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.myapplication.api.RetrofitInstance;
import com.example.myapplication.api.RetrofitService;
import com.example.myapplication.models.UserLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;

public class UserLoginViewModel extends ViewModel {

    private final MutableLiveData<UserLogin> userLoginMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<UserLogin> getUserLoginMutableLiveData(){
        return userLoginMutableLiveData;
    }



    public void userLogin(UserLogin userLogin) {
        RetrofitService retrofitService = RetrofitInstance.getRetrofitInstance().create(RetrofitService.class);
        Call<UserLogin> call = retrofitService.userLogin(userLogin);
        call.enqueue(new Callback<UserLogin>() {
            @Override
            public void onResponse(Call<UserLogin> call, Response<UserLogin> response) {
                if (response.isSuccessful()) {
                    userLoginMutableLiveData.postValue(response.body());
                } else {
                    userLoginMutableLiveData.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<UserLogin> call, Throwable t) {
                userLoginMutableLiveData.postValue(null);
            }
        });
    }
}
