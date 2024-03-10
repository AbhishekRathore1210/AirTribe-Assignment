package com.example.airtribe.controller;

import com.example.airtribe.DAO.AirtribeUser;
import com.example.airtribe.DAO.Course;
import com.example.airtribe.DBmanager.DBAirtribe;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class AirtribeController {
    @PostMapping("/updateCourse")
    public void updateCourse(@RequestBody Course course) throws SQLException {
        DBAirtribe.updateCourse(course);
    }
    @PostMapping("/registerUser")
    public void registerUser(@RequestBody AirtribeUser user) throws SQLException {
        DBAirtribe.registerUser(user);
    }

    @PostMapping("/searchUser")
    public AirtribeUser searchUser(@RequestParam String email) throws SQLException {
        return DBAirtribe.searchUserByEmail(email);
    }
}
