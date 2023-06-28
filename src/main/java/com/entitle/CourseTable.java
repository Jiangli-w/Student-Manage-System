package com.entitle;

public class CourseTable {

    String ct_id;
    String course_id;
    String class_id;
    String teacher_id;
    String time;
    String place;

    public CourseTable() {
    }

    public CourseTable(String ct_id, String course_id, String class_id, String teacher_id, String time, String place) {
        this.ct_id = ct_id;
        this.course_id = course_id;
        this.class_id = class_id;
        this.teacher_id = teacher_id;
        this.time = time;
        this.place = place;
    }

    public String getCt_id() {
        return ct_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public String getClass_id() {
        return class_id;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public String getTime() {
        return time;
    }

    public String getPlace() {
        return place;
    }

    public void setCt_id(String ct_id) {
        this.ct_id = ct_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "CourseTable{" +
                "ct_id='" + ct_id + '\'' +
                ", course_id='" + course_id + '\'' +
                ", class_id='" + class_id + '\'' +
                ", teacher_id='" + teacher_id + '\'' +
                ", time='" + time + '\'' +
                ", place='" + place + '\'' +
                '}';
    }
}
