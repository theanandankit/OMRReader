package com.Project.OMRReader.RetrofitCalls.Impl;

import com.Project.OMRReader.Models.RetrofitModels.StudentQuizListResponse;
import com.Project.OMRReader.RetrofitCalls.StudentListQuizInterface;
import com.Project.OMRReader.Services.ApiClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentListQuizImpl {

    ApiClient apiClient;
    StudentListQuizInterface studentListQuizInterface;

    public StudentListQuizImpl(StudentListQuizInterface studentListQuizInterface){
        apiClient = new ApiClient();
        this.studentListQuizInterface = studentListQuizInterface;
    }

    public void get(int id){

        Call<ArrayList<StudentQuizListResponse>> call = apiClient.getApiinterface().getStudentList(id);
        call.enqueue(new Callback<ArrayList<StudentQuizListResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<StudentQuizListResponse>> call, Response<ArrayList<StudentQuizListResponse>> response) {
                studentListQuizInterface.Response(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<StudentQuizListResponse>> call, Throwable t) {

            }
        });
    }
}
