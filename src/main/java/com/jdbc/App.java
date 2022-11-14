package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class App
{
    public static void main( String[] args )
    {
        try {
            // Loading the Driver
            Class.forName("com.mysql.jdbc.Driver");

            // Creating Connection
            String url = "jdbc:mysql://localhost:3306/jdbc";
            String userName = "root";
            String password = "220802";
            Connection connection = DriverManager.getConnection(url,userName,password);

            if(connection.isClosed()){
                System.out.println("Closed Connection");
            }
            else{
                System.out.println("Created Connection");
            }

            // Creating Table query
//            String query = "create table employee (id int primary key , name varchar(200) , city varchar(100))";
//            Statement statement = connection.createStatement();
//            statement.executeUpdate(query);
//            System.out.println("Table created.....");
//            connection.close();

            // prepare statement
            String q = "insert into employee (id,name,city) values (?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(q);
            preparedStatement.setInt(1,222);
            preparedStatement.setString(2,"john");
            preparedStatement.setString(3,"Ahmedabad");

            preparedStatement.executeUpdate();

            System.out.println("Inserted....");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
