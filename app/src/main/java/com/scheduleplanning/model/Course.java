package com.scheduleplanning.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Course implements Serializable {
    public final static String NRC = "nrc";
    public final static String CLASS_NAME = "class";
    public final static String COURSE = "course";
    public final static String SECTION = "section";
    public final static String CREDITS = "credits";
    public final static String TITLE = "title";
    public final static String LIMIT = "limit";
    public final static String REGISTERED = "registered";
    public final static String EMPTY = "empty";
    public final static String SCHEDULES = "schedules";
    public final static String INSTRUCTORS = "instructors";
    public final static String CYCLE = "cycle";
    public final static String CAMPUS = "campus";
    public final static String COMPL = "compl";
    public final static String IS_COMPL = "is_compl";
    public final static String ATTR = "attr";

    private String nrc;
    @SerializedName("class")
    private String className;
    private String course;
    private int section;
    private double credits;
    private String title;
    private int limit;
    private int registered;
    @SerializedName("empty")
    private int available;
    private List<Schedule> schedules;
    private List<Instructor> instructors;
    private String cycle;
    private String campus;
    private List<Class> compl;
    @SerializedName("is_compl")
    private boolean isCompl;
    private List<String> attr;

    public Course() {
    }

    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getRegistered() {
        return registered;
    }

    public void setRegistered(int registered) {
        this.registered = registered;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public List<Class> getCompl() {
        return compl;
    }

    public void setCompl(List<Class> compl) {
        this.compl = compl;
    }

    public boolean isCompl() {
        return isCompl;
    }

    public void setCompl(boolean compl) {
        isCompl = compl;
    }

    public List<String> getAttr() {
        return attr;
    }

    public void setAttr(List<String> attr) {
        this.attr = attr;
    }
}
