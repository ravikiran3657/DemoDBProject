package com.jdbc;


import java.sql.*;
public class DemoJdbc {
    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/demojdbc";
        String username = "root";
        String password = "Ammanana@123";

        // Data to be inserted
        int empcode = 110;
        String empname = "clinch";
        int empage = 28;
        double empsalary = 120000.0;

        // SQL query to insert data
        String sql = "INSERT INTO employee (empcode, empname, empage, empsalary) VALUES (?, ?, ?, ?)";

        try  {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Setting parameters for the prepared statement
            preparedStatement.setInt(1, empcode);
            preparedStatement.setString(2, empname);
            preparedStatement.setInt(3, empage);
            preparedStatement.setDouble(4, empsalary);

            // Executing the query
            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("A new record has been inserted successfully.");
            } else {
                System.out.println("Failed to insert the record.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}