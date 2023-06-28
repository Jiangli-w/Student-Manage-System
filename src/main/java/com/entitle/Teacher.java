package com.entitle;

public class Teacher {
    String tc_id;
    String tc_name;
    String tc_sex;
    String tc_birth;
    String tc_depart;
    String tc_phone;

    public Teacher() {
    }

    public Teacher(String tc_id, String tc_name, String tc_sex, String tc_birth, String tc_depart, String tc_phone) {
        this.tc_id = tc_id;
        this.tc_name = tc_name;
        this.tc_sex = tc_sex;
        this.tc_birth = tc_birth;
        this.tc_depart = tc_depart;
        this.tc_phone = tc_phone;
    }

    public String getTc_id() {
        return tc_id;
    }

    public String getTc_name() {
        return tc_name;
    }

    public String getTc_sex() {
        return tc_sex;
    }

    public String getTc_birth() {
        return tc_birth;
    }

    public String getTc_depart() {
        return tc_depart;
    }

    public String getTc_phone() {
        return tc_phone;
    }

    public void setTc_id(String tc_id) {
        this.tc_id = tc_id;
    }

    public void setTc_name(String tc_name) {
        this.tc_name = tc_name;
    }

    public void setTc_sex(String tc_sex) {
        this.tc_sex = tc_sex;
    }

    public void setTc_birth(String tc_birth) {
        this.tc_birth = tc_birth;
    }

    public void setTc_depart(String tc_depart) {
        this.tc_depart = tc_depart;
    }

    public void setTc_phone(String tc_phone) {
        this.tc_phone = tc_phone;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tc_id='" + tc_id + '\'' +
                ", tc_name='" + tc_name + '\'' +
                ", tc_sex='" + tc_sex + '\'' +
                ", tc_birth='" + tc_birth + '\'' +
                ", tc_depart='" + tc_depart + '\'' +
                ", tc_phone='" + tc_phone + '\'' +
                '}';
    }
}
