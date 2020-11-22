package com.Project.OMRReader.RetrofitCalls;

import com.Project.OMRReader.Models.RetrofitModels.StudentQuizListResponse;

import java.util.ArrayList;

public interface StudentListQuizInterface {

    public void Response(ArrayList<StudentQuizListResponse> responses);
}
