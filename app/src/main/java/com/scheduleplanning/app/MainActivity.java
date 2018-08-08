package com.scheduleplanning.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.scheduleplanning.api.Response;
import com.scheduleplanning.api.ResponseData;
import com.scheduleplanning.api.SchedulePlanningService;
import com.scheduleplanning.scheduleplanning.R;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_SCHEDULE = "com.scheduleplanning.app.EXTRA_SCHEDULE";
    public static final String PREFERENCES = "com.scheduleplanning.PREFERENCES";
    public static final String _ID_PREFERENCES = "com.scheduleplanning._ID";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
        String _id = sharedPreferences.getString(_ID_PREFERENCES, "");
        if (_id != null && !_id.isEmpty()) {
            callApi(null, null, _id);
        } else {
            setContentView(R.layout.activity_main);
        }
    }

    /** Called when the user taps the Send button */
    public void login(View view) {
        EditText username = findViewById(R.id.username_login);
        EditText password = findViewById(R.id.password_login);
        callApi(username.getText().toString(), password.getText().toString(), null);
    }

    private void callApi(String username, String password, String _id) {
        final Intent intent = new Intent(this, CourseListActivity.class);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://scheduleplanning.us-east-2.elasticbeanstalk.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SchedulePlanningService service = retrofit.create(SchedulePlanningService.class);
        Call<Response> call;
        if (_id == null) {
            call = service.login(username, password);
        } else {
            call = service.getUser(_id);
        }
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response.isSuccessful()) {
                    Response r = response.body();
                    if (r.isStatus()) {
                        ResponseData data = r.getData();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(_ID_PREFERENCES, data.get_id());
                        editor.commit();
                        intent.putExtra(EXTRA_SCHEDULE, (Serializable) data.getSchedule());
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), r.getMessage(), Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "El servidor no responde. Intentar más tarde o comunicarse con el administrador", Toast.LENGTH_LONG).show();
            }
        });
    }
}
