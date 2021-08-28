package com.dataobject;

public class UserDO {

    private Integer userId;

    private String userName;

    private String registerMode;

    private Integer userLevel;

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
        return userLevel;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public UserDO(Integer userId, String userName, String registerMode, Integer userLevel, String thirdPartyId, String encrptPassword) {
        this.userId = userId;
        this.userName = userName;
        this.registerMode = registerMode;
        this.userLevel = userLevel;
        this.thirdPartyId = thirdPartyId;
        this.encrptPassword = encrptPassword;
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

    public UserDO() {
    }

    @Override
    public String toString() {
        return "UserDO[id=" + userId + ", name=" + userName + ", mode=" + registerMode + "]";
    }
}
