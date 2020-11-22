package com.Project.OMRReader.Models.RetrofitModels;

public class StudentQuizListResponse {

    String id;

    CompleteUserInfoResponse student;

    QuizResponse quiz;

    String date;

    String marks;

    String answer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CompleteUserInfoResponse getStudent() {
        return student;
    }

    public void setStudent(CompleteUserInfoResponse student) {
        this.student = student;
    }

    public QuizResponse getQuiz() {
        return quiz;
    }

    public void setQuiz(QuizResponse quiz) {
        this.quiz = quiz;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
