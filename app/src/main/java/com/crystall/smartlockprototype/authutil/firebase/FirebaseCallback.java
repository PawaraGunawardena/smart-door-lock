package com.crystall.smartlockprototype.authutil.firebase;

import com.crystall.smartlockprototype.beans.firebase.User;

public interface FirebaseCallback {
    void onCallback(User user);
}
