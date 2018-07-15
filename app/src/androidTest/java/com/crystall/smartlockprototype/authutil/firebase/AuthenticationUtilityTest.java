package com.crystall.smartlockprototype.authutil.firebase;

import com.crystall.smartlockprototype.beans.firebase.User;
import com.crystall.smartlockprototype.config.Config;
import com.google.firebase.database.FirebaseDatabase;

import org.junit.Test;

import java.sql.Timestamp;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class AuthenticationUtilityTest {

    private final AuthenticationUtility authenticationUtility = new AuthenticationUtility();

    @Test
    public void testInitialize() {
        assertThat(authenticationUtility.initialize(), is(FirebaseDatabase
                .getInstance(Config.FIREBASE_URL)
                .getReference()));
    }

}