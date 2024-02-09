package com.example.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import com.example.myapplication.CustomTextWatcher;
import com.example.myapplication.R;
import com.example.myapplication.api.RetrofitInstance;
import com.example.myapplication.api.RetrofitService;
import com.example.myapplication.databinding.ActivitySignupBinding;
import com.example.myapplication.models.UserSignup;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SignupActivity extends AppCompatActivity {

    ActivitySignupBinding binding;
    Retrofit retrofit = RetrofitInstance.getRetrofitInstance();
    RetrofitService retrofitService = retrofit.create(RetrofitService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        EditText[] edList = {binding.signupNameEditText, binding.signupPhoneEditText, binding.signupEmailEditText,
                binding.signupPasswordEditText, binding.signupConfPasEditText};
        CustomTextWatcher textWatcher = new CustomTextWatcher(edList, binding.signupButton);
        for (EditText editText : edList) {
            editText.addTextChangedListener(textWatcher);
        }

        binding.signupButton.setOnClickListener(v -> {
            if (!binding.signupPasswordEditText.getText().toString().equals(binding.signupConfPasEditText.getText().toString())) {
                binding.signupPasswordEditText.setBackgroundResource(R.drawable.sign_custom_error_edittext);
                binding.signupConfPasEditText.setBackgroundResource(R.drawable.sign_custom_error_edittext);
                Toast.makeText(SignupActivity.this, "Пароли не совпадают", Toast.LENGTH_LONG).show();
            } else if (!binding.signupCheckBox.isChecked()) {
                Toast.makeText(SignupActivity.this, "Примите пользовательское соглашение", Toast.LENGTH_LONG).show();
            } else {
                binding.signupPasswordEditText.setBackgroundResource(R.drawable.sign_custom_edittext);
                binding.signupConfPasEditText.setBackgroundResource(R.drawable.sign_custom_edittext);

                registerUser("user@example.com", "password123");
                Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.signupSigninTextView.setOnClickListener(v -> {
            Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }

    private void registerUser(String email, String password) {
        Map<String, String> credentials = new HashMap<>();
        credentials.put("email", email);
        credentials.put("password", password);

        Call<UserSignup> signUpCall = retrofitService.signUp(credentials);
        signUpCall.enqueue(new Callback<UserSignup>() {
            @Override
            public void onResponse(Call<UserSignup> call, Response<UserSignup> response) {
                // Обработка успешной регистрации
            }

            @Override
            public void onFailure(Call<UserSignup> call, Throwable t) {

            }
        });
    }
}