package com.Project.OMRReader.RetrofitCalls.Impl;

import android.util.Log;

import com.Project.OMRReader.Models.RetrofitModels.AdminHomeResponse;
import com.Project.OMRReader.RetrofitCalls.AdminHomeInfoInterface;
import com.Project.OMRReader.Services.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdminHomeInfoImpl {

    ApiClient apiClient;
    AdminHomeInfoInterface adminHomeInfoInterface;

    public AdminHomeInfoImpl(AdminHomeInfoInterface adminHomeInfoInterface){
        apiClient = new ApiClient();
        this.adminHomeInfoInterface = adminHomeInfoInterface;
    }

    public void get(){
        Call<AdminHomeResponse> call = apiClient.getApiinterface().adminHomeInfo();
        call.enqueue(new Callback<AdminHomeResponse>() {
            @Override
            public void onResponse(Call<AdminHomeResponse> call, Response<AdminHomeResponse> response) {

                adminHomeInfoInterface.response(response.body());
            }

            @Override
            public void onFailure(Call<AdminHomeResponse> call, Throwable t) {

                Log.e("ok",t.getMessage());

            }
        });
    }
}
