package com.crystall.smartlockprototype.authutil;

import com.crystall.smartlockprototype.beans.firebase.User;
import com.google.firebase.database.DatabaseReference;

public interface IAuthenticationUtililty {

    /**
     * Initializes the db.
     * @return DatabaseReference
     */
    DatabaseReference initialize();

    /**
     * Writes to the database.
     * @param user
     * @return 0 -> failure 1 -> success.
     */
    int write(User user);

    /**
     * Read from the database.
     * @param user
     * @return User
     */
    User read(User user);

    /**
     * Updates user
     * @param user
     * @return 0 -> failure 1 -> success.
     */
    int update(User user);

    /**
     * Deletes a user.
     * @param name
     * @return 0 -> failure 1 -> success.
     */
    int delete(String name);

}