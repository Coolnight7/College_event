package com.example;

import java.sql.SQLException;
import java.util.Scanner;
import com.example.Student;
import com.example.Organizer;

public class Main {
    public static void main(String args[]) throws SQLException{
        
        Scanner sc=new Scanner(System.in);
        try{
        Student s1=new Student();
        Organizer o1=new Organizer();
        while(true){
            System.out.println("--------- College Event Registration System ---------");
            System.out.println("1. Student Login");
            System.out.println("2. Organizer Login");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");
            int ch=sc.nextInt();

            switch(ch){
                    case 1:
                        s1.showMenu();
                        break;
                    case 2:
                        o1.show();
                        break;
                    case 3:
                        System.out.println("Bye Bye ;( ");
                        System.exit(0);
                    default:
                        System.out.println("1Invalid choice");
            }
        }
    }
    catch(Exception e){e.printStackTrace();}
    }
}
