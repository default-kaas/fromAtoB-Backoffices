package fromatobbackoffice;
import java.sql.*;

public class DatabaseConnection {
    
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement prepareStatement;
    
    private static final String USERNAME = "wnk012";
    private static final String PASSWORD = "wnk012";
    private static final String CONN_STRING = "jdbc:mysql://jestii.nl:3306/wnk012";
    
    public DatabaseConnection(){
        
        try{
            System.out.println("Succes");
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);    
        }catch(Exception ex){
            System.out.println("Erro: "+ ex);
        }
        
    }
    
    public void databaseConnection(){
        
        try{
            System.out.println("Succes");
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);    
        }catch(Exception ex){
            System.out.println("Erro: "+ ex);
        }
        
    }
    
    
    public void getLockerAndStation(){
    
    
    String sql = "SELECT * FROM administrator WHERE username = ?";
    prepareStatement = connection.prepareStatement(sql);
    prepareStatement.setString(1, user);
    ResultSet resultSet = prepareStatement.executeQuery();
    }
    
}
