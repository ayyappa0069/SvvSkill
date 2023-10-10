package svvskill;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.sql.*;
import java.util.Scanner;

public class Skill8 {
    public static void main(String[] args) {
        try {
            String host = "localhost";
            String port = "3306";
            Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/svvdb2", "root", "264268");

            // Step 1: Create a table
            Statement createTableStatement = con.createStatement();
            String createTableQuery = "CREATE TABLE IF NOT EXISTS Product ("
                    + "Name VARCHAR(255),"
                    + "Category VARCHAR(255),"
                    + "Image VARCHAR(255),"
                    + "DescriptionFile VARCHAR(255))";
            createTableStatement.executeUpdate(createTableQuery);

            // Step 2: Read input from the console
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Category: ");
            String category = scanner.nextLine();
            System.out.print("Enter Image Path (.jpg): ");
            String imagePath = scanner.nextLine();
            System.out.print("Enter Description File Path (.txt): ");
            String descriptionFilePath = scanner.nextLine();

            // Step 3: Insert values into the table
            PreparedStatement insertStatement = con.prepareStatement("INSERT INTO Product (Name, Category, Image, DescriptionFile) VALUES (?, ?, ?, ?)");
            insertStatement.setString(1, name);
            insertStatement.setString(2, category);
            insertStatement.setString(3, imagePath);
            insertStatement.setString(4, descriptionFilePath);
            insertStatement.executeUpdate();

            // Display inserted values
            System.out.println("Values inserted into the database:");

            PreparedStatement selectStatement = con.prepareStatement("SELECT * FROM Product");
            ResultSet rs = selectStatement.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("Name"));
                System.out.println(rs.getString("Category"));
                System.out.println(rs.getString("Image"));
                System.out.println(rs.getString("DescriptionFile"));
            }

            // Close resources
            con.close();
            scanner.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
