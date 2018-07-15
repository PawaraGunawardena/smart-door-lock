package com.crystall.smartlockprototype.authutil.firebase;

import com.crystall.smartlockprototype.beans.firebase.User;
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
                .getInstance("https://smart-door-lock-95e14.firebaseio.com")
                .getReference()));
    }


    @Test
    public void testWrite() {
        User user = new User("TEST_USERNAME", "TEST_PASSWORD",
                Timestamp.valueOf("2005-10-10 10:10:10"),
                Timestamp.valueOf("2005-10-11 12:12:12"));
        assertThat(authenticationUtility.write(user), is(1));
    }



}