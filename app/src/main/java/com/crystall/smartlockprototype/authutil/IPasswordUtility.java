package com.crystall.smartlockprototype.authutil;

public interface IPasswordUtility {

    /**
     * Hash the password
     * @param password
     * @return hashed password
     */
    String hash(String password);

    /**
     * Dehash the password
     * @param hash
     * @return matches -> true, not-matching -> false
     */
    boolean dehashAndCheck(String candidate, String hash);

}
