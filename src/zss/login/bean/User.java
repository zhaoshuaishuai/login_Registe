package zss.login.bean;

import java.util.Date;

/**
 * Created by zss on 2015/7/15.
 */
public class User {
    private int userId;
    private String userPassword;
    private String userNmae;
    private String userEmail;
    private Date userBirthday;

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserNmae() {
        return userNmae;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserNmae(String userNmae) {
        this.userNmae = userNmae;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }
}
