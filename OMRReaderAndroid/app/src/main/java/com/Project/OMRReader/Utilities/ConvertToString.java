package com.Project.OMRReader.Utilities;

import com.Project.OMRReader.Models.AddQuestionModel;

import java.util.ArrayList;

public class ConvertToString {

    ArrayList<AddQuestionModel> addQuestionModels;

    public ConvertToString(ArrayList<AddQuestionModel> addQuestionModel) {
        this.addQuestionModels = addQuestionModel;
    }

    public String getAnswer() {

        String result = "";

        for (int temp = 0; temp < addQuestionModels.size(); temp++) {

            boolean a = false, b = false, c = false, d = false;

            for (int temp1 = 0; temp1 < addQuestionModels.get(temp).getAnswer().size(); temp1++) {

                String value = addQuestionModels.get(temp).getAnswer().get(temp1);
                if (value.equals("A"))
                    a = true;
                if (value.equals("B"))
                    b = true;
                if (value.equals("C"))
                    c = true;
                if (value.equals("D"))
                    d = true;
            }
            if (a)
                result = result + "1";
            else
                result = result + "0";
            if (b)
                result = result + "1";
            else
                result = result + "0";
            if (c)
                result = result + "1";
            else
                result = result + "0";
            if (d)
                result = result + "1";
            else
                result = result + "0";
        }

        return result;
    }

    public String getAnswerType() {

        String result = "";

        for (int temp = 0; temp < addQuestionModels.size(); temp++) {

            if (addQuestionModels.get(temp).getAnswer().size() > 1)
                result = result + "1";
            else
                result = result + "0";
        }
        return result;
    }
}