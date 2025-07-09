package com.example;

public class Event {

    private int eveId;
    private String eveName;
    private String eveDate;
    private String location;

    public Event(int id,String name,String date,String loc){
        this.eveId=id;
        this.eveName=name;
        this.eveDate=date;
        this.location=loc;
    }

    public void display(){
        System.out.println("Event ID: "+eveId);
        System.out.println("Name: "+eveName);
        System.out.println("Date: "+eveDate);
        System.out.println("Location: "+location);
    }
    
}
