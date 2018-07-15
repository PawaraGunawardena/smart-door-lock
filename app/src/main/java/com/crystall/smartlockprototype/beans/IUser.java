package com.crystall.smartlockprototype.beans;

import java.sql.Timestamp;

public interface IUser {

    /**
     * Getter
     * @return username
     */
    String getUsername();

    /**
     * Setter
     * @param username
     */
    void setUsername(String username);

    /**
     * Getter
     * @return password
     */
    String getPassword();

    /**
     * Setter
     * @param password
     */
    void setPassword(String password);

    /**
     * Getter
     * @return in
     */
    String getIn();

    /**
     * Setter
     * @param in
     */
    void setIn(String in);

    /**
     * Getter
     * @return out
     */
    String getOut();

    /**
     * Setter
     * @param out
     */
    void setOut(String out);

}
