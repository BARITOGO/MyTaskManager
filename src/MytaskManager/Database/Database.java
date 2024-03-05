package MytaskManager.Database;

//import java.sql.Connection;
//import java.sql.SQLException;
//import library.database.DatabaseConnection;

//public class Database {
//        private static Database instance;
//    private Connection connection;
//    public static Database getInstance(){
//        if (instance==null) {
//            instance = new Database();
//        }
//        return instance;
//    }
//        private Database(){
//        
//    }
//    public void ConnectToDatabase() throws  SQLException, ClassNotFoundException{
//        String server = "127.0.0.1";
//        String port = "3306";
//        String database ="My_Task_Manager_System";
//        String user = "root";
//        String password = "12345";
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        connection = (Connection) java.sql.DriverManager.getConnection("jdbc:mysql://"+server+":"+port+"/"+database,user,password);
//    }
//    public Connection getConnection() {
//        return connection;
//   }
//}



import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.SQLException;


public class Database {
    
         private static Database instance;
    private Connection connection;
    public static Database getInstance(){
        if (instance==null) {
            instance = new Database();
        }
        return instance;
    }
        private Database(){
        
    }
    
     public void ConnectToDatabase() throws  SQLException, ClassNotFoundException{
        String server = "127.0.0.1";
        String port = "3307";
        String database ="mytask";
        String user = "root";
        String password = "rootV12morjana";
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = (Connection) java.sql.DriverManager.getConnection("jdbc:mysql://"+server+":"+port+"/"+database,user,password);
    }
    public Connection getConnection() {
        return connection;
    }
 
}


//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class Database {
//    private static Database instance = new Database();
//    private Connection connection;
//
//    private static final String DB_HOST = "localhost";
//    private static final String DB_PORT = "3307"; // Update with your MySQL port
//    private static final String ROOT_USERNAME = "root"; // Update with your MySQL root username
//    private static final String ROOT_PASSWORD = "rootV12morjana"; // Update with your MySQL root password
//
//    private Database() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static Database getInstance() {
//        return instance;
//    }
//
//    public Connection getConnection() {
//        return connection;
//    }
//
//    public void ConnectToDatabase(String databaseName) throws SQLException {
//        String url = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + databaseName;
//        connection = DriverManager.getConnection(url, ROOT_USERNAME, ROOT_PASSWORD);
//    }
//}


