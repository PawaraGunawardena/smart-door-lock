package com.crystall.smartlockprototype.beans.firebase;

import com.crystall.smartlockprototype.beans.IUser;

import java.io.Serializable;

public class User implements IUser {

    private String username;
    private String password;
    private String in;
    private String out;

    public User(String username, String password, String in, String out) {
        this.username = username;
        this.password = password;
        this.in = in;
        this.out = out;
    }

    public User(){}

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getIn() {
        return in;
    }

    @Override
    public void setIn(String in) {
        this.in = in;
    }

    @Override
    public String getOut() {
        return out;
    }

    @Override
    public void setOut(String out) {
        this.out = out;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", in=" + in +
                ", out=" + out +
                '}';
    }
}
