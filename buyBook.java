package OnlineBookStore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class buyBook {
	public static void buy(Connection connection) throws SQLException {
	    Scanner scanner = new Scanner(System.in);
	    System.out.print("Enter book ID to checkout: ");
	    int bookId = scanner.nextInt();

	    String checkAvailabilitySql = "SELECT id, title, author, price FROM books WHERE id = ?";
	    PreparedStatement availabilityStatement = connection.prepareStatement(checkAvailabilitySql);
	    availabilityStatement.setInt(1, bookId);
	    ResultSet availabilityResultSet = availabilityStatement.executeQuery();

	    if (availabilityResultSet.next()) {
	        int id = availabilityResultSet.getInt("id");
	        String title = availabilityResultSet.getString("title");
	        String author = availabilityResultSet.getString("author");
	        double price = availabilityResultSet.getDouble("price");

	        String updateQuantitySql = "UPDATE books SET quantity = quantity - 1 WHERE id = ?";
	        PreparedStatement updateQuantityStatement = connection.prepareStatement(updateQuantitySql);
	        updateQuantityStatement.setInt(1, bookId);

	        if (updateQuantityStatement.executeUpdate() > 0) {
	            System.out.println("Book checked out successfully:");
	            System.out.println("ID: " + id);
	            System.out.println("Title: " + title);
	            System.out.println("Author: " + author);
	            System.out.println("Price: $" + price);
	        } else {
	            System.out.println("Failed to check out the book.");
	        }

	        updateQuantityStatement.close();
	    } else {
	        System.out.println("Book not found.");
	    }

	    availabilityResultSet.close();
	    availabilityStatement.close();
	}

}

	
