package com.example.demo.models;

public class ResponseModel {
    private Integer data;
    private Integer status;

    public void setData(Integer data) {
        this.data = data;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getData() {
        return data;
    }

    public Integer getStatus() {
        return status;
    }
}
