package com.vmware.talentboost.finaltask.networkofgiving.model;

public class JsonWebTokenModel {
    private String token;

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public JsonWebTokenModel(String token) {
        this.token = token;
    }
}
