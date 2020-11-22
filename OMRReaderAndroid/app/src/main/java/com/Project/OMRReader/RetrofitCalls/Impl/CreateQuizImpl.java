package com.Project.OMRReader.RetrofitCalls.Impl;

import com.Project.OMRReader.Models.RetrofitModels.NewQuizRequest;
import com.Project.OMRReader.Models.RetrofitModels.ResponseStatus;
import com.Project.OMRReader.RetrofitCalls.CreateQuizInterface;
import com.Project.OMRReader.Services.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateQuizImpl {

    ApiClient apiClient;
    CreateQuizInterface createQuizInterface;

    public CreateQuizImpl(CreateQuizInterface createQuizInterface){
        this.createQuizInterface = createQuizInterface;
        apiClient = new ApiClient();
    }

    public void get(NewQuizRequest request){
        Call<ResponseStatus> call = apiClient.getApiinterface().createQuiz(request.getAnswer(),request.getAnswerType(),request.isNegative(),request.getDescription(),request.getTopic(),request.getInitiatedBy());
        call.enqueue(new Callback<ResponseStatus>() {
            @Override
            public void onResponse(Call<ResponseStatus> call, Response<ResponseStatus> response) {

                createQuizInterface.Response(response.body());
            }

            @Override
            public void onFailure(Call<ResponseStatus> call, Throwable t) {

            }
        });
    }
}
