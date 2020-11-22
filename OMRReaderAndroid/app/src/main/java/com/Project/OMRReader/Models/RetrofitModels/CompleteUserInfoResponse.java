package com.Project.OMRReader.Models.RetrofitModels;

public class CompleteUserInfoResponse {

    String about;

    String contactNo;

    String address;

    String batch;

    String rollno;

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    UserInfoResponse user_info;

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String  getContactNo() {
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

    public UserInfoResponse getUser_info() {
        return user_info;
    }

    public void setUser_info(UserInfoResponse user_info) {
        this.user_info = user_info;
    }
}
