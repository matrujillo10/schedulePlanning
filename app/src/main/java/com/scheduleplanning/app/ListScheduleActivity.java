package com.scheduleplanning.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.scheduleplanning.app.adapters.RecyclerScheduleAdapter;
import com.scheduleplanning.model.Course;
import com.scheduleplanning.model.Schedule;
import com.scheduleplanning.proxy.ScheduleProxy;
import com.scheduleplanning.scheduleplanning.R;

import java.util.ArrayList;
import java.util.List;

public class ListScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_schedule);
        Intent intent = getIntent();
        Course course = (Course) intent.getSerializableExtra(CourseListActivity.EXTRA_COURSE);
        List<ScheduleProxy> schedules = new ArrayList<>();
        for (Schedule schedule:
             course.getSchedules()) {
            schedules.add(new ScheduleProxy(schedule, course.getInstructors().get(0).getName(), course.getTitle()));
        }
        RecyclerView rv = findViewById(R.id.schedules_rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        RecyclerScheduleAdapter adapter = new RecyclerScheduleAdapter(schedules);
        rv.setAdapter(adapter);
    }
}
