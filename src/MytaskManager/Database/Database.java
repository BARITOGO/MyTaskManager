package MytaskManager.Database;
//
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import library.database.DatabaseConnection;

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
        String port = "3306";
        String database ="My_Task_Manager_System";
        String user = "root";
        String password = "12345";
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = (Connection) java.sql.DriverManager.getConnection("jdbc:mysql://"+server+":"+port+"/"+database,user,password);
    }
    public Connection getConnection() {
        return connection;
    }
}




//public class Database {
//   public static void main(String[] args) {  
//        Connection con;
//         PreparedStatement pst;
//        try {
//           
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/My_Task_Manager_System","root","12345");
//            System.out.println("sucess");
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
//
//    public static Connection getcon() {
//        throw new UnsupportedOperationException("Not supported yet."); 
//    } 



