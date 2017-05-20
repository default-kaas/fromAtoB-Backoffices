package fromatobbackoffice;
import java.awt.List;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnection {
    
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement pstmt;
    private Station station;
    private Locker locker;
    
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
        
        String sql = "SELECT name FROM stations";
        pstmt = connection.prepareStatement(sql);
        resultSet = pstmt.executeQuery();
        
        ArrayList<Station> stationNames = new ArrayList<>();
        
        while (resultSet.next()) {
            Station s = new Station();
            String sN = resultSet.getString("name");
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
       
}
