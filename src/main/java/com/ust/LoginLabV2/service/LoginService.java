package com.ust.LoginLabV2.service;

import com.ust.LoginLabV2.dao.LoginDao;
import com.ust.LoginLabV2.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    private final LoginDao loginDao;

    @Autowired
    public LoginService(@Qualifier("LoginRepo") LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    public int insertLogin(Login login) {
        return loginDao.insertLogin(login);
    }

    public int deleteLogin(String uname) {
        return loginDao.deleteLogin(uname);
    }

    public int updateLogin(String uname, Login login) {
        return loginDao.updateLogin(uname, login);
    }

    public List<Login> queryLogins() {
        return loginDao.queryLogins();
    }

    public Optional<Login> queryLogin(String uname) {
        return loginDao.queryLogin(uname);
    }
}