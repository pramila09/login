package com.example.pramila.login;

public class User {
    String userId;
    String userfirstname;
    String userlastname;
    String userpassword;
    String userconfirmpassword;
    String useraddress;
    String usercontact;
    String userdob;
    String usergender;
    String userbloodgrp;

    public User(){

    }

    public User(String userId, String userfirstname, String userlastname, String userpassword, String userconfirmpassword, String useraddress, String usercontact, String userdob, String usergender, String userbloodgrp) {
        this.userId = userId;
        this.userfirstname = userfirstname;
        this.userlastname = userlastname;
        this.userpassword = userpassword;
        this.userconfirmpassword = userconfirmpassword;
        this.useraddress = useraddress;
        this.usercontact = usercontact;
        this.userdob = userdob;
        this.usergender = usergender;
        this.userbloodgrp = userbloodgrp;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserfirstname() {
        return userfirstname;
    }

    public String getUserlastname() {
        return userlastname;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public String getUserconfirmpassword() {
        return userconfirmpassword;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public String getUsercontact() {
        return usercontact;
    }

    public String getUserdob() {
        return userdob;
    }

    public String getUsergender() { return usergender;
    }
    public String getUserbloodgrp() { return userbloodgrp; }
}


