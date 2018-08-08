package com.scheduleplanning.api;

import java.util.List;

import com.scheduleplanning.model.Course;

public class ResponseData {

    private String _id;
    private List<Course> schedule;

    public ResponseData() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public List<Course> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Course> schedule) {
        this.schedule = schedule;
    }
}
