package com.dataobject;

public class UserDO {

    private Integer userId;

    private String userName;

    private String registerMode;

    private Integer user_level;

    private String thirdPartyId;

    private String encrptPassword;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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

    public Integer getUser_level() {
        return user_level;
    }

    public void setUser_level(Integer user_level) {
        this.user_level = user_level;
    }

    public String getThirdPartyId() {
        return thirdPartyId;
    }

    public void setThirdPartyId(String thirdPartyId) {
        this.thirdPartyId = thirdPartyId;
    }

    public String getEncrptPassword() {
        return encrptPassword;
    }

    public void setEncrptPassword(String encrptPassword) {
        this.encrptPassword = encrptPassword;
    }

    public UserDO(Integer userId,
                  String userName,
                  String registerMode,
                  Integer user_level,
                  String thirdPartyId,
                  String encrptPassword) {
        this.userId = userId;
        this.userName = userName;
        this.registerMode = registerMode;
        this.user_level = user_level;
        this.thirdPartyId = thirdPartyId;
        this.encrptPassword = encrptPassword;
    }
}
