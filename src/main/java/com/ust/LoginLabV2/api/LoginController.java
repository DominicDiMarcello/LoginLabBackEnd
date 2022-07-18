package com.ust.LoginLabV2.api;

import com.ust.LoginLabV2.model.Login;
import com.ust.LoginLabV2.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("logins/")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    int insertLogin(@RequestBody Login login) {
        return loginService.insertLogin(login);
    }

    @PutMapping(value = "{uname}")
    int updateLogin(@PathVariable("uname") String uname, @RequestBody Login login) {
        return loginService.updateLogin(uname, login);
    }

    @DeleteMapping(value="{uname}")
    int deleteLogin(@PathVariable("uname") String uname) {
        return loginService.deleteLogin(uname);
    }

    @GetMapping
    List<Login> queryLogins() {
        return loginService.queryLogins();
    }

    @GetMapping(value="{uname}")
    Optional<Login> queryLogin(@PathVariable("uname") String uname) {
        return loginService.queryLogin(uname);
    }
}
