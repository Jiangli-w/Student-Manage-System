package com.entitle;

public class ScoreInfo {
    String stu_id;
    String course_id;
    int score;

    @Override
    public String toString() {
        return "ScoreInfo{" +
                "stu_id='" + stu_id + '\'' +
                ", course_id='" + course_id + '\'' +
                ", score=" + score +
                '}';
    }

    public ScoreInfo() {
    }

    public ScoreInfo(String stu_id, String course_id, int score) {
        this.stu_id = stu_id;
        this.course_id = course_id;
        this.score = score;
    }

    public String getStu_id() {
        return stu_id;
    }

    public String getCourse_id() {
        return course_id;
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

    public void setScore(int score) {
        this.score = score;
    }
}
