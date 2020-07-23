package com.example.navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button LoginButton;
    EditText name, pass;
    SharedPreferences pref;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginButton= (Button) findViewById(R.id.button);
        name = (EditText) findViewById(R.id.txtName);
        pass= (EditText) findViewById(R.id.txtPwd);

        pref = getSharedPreferences("Login_info",MODE_PRIVATE);

        final Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        if(pref.contains("username")&& pref.contains("password")) {
            startActivity(intent);
        }
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = name.getText().toString();
                String password = pass.getText().toString();
                if (username.equals("suhii") && password.equals("12345")) {
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("username", username);
                    editor.putString("password", password);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Credential are not valid", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}