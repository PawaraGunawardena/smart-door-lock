package com.crystall.smartlockprototype.beans.firebase;

import com.crystall.smartlockprototype.beans.IUser;

import java.sql.Timestamp;

public class User implements IUser {

    private String username;
    private String password;
    private Timestamp in;
    private Timestamp out;

    public User(String username, String password, Timestamp in, Timestamp out) {
        this.username = username;
        this.password = password;
        this.in = in;
        this.out = out;
    }

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
    public Timestamp getIn() {
        return in;
    }

    @Override
    public void setIn(Timestamp in) {
        this.in = in;
    }

    @Override
    public Timestamp getOut() {
        return out;
    }

    @Override
    public void setOut(Timestamp out) {
        this.out = out;
    }
}
