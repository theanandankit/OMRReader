package com.Project.OMRReader.Models.RetrofitModels;

public class AdminHomeResponse {

    Integer totalStudent;

    Integer totalQuiz;

    QuizResponse lastQuiz;

    CompleteUserInfoResponse gainer;

    public Integer getTotalStudent() {
        return totalStudent;
    }

    public void setTotalStudent(Integer totalStudent) {
        this.totalStudent = totalStudent;
    }

    public Integer getTotalQuiz() {
        return totalQuiz;
    }

    public void setTotalQuiz(Integer totalQuiz) {
        this.totalQuiz = totalQuiz;
    }

    public QuizResponse getLastQuiz() {
        return lastQuiz;
    }

    public void setLastQuiz(QuizResponse lastQuiz) {
        this.lastQuiz = lastQuiz;
    }

    public CompleteUserInfoResponse getGainer() {
        return gainer;
    }

    public void setGainer(CompleteUserInfoResponse gainer) {
        this.gainer = gainer;
    }

    @Override
    public String toString() {
        return "AdminHomeResponse{" +
                "totalStudent=" + totalStudent +
                ", totalQuiz=" + totalQuiz +
                ", lastQuiz=" + lastQuiz +
                ", gainer=" + gainer +
                '}';
    }
}
