package com.example.airtribe.DAO;

public class Course {
    private String name;
    private int max_seat;
    private String start_date;
    private int inst_id;

    public Course(String name, int max_seat, String start_date, int inst_id) {
        this.name = name;
        this.max_seat = max_seat;
        this.start_date = start_date;
        this.inst_id = inst_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMax_seat() {
        return max_seat;
    }

    public void setMax_seat(int max_seat) {
        this.max_seat = max_seat;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public int getInst_id() {
        return inst_id;
    }

    public void setInst_id(int inst_id) {
        this.inst_id = inst_id;
    }
}
