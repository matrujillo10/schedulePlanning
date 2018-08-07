package com.scheduleplanning.scheduleplanning;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import database.DB;
import model.User;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_SCHEDULE = "com.scheduleplanning.scheduleplanning.EXTRA_SCHEDULE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    /** Called when the user taps the Send button */
    public void login(View view) {
        Intent intent = new Intent(this, ListMessageActivity.class);
        EditText username = findViewById(R.id.username_login);
        EditText password = findViewById(R.id.password_login);
        // TODO: Preguntar a la api
        User user = null;
        if (user == null) {
            Toast.makeText(this, "Usuario o contraseña incorrecta", Toast.LENGTH_LONG).show();
        } else {
            intent.putExtra(EXTRA_SCHEDULE, user.getSchedule().toArray());
            startActivity(intent);
        }
    }
}
