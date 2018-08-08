package com.scheduleplanning.proxy;

import com.scheduleplanning.model.Schedule;

public class ScheduleProxy {

    private Schedule schedule;
    private String instructor;
    private String name;

    public ScheduleProxy(Schedule schedule, String instructor, String name) {
        this.schedule = schedule;
        this.instructor = instructor;
        this.name = name;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
