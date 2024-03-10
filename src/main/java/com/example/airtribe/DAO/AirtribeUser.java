package com.example.airtribe.DAO;

public class AirtribeUser {
    private String name;
    private String email;
    private String phone_no;
    private String linkdin;
    private String course_name;
//    private String status;

    public AirtribeUser(String name, String email, String phone_no, String linkdin, String course_name) {
        this.name = name;
        this.email = email;
        this.phone_no = phone_no;
        this.linkdin = linkdin;
        this.course_name = course_name;
//        this.status = status;
    }

//    public String getStatus() {
//        return status;
//    }

//    public void setStatus(String status) {
//        this.status = status;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getLinkdin() {
        return linkdin;
    }

    public void setLinkdin(String linkdin) {
        this.linkdin = linkdin;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }
}
