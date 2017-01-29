import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ComputerStore {
    private static String whatCPU;
    public static String whatGPU;
    public static String whatScreen;
    public static String whatWeight;

    public void runStore() {

       // Class.forName("com.mysql.jdbc.Driver");

        LaptopBuilder myCustomLaptop = new CustomLaptopBuilder();
        LaptopBuilder myGamingLaptop = new GamingLaptopBuilder();
        LaptopBuilder myTravelLaptop = new TravelLaptopBuilder();
        LaptopEngineer myLaptopEngineer;


        /*---------------------Trying to send input to CustomLaptopBuilder class-----------------------*/



                /* here is switch case*/
        System.out.println("Choose a laptop:\n" +
                "Press 1 for a Custom Laptop\n" +
                "Press 2 for the Gaming Laptop\n" +
                "Press 3 for the Travel Laptop");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();


        LaptopEngineer chosenLaptop;
        switch (choice) {
            case 1:
                System.out.println("what CPU");
                Scanner scan2 = new Scanner(System.in);
                whatCPU = scan2.nextLine();
                System.out.println("what GPU");
                whatGPU = scan2.nextLine();
                System.out.println("what Screen (decimal, for example 40.5)");
                whatScreen = scan2.nextLine();
                System.out.println("what Weight (decimal, for example 1.2)");
                whatWeight = scan2.nextLine();
                setWhatCPU(whatCPU);
                setWhatGPU(whatGPU);
                setWhatScreen(whatScreen);
                setWhatWeight(whatWeight);
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

        PreparedStatement stmt = null;
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/computerstore?useSSL=false", "root", "root")) {
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
        }
    }

    public static String getWhatGPU() {
        return whatGPU;
    }

    public static void setWhatGPU(String whatGPU) {
        ComputerStore.whatGPU = whatGPU;
    }

    public static String getWhatCPU() {
        return whatCPU;
    }

    public static void setWhatCPU(String whatCPU) {
        ComputerStore.whatCPU = whatCPU;
    }

    public static String getWhatScreen() {
        return whatScreen;
    }

    public static void setWhatScreen(String whatScreen) {
        ComputerStore.whatScreen = whatScreen;
    }

    public static String getWhatWeight() {
        return whatWeight;
    }

    public static void setWhatWeight(String whatWeight) {
        ComputerStore.whatWeight = whatWeight;
    }
}
