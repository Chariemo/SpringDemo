package simpleLogin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import simpleLogin.dao.LoginLogDao;
import simpleLogin.dao.UserDao;
import simpleLogin.model.LoginLog;
import simpleLogin.model.User;

/**
 * Created by Charley on 2017/6/1.
 */
@Service
public class UserService {

    private UserDao userDao;
    private LoginLogDao loginLogDao;

    @Autowired
    public void setUserDao(UserDao userDao) {

        this.userDao = userDao;
    }

    @Autowired
    public void setLoginLogDao(LoginLogDao loginLogDao) {

        this.loginLogDao = loginLogDao;
    }

    public boolean hasMatchUser(String userName, String password) {

        int matchCount = userDao.getMatchCount(userName, password);
        return matchCount > 0;
    }

    public User findUserByName(String userName) {

        return userDao.findUserByUserName(userName);
    }

    @Transactional
    public void loginSuccess(User user) {

        user.setCredits(5 + user.getCredits());
        LoginLog log = new LoginLog();
        log.setUserId(user.getUserId());
        log.setIp(user.getLastIp());
        log.setLoginDate(user.getLastVisit());

        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(log);
    }
}
