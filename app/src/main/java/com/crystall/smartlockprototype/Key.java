package com.crystall.smartlockprototype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Key extends AppCompatActivity {

    private String password;
    private EditText editText_password;
    private Button btn_submit;
    private String txt_password;
    private TextView textView;
    private boolean accept  = false;
    public String TAG = "MEEEET";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key);

        editText_password = (EditText) findViewById(R.id.txt_typing_password);
        btn_submit = (Button)findViewById(R.id.btn_submit);
        textView = (TextView)findViewById(R.id.txt_password);

    }

    public boolean password_submit(View v){
        try {
            password = editText_password.getText().toString();
            if (password.equals("passed")) {
                accept = true;
                textView.setText("Verified User");
                return accept;
            } else {
                accept = false;
                textView.setText("Access Denied");
                return accept;
            }
        }catch(Exception e){
            Log.i(TAG, "Message: "+e.getMessage());
        }
        return accept;
    }


}
