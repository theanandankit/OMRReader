package com.Project.OMRReader.Models.RetrofitModels;

import com.google.gson.annotations.SerializedName;

public class StudentQueryModel {
     @SerializedName("user_info")
     private UserInfoResponse user_info;
     private String about;
     private String contactNo;
     private String address;
     private String batch;
     private String rollno;
     private int totalCorrect;

    public UserInfoResponse getUser_info() {
        return user_info;
    }

    public void setUser_info(UserInfoResponse user_info) {
        this.user_info = user_info;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public int getTotalCorrect() {
        return totalCorrect;
    }

    public void setTotalCorrect(int totalCorrect) {
        this.totalCorrect = totalCorrect;
    }

    public int getTotalInCorrect() {
        return totalInCorrect;
    }

    public void setTotalInCorrect(int totalInCorrect) {
        this.totalInCorrect = totalInCorrect;
    }

    private int totalInCorrect;


}
