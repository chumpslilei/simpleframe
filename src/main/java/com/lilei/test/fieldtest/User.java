package com.lilei.test.fieldtest;

/**
 * Created by Administrator on 2017/9/22.
 */
public class User {
    /**
     * doc username
     */
    private String username="test";//username
    /**
     * doc password
     */
    private String userpassword;//password

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }
}
