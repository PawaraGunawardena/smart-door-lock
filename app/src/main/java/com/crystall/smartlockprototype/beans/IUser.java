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
    Timestamp getIn();

    /**
     * Setter
     * @param in
     */
    void setIn(Timestamp in);

    /**
     * Getter
     * @return out
     */
    Timestamp getOut();

    /**
     * Setter
     * @param out
     */
    void setOut(Timestamp out);

}
