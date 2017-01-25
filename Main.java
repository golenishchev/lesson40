package com.example.lesson40;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException/*, ClassNotFoundException*/ {

        //Class.forName("com.mysql.jdbc.Driver");

        LaptopBuilder myCustomLaptop = new CustomLaptopBuilder();
        LaptopBuilder myGamingLaptop = new GamingLaptopBuilder();
        LaptopBuilder myTravelLaptop = new TravelLaptopBuilder();
        LaptopEngineer myLaptopEngineer;

                /* here is switch case*/
        System.out.println("Choose a laptop:\n" +
                "Press 1 for a Custom Laptop\n" +
                "Press 2 for the Gaming Laptop\n" +
                "Press 3 for the Travel Laptop");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        ;
        LaptopEngineer chosenLaptop;
        switch (choice) {
            case 1:
                chosenLaptop = new LaptopEngineer(myCustomLaptop);
                break;
            case 2:
                chosenLaptop = new LaptopEngineer(myGamingLaptop);
                break;
            case 3:
                chosenLaptop = new LaptopEngineer(myTravelLaptop);
                break;
            default:
                chosenLaptop = new LaptopEngineer(myCustomLaptop);
                break;
        }

        myLaptopEngineer = chosenLaptop;
        myLaptopEngineer.makeLaptop();
        Laptop firstLaptop = myLaptopEngineer.getLaptop();

        System.out.println("Chosen: " + firstLaptop.getLaptopType());
        System.out.println("GPU: " + firstLaptop.getLaptopGraphics());


        System.out.println("CPU: " + firstLaptop.getLaptopProcessor());

        System.out.println("Screen (inches): " + firstLaptop.getLaptopScreen());

        System.out.println("laptop weight (kg): " + firstLaptop.getLaptopWeight());


        /*--------------------------Connecting to DB-------------------------------*/

        System.out.println("making DB stuff");

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/computerstore?useSSL=false", "root", "root");
            String sql = "insert into laptop_order(type,gpu,cpu,screen,weight) values(?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, firstLaptop.getLaptopType());
            stmt.setString(2, firstLaptop.getLaptopGraphics());
            stmt.setString(3, firstLaptop.getLaptopProcessor());
            stmt.setDouble(4, Double.valueOf(firstLaptop.getLaptopScreen()));
            stmt.setDouble(5, Double.valueOf(firstLaptop.getLaptopWeight()));
            stmt.execute();
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        } finally {
            conn.close();
        }
    }
}
