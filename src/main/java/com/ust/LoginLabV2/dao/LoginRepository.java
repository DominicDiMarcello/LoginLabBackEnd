package com.ust.LoginLabV2.dao;

import com.ust.LoginLabV2.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository("LoginRepo")
public class LoginRepository implements LoginDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int insertLogin(Login login) {
        String sql = "INSERT INTO LOGIN (UNAME, PWORD) VALUES (?, ?)";
        return jdbcTemplate.update(sql, new Object[] {
                login.getUname(), login.getPword()
        });
    }

    @Override
    public int deleteLogin(String uname) {
        String sql = "DELETE FROM LOGIN WHERE UNAME=?";
        return jdbcTemplate.update(sql, uname);
    }

    @Override
    public int updateLogin(String uname, Login login) {
        String sql = "UPDATE LOGIN SET UNAME=?, PWORD=? WHERE UNAME=?";
        return jdbcTemplate.update(sql, new Object[] {
           login.getUname(), login.getPword(), uname
        });
    }

    @Override
    public List<Login> queryLogins() {
        String sql = "SELECT * FROM LOGIN";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Login.class));
    }

    @Override
    public Optional<Login> queryLogin(String uname) {
        Login login = null;
        try {
            String sql = "SELECT * FROM LOGIN WHERE UNAME=?";
            login = jdbcTemplate.queryForObject(sql,
                    BeanPropertyRowMapper.newInstance(Login.class), uname);
            return Optional.ofNullable(login);
        }
        catch (IncorrectResultSizeDataAccessException e) {
            return Optional.ofNullable(login);
        }
    }
}
