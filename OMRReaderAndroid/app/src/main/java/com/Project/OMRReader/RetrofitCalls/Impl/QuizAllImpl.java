package com.Project.OMRReader.RetrofitCalls.Impl;

import android.content.Context;

import com.Project.OMRReader.Models.RetrofitModels.QuizResponse;
import com.Project.OMRReader.RetrofitCalls.QuizAllInterface;
import com.Project.OMRReader.Services.ApiClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizAllImpl {

    ApiClient apiClient;
    QuizAllInterface quizAllInterface;

    public QuizAllImpl(QuizAllInterface quizAllInterface) {
        apiClient = new ApiClient();
        this.quizAllInterface = quizAllInterface;
    }

    public void get() {

        Call<ArrayList<QuizResponse>> call = apiClient.getApiinterface().getAllQuiz();
        call.enqueue(new Callback<ArrayList<QuizResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<QuizResponse>> call, Response<ArrayList<QuizResponse>> response) {
                quizAllInterface.response(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<QuizResponse>> call, Throwable t) {

            }
        });
    }
}
