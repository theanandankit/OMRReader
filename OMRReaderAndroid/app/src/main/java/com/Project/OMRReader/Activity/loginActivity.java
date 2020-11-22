package com.Project.OMRReader.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.Project.OMRReader.Models.RetrofitModels.ResponseStatus;
import com.Project.OMRReader.R;
import com.Project.OMRReader.RetrofitCalls.AdminLoginInterface;
import com.Project.OMRReader.RetrofitCalls.Impl.AdminLoginImpl;
import com.Project.OMRReader.Utilities.LoadingDialog;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class loginActivity extends AppCompatActivity implements AdminLoginInterface {

    MaterialButton login;
    AdminLoginImpl adminLogin;
    TextInputLayout email,password;
    LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        setOnClick();
    }
    private void init(){
        login = findViewById(R.id.loginButton);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        adminLogin = new AdminLoginImpl(loginActivity.this);
        loadingDialog = new LoadingDialog(loginActivity.this);
    }
    private void setOnClick(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check()) {
                    loadingDialog.SetDialog("Please Wait");
                    loadingDialog.show();
                    adminLogin.get(email.getEditText().getText().toString(), password.getEditText().getText().toString());
                }
            }
        });
    }
    private boolean check(){
        if (!email.getEditText().getText().toString().isEmpty()) {
            if (!password.getEditText().getText().toString().isEmpty()){
                return true;
            } else {
                password.setError("Enter the password");
                password.requestFocus();
                return false;
            }
        } else {
            email.setError("Enter the Email");
            email.requestFocus();
            return false;
        }
    }

    @Override
    public void Response(ResponseStatus responseStatus) {
        loadingDialog.dismiss();
        if (responseStatus.getStatus().equals("Success")){
            Toast.makeText(getApplicationContext(),"successfully logged In",Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(),AdminHomeScreen.class));
            finish();
        }
        else {
            Toast.makeText(getApplicationContext(),"Incorrect Username or password",Toast.LENGTH_LONG).show();
        }
    }
}