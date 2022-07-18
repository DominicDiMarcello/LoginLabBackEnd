package com.ust.LoginLabV2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Login {

    private String uname;

    private String pword;

    public Login() {}

    public Login(@JsonProperty("uname") String uname, @JsonProperty("pword") String pword) {
        this.uname = uname;
        this.pword = pword;
    }

    public String getUname() {
        return uname;
    }

    public String getPword() {
        return pword;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setPword(String pword) {
        this.pword = pword;
    }


}
