package fromatobbackoffice;
import java.awt.List;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnection {
    
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement prepareStatement;
    private Station station;
    
    private static final String USERNAME = "wnk012";
    private static final String PASSWORD = "wnk012";
    private static final String CONN_STRING = "jdbc:mysql://jestii.nl:3306/wnk012";
    
    public void databaseConnection(){
        
        try{
            System.out.println("Succes");
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);    
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }  
    }
    
    public ArrayList getStationNames(){
    try{
        databaseConnection();
        
        String sql = "SELECT Name_station FROM Station";
        prepareStatement = connection.prepareStatement(sql);
        resultSet = prepareStatement.executeQuery();
        
        ArrayList<Station> stationNames = new ArrayList<>();
        
        while (resultSet.next()) {
            Station s = new Station();
            String sN = resultSet.getString("Name_station");
            s.setStationName(sN);
            stationNames.add(s);
        }
        
        return stationNames;
    } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
            return null;
        } catch (Exception ex) {
            //Handle errors for Class.forName
            ex.printStackTrace();
            return null;
        } 
    }
    
    public void getLockerAndStation(){
    try{
        databaseConnection();
        
    //    int stationID = stationSelect.getInt().trim();
        
        String sql = "SELECT Station_ID, Name_station FROM Station";
        prepareStatement = connection.prepareStatement(sql);
        ResultSet resultSet = prepareStatement.executeQuery();
    } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception ex) {
            //Handle errors for Class.forName
            ex.printStackTrace();
        } 
    } 
    
}
