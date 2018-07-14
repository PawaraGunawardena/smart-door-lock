package com.crystall.smartlockprototype.authutil.firebase;

import com.crystall.smartlockprototype.authutil.IAuthenticationUtililty;
import com.crystall.smartlockprototype.authutil.IAuthenticationUtililty;
import com.crystall.smartlockprototype.beans.firebase.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AuthenticationUtility implements IAuthenticationUtililty {

    private DatabaseReference databaseReference;

    /**
     * Initializes the db connection
     * @return DatabaseReference instance.
     */
    @Override
    public DatabaseReference initialize() {
        return FirebaseDatabase.getInstance().getReference();
    }

    /**
     * Writes to the database.
     * @param user
     * @return 0 -> failure 1 -> success.
     */
    @Override
    public int write(User user) {
        getDatabaseReference().child("users").child(user.getUsername()).setValue(user);
        return 0;
    }

    /**
     * Read from the database.
     * @param user
     * @return User
     */
    @Override
    public User read(User user) {
        return null;
    }

    /**
     * Updates user
     * @param user
     * @return 0 -> failure 1 -> success.
     */
    @Override
    public int update(User user) {
        return 0;
    }

    /**
     * Deletes a user.
     * @param name
     * @return 0 -> failure 1 -> success.
     */
    @Override
    public int delete(String name) {
        return 0;
    }

    /**
     * Gets the database reference to the context of this class.
     * @return DatabaseReference
     */
    private DatabaseReference getDatabaseReference() {
        return databaseReference;
    }
}
