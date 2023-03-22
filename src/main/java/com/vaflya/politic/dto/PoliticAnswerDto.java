package com.vaflya.politic.dto;

public class PoliticAnswerDto {
    String ideologyName;
    String imgName;

    public String getIdeologyName() {
        return ideologyName;
    }

    public void setIdeologyName(String ideologyName) {
        this.ideologyName = ideologyName;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public PoliticAnswerDto(String ideologyName, String imgName) {
        this.ideologyName = ideologyName;
        this.imgName = imgName;
    }

    public PoliticAnswerDto()
    {

    }
}
