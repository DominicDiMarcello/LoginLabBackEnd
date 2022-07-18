package com.ust.LoginLabV2.dao;

import com.ust.LoginLabV2.model.Login;

import java.awt.*;
import java.util.List;
import java.util.Optional;

public interface LoginDao {

    int insertLogin(Login login);

    int deleteLogin(String uname);

    int updateLogin(String uname, Login login);

    List<Login> queryLogins();

    Optional<Login> queryLogin(String uname);
}
