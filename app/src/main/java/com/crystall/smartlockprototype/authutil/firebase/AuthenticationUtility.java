package com.crystall.smartlockprototype.authutil.firebase;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.crystall.smartlockprototype.LoggedInActivity;
import com.crystall.smartlockprototype.authutil.IAuthenticationUtililty;
import com.crystall.smartlockprototype.beans.firebase.User;
import com.crystall.smartlockprototype.config.Config;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AuthenticationUtility implements IAuthenticationUtililty {

    private final PasswordUtility passwordUtility = new PasswordUtility();
    private DatabaseReference databaseReference;

    public AuthenticationUtility() {
        initialize();
    }

    /**
     * Initializes the db connection
     *
     * @return DatabaseReference instance.
     */
    @Override
    public DatabaseReference initialize() {

        this.databaseReference = FirebaseDatabase
                .getInstance(Config.FIREBASE_URL)
                .getReference();

        if (this.databaseReference.getDatabase() == null) {
            return null;
        } else {
            Log.i("CONNECTION", "Firebase Connection Successfully Initialized.");
        }

        return databaseReference;

    }

    /**
     * Read from the database.
     * USing a callback for async datastream.
     *
     * @param username
     * @return User
     */
    @Override
    public void read(String username, final FirebaseCallback callback) {

        getDatabaseReference().child("users").child(username)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        User retrievedUser = dataSnapshot.getValue(User.class);
                        if (retrievedUser == null) {
                            return;
                        }
                        callback.onCallback(retrievedUser);
                        Log.i("RETRIEVED_USER", retrievedUser.toString());
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.e("FAILED_TO_RETRIEVE_USER", "User Retrieval Failed.");
                    }
                });
    }

    /**
     * Writes to the database.
     *
     * @param user
     * @return 0 -> failure 1 -> success.
     */
    @Override
    public int write(User user) {

        int result = 0;

        // Hash the password and store
        user.setPassword(passwordUtility.hash(user.getPassword()));

        Task<Void> users = getDatabaseReference().child("users").child(user.getUsername())
                .setValue(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.i("SUCCESS", "Successful Data Write");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("FAILURE", "Failure Data Write");
                    }
                });

        if (users.isSuccessful()) {
            result = 1;
        }

        return result;
    }

    /**
     * Updates user
     *
     * @param user
     * @return 0 -> failure 1 -> success.
     */
    @Override
    public int update(User user) {
        return 0;
    }

    /**
     * Deletes a user.
     *
     * @param name
     * @return 0 -> failure 1 -> success.
     */
    @Override
    public int delete(String name) {
        return 0;
    }

    /**
     * TODO: NodeMCU should be sent the signal here inside if(result[0]) block.
     *
     * @param name
     * @param context
     * @param password
     */
    @Override
    public void login(final String name, final Context context, final String password) {
        final boolean[] result = new boolean[1];
        read(name, new FirebaseCallback() {
            @Override
            public void onCallback(User user) {
                result[0] = passwordUtility.dehashAndCheck(password, user.getPassword());
                if (result[0]) {
                    Intent[] i = {new Intent(context, LoggedInActivity.class)};
                    i[0].setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i[0].putExtra("USER", user);  // Send the user to the next intent.
                    context.startActivities(i);
                } else {
                    Toast.makeText(context, "Please enter proper credentials!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * Gets the database reference to the context of this class.
     *
     * @return DatabaseReference
     */
    private DatabaseReference getDatabaseReference() {
        return databaseReference;
    }
}
