package com.Project.OMRReader.Models;

import java.util.ArrayList;

public class AddQuestionModel {

    ArrayList<String> answer;

    Integer questionNo;

    public ArrayList<String> getAnswer() {
        return answer;
    }

    public void setAnswer(ArrayList<String> answer) {
        this.answer = answer;
    }

    public Integer getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(Integer questionNo) {
        this.questionNo = questionNo;
    }
}
