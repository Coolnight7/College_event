package com.example;


public class Registration extends Thread{
    String studname;
    int id;

    Registration(String n,int ei){
        this.studname=n;
        this.id=ei;
    }

    public void run(){
        System.out.println("Processing registration for "+studname+" for even "+id);
        try{
            Thread.sleep(2000);
        }
        catch(Exception e)
        {
            System.out.println("Thread Inturrupted");
        }
        System.out.println("Registration completed for "+studname+" @ @ @ ");
    }
}
