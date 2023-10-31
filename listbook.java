package OnlineBookStore;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class listbook {
	 public static void list(Connection connection) throws SQLException {
	        Statement statement = connection.createStatement();
	        String query = "SELECT * FROM books";
	        ResultSet resultSet = statement.executeQuery(query);

	        System.out.println("The List of Books :");
	        System.out.println("ID | Title | Author | Price | Quantity");
	        System.out.println("------------");
	        
//	        getting the info of books
	        while (resultSet.next()) {
	            int id = resultSet.getInt("id");
	            String title = resultSet.getString("title");
	            String author = resultSet.getString("author");
	            double price = resultSet.getDouble("price");
	            int quantity = resultSet.getInt("quantity");

	       
	            System.out.println(id + " | " + title + " | " + author + " | RS." + price + " | " + quantity);
	            System.out.println("________");
	        }
	        resultSet.close();
	        statement.close();
	    }
}
