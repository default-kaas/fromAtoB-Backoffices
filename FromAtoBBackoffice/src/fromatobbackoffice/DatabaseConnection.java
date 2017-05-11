package fromatobbackoffice;
import java.sql.*;

public class DatabaseConnection {
    
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    
    private static final String USERNAME = "wnk012";
    private static final String PASSWORD = "wnk012";
    private static final String CONN_STRING = "jdbc:mysql://A2B:3306/wnk012";
    
    public DatabaseConnection(){
        
        try{
            Class.forName("com.mysql.jdbc.driver");
            connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);    
        }catch(Exception ex){
            System.out.println("Erro: "+ ex);
        }
        
    }
    
    
}
