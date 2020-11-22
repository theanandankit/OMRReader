package com.Project.OMRReader.RetrofitCalls.Impl;

import android.util.Log;

import com.Project.OMRReader.Models.RetrofitModels.ResponseStatus;
import com.Project.OMRReader.RetrofitCalls.AdminLoginInterface;
import com.Project.OMRReader.Services.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdminLoginImpl {

    private AdminLoginInterface adminLoginInterface;
    private ApiClient apiClient;

    public AdminLoginImpl(AdminLoginInterface adminLoginInterface){
        this.adminLoginInterface=adminLoginInterface;
        apiClient = new ApiClient();
    }

    public void get(String username,String password){

        Call<ResponseStatus> call = apiClient.getApiinterface().adminLogin(username,password);
        call.enqueue(new Callback<ResponseStatus>() {
            @Override
            public void onResponse(Call<ResponseStatus> call, Response<ResponseStatus> response) {

                Log.e("okk", String.valueOf(response.code()));

                adminLoginInterface.Response(response.body());
            }

            @Override
            public void onFailure(Call<ResponseStatus> call, Throwable t) {

            }
        });
    }
}
