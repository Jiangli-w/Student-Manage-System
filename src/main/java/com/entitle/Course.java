package com.entitle;

public class Course {
    String course_id;
    String course_name;
    String course_hours;
    String course_credit;

    public Course() {
    }

    public Course(String course_id, String course_name, String course_hours, String course_credit) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.course_hours = course_hours;
        this.course_credit = course_credit;
    }

    public String getCourse_id() {
        return course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public String getCourse_hours() {
        return course_hours;
    }

    public String getCourse_credit() {
        return course_credit;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public void setCourse_hours(String course_hours) {
        this.course_hours = course_hours;
    }

    public void setCourse_credit(String course_credit) {
        this.course_credit = course_credit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id='" + course_id + '\'' +
                ", course_name='" + course_name + '\'' +
                ", course_hours='" + course_hours + '\'' +
                ", course_credit='" + course_credit + '\'' +
                '}';
    }
}
