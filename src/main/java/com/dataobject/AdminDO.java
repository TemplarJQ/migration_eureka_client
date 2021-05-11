package com.dataobject;

public class AdminDO {

    private Integer adminId;

    private String adminName;

    private String thirdPartyId;

    private String encrptPassword;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
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

    public AdminDO(Integer adminId, String adminName, String thirdPartyId, String encrptPassword) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.thirdPartyId = thirdPartyId;
        this.encrptPassword = encrptPassword;
    }
}
