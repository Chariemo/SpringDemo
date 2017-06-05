package simpleLogin.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Charley on 2017/6/1.
 */
public class LoginLog implements Serializable {

    private int loginLogid;
    private int userId;
    private String ip;
    private Date loginDate;

    public int getLoginLogid() {
        return loginLogid;
    }

    public void setLoginLogid(int loginLogid) {
        this.loginLogid = loginLogid;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
}
