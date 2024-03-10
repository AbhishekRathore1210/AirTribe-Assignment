package com.example.airtribe.DBmanager;

import com.example.airtribe.DAO.AirtribeUser;
import com.example.airtribe.DAO.Course;

import java.sql.*;

public class DBAirtribe {
    private static String tableName;
    public static void setTableName(String st){
        tableName = st;
    }
    public static String getTableName(){
        return tableName;
    }
    private static volatile Connection connection;
    public static Connection get(){
        return connection;
    }
    public static Connection getConnection() throws SQLException {
        if(connection==null){
            synchronized(DBAirtribe.class){
                if(connection==null){
                    connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/AirTribe","root","root12101413");
                }
            }
        }
        return connection;
    }
    public static void closeConnection() throws SQLException {
        if(connection!=null) {
            synchronized (DBAirtribe.class) {
                if (connection != null) {
                    connection = null;
                }
            }
        }
    }
    public static void updateCourse(Course course) throws SQLException {
        getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO course (name,max_seat,start_date,inst_id) VALUES(?,?,?,?)");
        statement.setString(1, course.getName());
        statement.setInt(2, course.getMax_seat());
        statement.setString(3, course.getStart_date());
        statement.setInt(4, course.getInst_id());
        Statement statement1 = connection.createStatement();
        ResultSet res = statement1.executeQuery("select* from course where name = '"+course.getName()+"';");
        if(!res.next()){
            statement.executeUpdate();
            System.out.println("Course Added Successfully!!");
        }
        else{
            System.out.println("Course is already made!!");
        }
//        int rows_affected = statement.executeUpdate();
//        if(rows_affected > 0){
//            System.out.println("Course Added Succesfully");
//        }
//        else{
//            System.out.println("Unable to add Course");
//        }
        closeConnection();
    }

    public static void registerUser(AirtribeUser user) throws SQLException {
        getConnection();
        PreparedStatement statement = get().prepareStatement("INSERT INTO user (name,email,phone_no,linkdin,course_name) VALUES(?,?,?,?,?);");
        statement.setString(1, user.getName());
        statement.setString(2,user.getEmail());
        statement.setString(3,user.getPhone_no());
        statement.setString(4,user.getLinkdin());
        statement.setString(5,user.getCourse_name());
        setTableName(user.getCourse_name());
        Statement st = connection.createStatement();
        ResultSet res = st.executeQuery("SELECT phone_no from user WHERE phone_no = "+user.getPhone_no()+";");
        if (!res.next()) {
            statement.executeUpdate();
            Statement statement1 = connection.createStatement();
            statement1.execute("create table if not exists "+getTableName()+"( ph_no varchar(20),status varchar(20) default 'accept',comment varchar(100) default 'Welcome to "+getTableName()+" Course');");
            PreparedStatement st1 = connection.prepareStatement("INSERT INTO "+getTableName()+"(ph_no) values(?);");
            st1.setString(1,user.getPhone_no());
            st1.executeUpdate();
            System.out.println("Register Successfully");
        } else {
            System.out.println("User Already Exists");
        }
        closeConnection();
    }

    public static AirtribeUser searchUserByEmail(String email) throws SQLException {
        getConnection();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery("Select * from user where email = "+email+";");
        while(res.next()){
            String name = res.getString(1);
            String e = res.getString(2);
            String phone_no = res.getString(3);
            String linkdin = res.getString(4);
            String course_name = res.getString(5);
            AirtribeUser user = new AirtribeUser(name,e,phone_no,linkdin,course_name);
            closeConnection();
            return user;
        }
        return null;
    }

}
