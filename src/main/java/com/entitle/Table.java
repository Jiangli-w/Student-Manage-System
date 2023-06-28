package com.entitle;

public class Table {
    String ct_id;
    String course_id;
    String course_name;
    String class_id;
    String tc_name;
    String time;
    String place;
    String course_hours;

    public String getCt_id() {
        return ct_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public String getClass_id() {
        return class_id;
    }

    public String getTc_name() {
        return tc_name;
    }

    public String getTime() {
        return time;
    }

    public String getPlace() {
        return place;
    }

    public String getCourse_hours() {
        return course_hours;
    }

    public void setCt_id(String ct_id) {
        this.ct_id = ct_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public void setTc_name(String tc_name) {
        this.tc_name = tc_name;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setCourse_hours(String course_hours) {
        this.course_hours = course_hours;
    }

    @Override
    public String toString() {
        return "Table{" +
                "ct_id='" + ct_id + '\'' +
                ", course_id='" + course_id + '\'' +
                ", course_name='" + course_name + '\'' +
                ", class_id='" + class_id + '\'' +
                ", tc_name='" + tc_name + '\'' +
                ", time='" + time + '\'' +
                ", place='" + place + '\'' +
                ", course_hours='" + course_hours + '\'' +
                '}';
    }
}
