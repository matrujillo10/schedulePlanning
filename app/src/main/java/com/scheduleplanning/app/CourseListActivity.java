package com.scheduleplanning.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.scheduleplanning.app.adapters.RecyclerCourseAdapter;
import com.scheduleplanning.model.Course;
import com.scheduleplanning.proxy.ScheduleProxy;
import com.scheduleplanning.scheduleplanning.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CourseListActivity extends AppCompatActivity {

    public static final String EXTRA_COURSE = "com.scheduleplanning.app.COURSE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);
        Intent intent = getIntent();
        List<Course> data = (List<Course>) intent.getSerializableExtra(MainActivity.EXTRA_SCHEDULE);
        List<ScheduleProxy> schedules = new ArrayList<>();
        RecyclerView rv = findViewById(R.id.courses_rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        rv.setAdapter(new RecyclerCourseAdapter(data, new RecyclerCourseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Course course) {
                final Intent intent = new Intent(getApplicationContext(), ListScheduleActivity.class);
                intent.putExtra(EXTRA_COURSE, course);
                startActivity(intent);
            }
        }));
    }
}
