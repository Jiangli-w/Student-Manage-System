package com.entitle;

public class Score {
    String stu_id;
    String course_id;
    String stu_name;
    String course_name;
    int score;

    public String getStu_id() {
        return stu_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public int getScore() {
        return score;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "stu_id='" + stu_id + '\'' +
                ", course_id='" + course_id + '\'' +
                ", stu_name='" + stu_name + '\'' +
                ", course_name='" + course_name + '\'' +
                ", score=" + score +
                '}';
    }
}
