package com.constants;

public class UserConstants {

    //用户等级设置
    public static final int ORIGINAL = 0;
    public static final int VIP_HIGHEST = 30;
    //管理员等级设置
    public static final int ADMIN = 100;

    public static int levelUp(int level, int offset) {
        int tmp = level + offset;
        if(tmp < VIP_HIGHEST || tmp < ADMIN) return tmp;
        else return level;
    }

    //注册方式设置
    public static final String BY_PHONE = "mobile";
    public static final String BY_PC = "pc";
    public static final String BY_SERVER = "server";
    public static final String BY_OTHERS = "others";

    public static String getRegisterMode(String registerMode) {
        if(registerMode.equals(BY_PHONE)) return BY_PHONE;
        else if (registerMode.equals(BY_PC)) return BY_PC;
        else if (registerMode.equals(BY_SERVER)) return BY_SERVER;
        else return BY_OTHERS;
    }
}
