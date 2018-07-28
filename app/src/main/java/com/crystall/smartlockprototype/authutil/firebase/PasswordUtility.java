package com.crystall.smartlockprototype.authutil.firebase;

import com.crystall.smartlockprototype.authutil.IPasswordUtility;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtility implements IPasswordUtility {

    /**
     * Hashes the password
     * @param password
     * @return hash
     */
    @Override
    public String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    /**
     * Dehash the password check it.
     * @param candidate
     * @param hash
     * @return true -> Matches, false -> does not match
     */
    @Override
    public boolean dehashAndCheck(String candidate ,String hash) {
        return BCrypt.checkpw(candidate, hash);
    }
}
