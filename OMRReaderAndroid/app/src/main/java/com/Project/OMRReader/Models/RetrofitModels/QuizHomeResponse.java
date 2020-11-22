package com.Project.OMRReader.Models.RetrofitModels;

public class QuizHomeResponse {

    CompleteUserInfoResponse maxStudent;

    QuizResponse quizinfo;

    String totalStudent;

    public CompleteUserInfoResponse getMaxStudent() {
        return maxStudent;
    }

    public void setMaxStudent(CompleteUserInfoResponse maxStudent) {
        this.maxStudent = maxStudent;
    }

    public QuizResponse getQuizinfo() {
        return quizinfo;
    }

    public void setQuizinfo(QuizResponse quizinfo) {
        this.quizinfo = quizinfo;
    }

    public String getTotalStudent() {
        return totalStudent;
    }

    public void setTotalStudent(String totalStudent) {
        this.totalStudent = totalStudent;
    }
}
