package DAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ConnectionDB {

    public static Connection getConnection() throws SQLException {
        try (InputStream input = ConnectionDB.class.getClassLoader().getResourceAsStream("database.properties")) {

            Properties prop = new Properties();

            prop.load(input);

            String url = prop.getProperty("database.url");
            String user = prop.getProperty("database.user");
            String pass = prop.getProperty("database.password");

            return DriverManager.getConnection(url, user, pass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    private static final String URL = "jdbc:mysql://localhost:3306/IT_Company";
//    private static final String USERNAME = "root";
//    private static final String PASSWORD = "1234";
//    private static Connection connection;
//
//    public static Connection getConnection() throws SQLException, IOException{
//        try {
//            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//            if (!connection.isClosed()) {
//                System.out.println("Successful connection with DB");
//            }else{
//                System.out.println("failed");
//            }
//        }
//        catch(Exception e){
//            System.out.println("Connection failed...");
//            e.printStackTrace();
//        }
//        return connection;
//    }
}

