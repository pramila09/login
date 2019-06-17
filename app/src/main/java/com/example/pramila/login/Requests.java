package com.example.pramila.login;

public class Requests {
String RequestId;
String RequestBloodgrp;
String RequestQuantity;
String RequestTime;

public Requests(){

}
public Requests(String RequestId, String RequestBloodgrp, String RequestTime, String RequestQuantity){
    this.RequestId = RequestId;
    this.RequestBloodgrp = RequestBloodgrp;
    this.RequestTime = RequestTime;
    this.RequestQuantity = RequestQuantity;
}



    public String getRequestId() {
        return RequestId;
    }

    public String getRequestBloodgrp() {
        return RequestBloodgrp;
    }

    public String getRequestTime() {
        return RequestTime;
    }

    public String getRequestQuantity(){
    return RequestQuantity;
    }
}
