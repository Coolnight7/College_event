package com.example;

import java.sql.*;
import java.util.Scanner;

public class Student {
    
    Scanner sc=new Scanner(System.in);
    Connection conn;

    public Student() throws SQLException{
      conn=DBCon.getConnection();
    }

    public void showMenu(){
        while (true) {
            System.out.println("------ Student Menu ------");
            System.out.println("1. view events ");
            System.out.println("2. Register for events ");
            System.out.println("3. View registrations");
            System.out.println("4. Back ");
            int ch=sc.nextInt();

            switch (ch) {
                case 1:
                    viewEvent();
                    break;
                case 2:
                    registerEvent();
                    break;
                case 3:
                    viewRegist();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public void viewEvent(){
        try{
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select *from events");
            while(rs.next()){
                System.out.println(rs.getInt("eid")+":"+rs.getString("ename")+" on "+rs.getString("edate")+" at "+rs.getString("eloc"));
            }
        }
        catch(Exception e){e.printStackTrace();}
    }

    public void registerEvent(){

        System.out.print("Enter Event id to register: ");
        int eid=sc.nextInt();

        System.out.print("Enter Student name and Id: ");
        String sname=sc.next();
        int rollno=sc.nextInt();

        try(Connection conn=DBCon.getConnection()){

            String query="INSERT INTO registrations(studname,rolno,eventId) values(?,?,?)";
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1,sname);
            ps.setInt(2,rollno);
            ps.setInt(3,eid);
            int rows=ps.executeUpdate();

            if(rows>0){
                Registration reg=new Registration(sname, eid);
                reg.start();
                reg.join();
                System.out.println("Registration succesfull (O ^ O)");
            }
            else
                System.out.println("Registration failed (T - T)");
            
        }
        catch(Exception e){e.printStackTrace();}
    }

    public void viewRegist(){

        System.out.println("Enter your student ID: ");
        int sid=sc.nextInt();

        String query="select e.eid,e.ename,e.edate,e.eloc from events e join registrations r on e.eid=r.eventId where r.rolno="+sid;
        try{
            Statement s=conn.createStatement();
            ResultSet rs=s.executeQuery(query);
            System.out.println("Registrations for student id : "+sid);
            while(rs.next()){
                System.out.println(rs.getInt("eid")+":"+rs.getString("ename")+" on "+rs.getString("edate")+" at "+rs.getString("eloc"));
            }
        }
        catch(Exception e){e.printStackTrace();}
    }
}
