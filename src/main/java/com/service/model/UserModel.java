package com.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserModel implements Serializable {

    private Integer userId;

    private String userName;

    private String registerMode;

    private Byte userLevel;

    private String thirdpartyId;

    private String encrptPassword;
}
