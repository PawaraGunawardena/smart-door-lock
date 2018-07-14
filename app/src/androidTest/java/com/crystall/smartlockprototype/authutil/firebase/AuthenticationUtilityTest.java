package com.crystall.smartlockprototype.authutil.firebase;

import com.google.firebase.database.FirebaseDatabase;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class AuthenticationUtilityTest {

    private final AuthenticationUtility authenticationUtility = new AuthenticationUtility();


    // TODO: Write the tests.
    @Test
    public void testInitialize() {
        assertThat(authenticationUtility.initialize(), is(FirebaseDatabase
                .getInstance("https://smart-door-lock-95e14.firebaseio.com")
                .getReference()));
    }



}