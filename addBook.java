package OnlineBookStore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class addBook{
	public static void add(Connection connection) throws SQLException {
		
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        String sql = "INSERT INTO books (title, author, price, quantity) VALUES (?, ?, ?, ?)";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, title);
        preparedStatement.setString(2, author);
        preparedStatement.setDouble(3, price);
        preparedStatement.setInt(4, quantity);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        
        System.out.println("Book added successfully.");
    }


}