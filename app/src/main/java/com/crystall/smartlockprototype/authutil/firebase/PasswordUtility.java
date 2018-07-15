package com.crystall.smartlockprototype.authutil.firebase;

import com.crystall.smartlockprototype.authutil.IPasswordUtility;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtility implements IPasswordUtility {

    @Override
    public String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @Override
    public boolean dehashAndCheck(String candidate ,String hash) {
        return BCrypt.checkpw(candidate, hash);
    }
}
