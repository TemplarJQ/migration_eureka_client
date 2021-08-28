package com.dataobject;

public class VisiterDO {

    private String userName;

    private String registerMode;

    private Byte user_level;

    private String encrptPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRegisterMode() {
        return registerMode;
    }

    public void setRegisterMode(String registerMode) {
        this.registerMode = registerMode;
    }

    public Byte getUser_level() {
        return user_level;
    }

    public void setUser_level(Byte user_level) {
        this.user_level = user_level;
    }

    public String getEncrptPassword() {
        return encrptPassword;
    }

    public void setEncrptPassword(String encrptPassword) {
        this.encrptPassword = encrptPassword;
    }

    public VisiterDO(String userName, String registerMode, Byte user_level, String encrptPassword) {
        this.userName = userName;
        this.registerMode = registerMode;
        this.user_level = user_level;
        this.encrptPassword = encrptPassword;
    }

    public VisiterDO() {
    }
}
