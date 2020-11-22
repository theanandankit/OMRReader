package com.Project.OMRReader.RetrofitCalls.Impl;

import com.Project.OMRReader.Models.RetrofitModels.QuizHomeResponse;
import com.Project.OMRReader.RetrofitCalls.QuizHomeInfoInterface;
import com.Project.OMRReader.Services.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizHomeInfoImpl {

    ApiClient apiClient;
    QuizHomeInfoInterface quizHomeInfoInterface;

    public QuizHomeInfoImpl(QuizHomeInfoInterface quizHomeInfoInterface){
        apiClient = new ApiClient();
        this.quizHomeInfoInterface = quizHomeInfoInterface;
    }

    public void get(int id){

        Call<QuizHomeResponse> call = apiClient.getApiinterface().getFullQuizInfo(id);
        call.enqueue(new Callback<QuizHomeResponse>() {
            @Override
            public void onResponse(Call<QuizHomeResponse> call, Response<QuizHomeResponse> response) {
                quizHomeInfoInterface.Response(response.body());
            }

            @Override
            public void onFailure(Call<QuizHomeResponse> call, Throwable t) {

            }
        });
    }
}
