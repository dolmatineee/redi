package com.example.myapplication.api;

import com.example.myapplication.models.UserLogin;
import com.example.myapplication.models.UserRegistration;
import com.example.myapplication.models.UserSignup;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RetrofitService {

    @POST("user/register-user.php")
    Call<UserRegistration> userRegistration(@Body UserRegistration userRegistration);

    @POST("user/login-user.php")
    Call<UserLogin> userLogin(@Body UserLogin userLogin);

    @POST("/auth/v1/signup")
    @Headers({
            "apikey: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImhrZGZkcnJqbXRuamVveWlqa2tzIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDcxMTEwMzgsImV4cCI6MjAyMjY4NzAzOH0.wGVQGdVUejpUpEcNxbA5tXfbKknzr5B9RCZARzGi8FI",
            "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImhrZGZkcnJqbXRuamVveWlqa2tzIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDcxMTEwMzgsImV4cCI6MjAyMjY4NzAzOH0.wGVQGdVUejpUpEcNxbA5tXfbKknzr5B9RCZARzGi8FI"
    })
    Call<UserSignup> signUp(@Body Map<String, String> credentials);
}
