package com.entitle;

public class Student {
    private String stu_id;
    private String stu_name;
    private String stu_sex;
    private String stu_birth;
    private String stu_special;
    private String stu_class_id;
    private String stu_address;
    private String stu_phone;
    private String stu_note;

    public Student(String stu_id, String stu_name, String stu_sex, String stu_birth, String stu_special, String stu_class_id, String stu_address, String stu_phone, String stu_note) {
        this.stu_id = stu_id;
        this.stu_name = stu_name;
        this.stu_sex = stu_sex;
        this.stu_birth = stu_birth;
        this.stu_special = stu_special;
        this.stu_class_id = stu_class_id;
        this.stu_address = stu_address;
        this.stu_phone = stu_phone;
        this.stu_note = stu_note;
    }

    public Student() {
    }

    public String getStu_id() {
        return stu_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public String getStu_sex() {
        return stu_sex;
    }

    public String getStu_birth() {
        return stu_birth;
    }

    public String getStu_special() {
        return stu_special;
    }

    public String getStu_class_id() {
        return stu_class_id;
    }

    public String getStu_address() {
        return stu_address;
    }

    public String getStu_phone() {
        return stu_phone;
    }

    public String getStu_note() {
        return stu_note;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public void setStu_sex(String stu_sex) {
        this.stu_sex = stu_sex;
    }

    public void setStu_birth(String stu_birth) {
        this.stu_birth = stu_birth;
    }

    public void setStu_special(String stu_special) {
        this.stu_special = stu_special;
    }

    public void setStu_class_id(String stu_class_id) {
        this.stu_class_id = stu_class_id;
    }

    public void setStu_address(String stu_address) {
        this.stu_address = stu_address;
    }

    public void setStu_phone(String stu_phone) {
        this.stu_phone = stu_phone;
    }

    public void setStu_note(String sru_note) {
        this.stu_note = sru_note;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stu_id='" + stu_id + '\'' +
                ", stu_name='" + stu_name + '\'' +
                ", stu_sex='" + stu_sex + '\'' +
                ", stu_birth='" + stu_birth + '\'' +
                ", stu_special='" + stu_special + '\'' +
                ", stu_class_id='" + stu_class_id + '\'' +
                ", stu_address='" + stu_address + '\'' +
                ", stu_phone='" + stu_phone + '\'' +
                ", stu_note='" + stu_note + '\'' +
                '}';
    }
}
