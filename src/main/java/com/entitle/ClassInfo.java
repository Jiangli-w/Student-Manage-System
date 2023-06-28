package com.entitle;

public class ClassInfo {
    String class_id;
    String class_name;
    String class_special;
    int class_number;
    String class_year;
    String class_instructor;

    public ClassInfo() {
    }

    public ClassInfo(String class_id, String class_name, String class_special, int class_number, String class_year, String class_instructor) {
        this.class_id = class_id;
        this.class_name = class_name;
        this.class_special = class_special;
        this.class_number = class_number;
        this.class_year = class_year;
        this.class_instructor = class_instructor;
    }

    public String getClass_id() {
        return class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public String getClass_special() {
        return class_special;
    }

    public int getClass_number() {
        return class_number;
    }

    public String getClass_year() {
        return class_year;
    }

    public String getClass_instructor() {
        return class_instructor;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public void setClass_special(String class_special) {
        this.class_special = class_special;
    }

    public void setClass_number(int class_number) {
        this.class_number = class_number;
    }

    public void setClass_year(String class_year) {
        this.class_year = class_year;
    }

    public void setClass_instructor(String class_instructor) {
        this.class_instructor = class_instructor;
    }

    @Override
    public String toString() {
        return "Class{" +
                "class_id='" + class_id + '\'' +
                ", class_name='" + class_name + '\'' +
                ", class_special='" + class_special + '\'' +
                ", class_number='" + class_number + '\'' +
                ", class_year='" + class_year + '\'' +
                ", class_instructor='" + class_instructor + '\'' +
                '}';
    }
}
