package simpleLogin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import simpleLogin.model.LoginLog;

/**
 * Created by Charley on 2017/6/1.
 */
@Repository
public class LoginLogDao {

    private JdbcTemplate jdbcTemplate;
    private static final String INSERT_LOGIN_LOG_SQL = "INSERT INTO t_login_log(user_id, ip," +
            "login_datetime) VALUES(?, ?, ?)";

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertLoginLog(LoginLog log) {

        jdbcTemplate.update(INSERT_LOGIN_LOG_SQL, new Object[]{log.getUserId(), log.getIp(), log.getLoginDate()});
    }
}
