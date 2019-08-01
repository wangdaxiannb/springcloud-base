package com.panpass.project.entity;

public class Atesta {
    private String codedata;

    public String getCodedata() {
        return codedata;
    }

    public void setCodedata(String codedata) {
        this.codedata = codedata == null ? null : codedata.trim();
    }
}