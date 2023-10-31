package OnlineBookStore;

import java.sql.*;
import java.util.Scanner;

public class mainApp {
    static final String url= "jdbc:mysql://localhost:3306/bookstore"; 
    static final String user = "root";
    static final String password = "root";

    public static void main(String[] args) {
    	
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
        	
            Scanner scanner = new Scanner(System.in);
             listbook listbooks = new listbook();
             addBook add = new addBook();
             buyBook buy = new buyBook();
            while (true) {
            	System.out.println("----------------");
                System.out.println("1. List Books");
                System.out.println("2. Add a Book");
                System.out.println("3. Buy Book");
                System.out.println("4. Exit");
                System.out.println("----------------");
                System.out.print("Enter your choice: ");
               
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                    	listbooks.list(connection);
                        break;
                    case 2:
                        addBook.add(connection);
                        break;
                    case 3:
                        buyBook.buy(connection);
                        break;
                    case 4:
                        System.out.println("Exiting the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
        
        catch (SQLException e) {
            e.printStackTrace();
        } 
        
    } 
}
    
