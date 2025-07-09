package com.example;

import java.sql.*;
import java.util.Scanner;

public class Organizer {

    static String pwd="Mango123";
    Scanner sc=new Scanner(System.in);
    Connection conn;

    public Organizer() throws SQLException{
     conn=DBCon.getConnection();
    }

    public void show(){
        System.out.println("Enter Organizer password: ");
        String upass=sc.next();

        if(!upass.equals(pwd)){
            System.out.println("Wrong password!");
            return;
        }

        while (true) {
            System.out.println("------ Organizer Menu ------");
            System.out.println("1. Add event ");
            System.out.println("2. View event ");
            System.out.println("3. View participents");
            System.out.println("4. Delete event ");
            System.out.println("5. Back");
            int ch=sc.nextInt();

            switch (ch) {
                case 1:
                    addEvent();
                    break;
                case 2:
                    viewevent();
                    break;
                case 3:
                    viewParti();
                    break;
                case 4:
                    delEvent(); break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    
    public void addEvent(){
        
        System.out.print("Enter Event id:  ");
        int eventId=sc.nextInt();

        System.out.print("Enter Event Name:  ");
        String eventName=sc.next();

        System.out.print("Enter Event Date(yyyy-mm-dd):  ");
        String eventDate=sc.next();

        System.out.print("Enter Event LOcation:  ");
        String eventLocation=sc.next();

        try(Connection conn=DBCon.getConnection()){

            String query="INSERT INTO events(eid,ename,edate,eloc) values(?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setInt(1,eventId);
            ps.setString(2,eventName);
            ps.setString(3,eventDate);
            ps.setString(4,eventLocation);
            int rows=ps.executeUpdate();

            if(rows>0)
                System.out.println("Event added succesfully (O ^ O)");
            else
                System.out.println("failed to add  (T - T)");
            
        }
        catch(Exception e){e.printStackTrace();}
    }

    public void viewevent(){
        try{
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select *from events");
            while(rs.next()){
                System.out.println(rs.getInt("eid")+":"+rs.getString("ename")+" on "+rs.getString("edate")+" At "+rs.getString("eloc"));
            }
        }
        catch(Exception e){e.printStackTrace();}
    }

    public void viewParti(){

        System.out.print("Enter Event id:  ");
        int eventId=sc.nextInt();

        String query="select r.rolno,r.studname,e.eid,e.ename from events e join registrations r on e.eid=r.eventId where r.eventId=?";
        try{
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setInt(1, eventId);
            System.out.println("Participents: ");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt(1)+" : "+rs.getString(2)+" : "+rs.getInt(3)+" : "+rs.getString(4));
            }
        }
        catch(Exception e){e.printStackTrace();}
    }

    public void delEvent(){
        System.out.print("Enter Event id:  ");
        int eventId=sc.nextInt();
        try{
                Statement s=conn.createStatement();
                String query="delete from events where eid= "+eventId;
                s.executeUpdate(query);
                System.out.println("Event deleted (- ^ -)");
        }
        catch(Exception e){e.printStackTrace();}
    }
}
