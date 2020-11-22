package com.Project.OMRReader.Models;

import android.widget.ImageView;
import android.widget.TextView;

public class QuizEvaluationModelView{
    ImageView scannedImage;
    TextView enrollmentNumber;
    TextView totalMarks;

    public ImageView getScannedImage() {
        return scannedImage;
    }

    public void setScannedImage(ImageView scannedImage) {
        this.scannedImage = scannedImage;
    }

    public TextView getEnrollmentNumber() {
        return enrollmentNumber;
    }

    public void setEnrollmentNumber(TextView enrollmentNumber) {
        this.enrollmentNumber = enrollmentNumber;
    }

    public TextView getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(TextView totalMarks) {
        this.totalMarks = totalMarks;
    }



}
