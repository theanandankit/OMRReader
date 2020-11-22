package com.Project.OMRReader.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.Project.OMRReader.Models.RetrofitModels.StudentInfoResponse;
import com.Project.OMRReader.R;
import com.Project.OMRReader.Services.RetrofitInterface;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StudentLoginActivity extends AppCompatActivity {
    private MaterialButton loginButton;
    private TextInputLayout emailView;
    private TextInputLayout passwordView;
    private Retrofit retrofit;
    private RetrofitInterface service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        retrofit= new Retrofit.Builder()
                .baseUrl("https://omrreaderapi.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        getViews();
        setClick();

        service= retrofit.create(RetrofitInterface.class);


    }
    private void getViews() {

        loginButton = findViewById(R.id.studentLoginButton);
        emailView = findViewById(R.id.student_email);
        passwordView = findViewById(R.id.student_password);
    }

    private void setClick() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Call<StudentInfoResponse> call = service.studentLogin(emailView.getEditText().getText().toString(),passwordView.getEditText().getText().toString());

              call.enqueue(new Callback<StudentInfoResponse>() {
                  @Override
                  public void onResponse(Call<StudentInfoResponse> call, Response<StudentInfoResponse> response) {

                      if(!response.isSuccessful())
                      {
                          Toast.makeText(getApplicationContext(),"Login Failed", Toast.LENGTH_LONG);
                          return;
                      }
                      Toast.makeText(getApplicationContext(),"Login Successful", Toast.LENGTH_LONG);
                      Intent i  = new Intent(StudentLoginActivity.this, StudentHomeScreenActivity.class);


                      i.putExtra("token",response.body().getToken());
                      i.putExtra("id",response.body().getId());
                      startActivity(i);

                  }

                  @Override
                  public void onFailure(Call<StudentInfoResponse> call, Throwable t) {
                      Toast.makeText(getApplicationContext(),"Login Failed", Toast.LENGTH_LONG);


                  }
              });





            }
        });



    }
}

