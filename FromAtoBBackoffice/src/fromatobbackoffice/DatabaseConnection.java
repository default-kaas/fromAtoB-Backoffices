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
        
        String sql = "SELECT long_name FROM stations";
        prepareStatement = connection.prepareStatement(sql);
        resultSet = prepareStatement.executeQuery();
        
        ArrayList<Station> stationNames = new ArrayList<>();
        
        while (resultSet.next()) {
            Station s = new Station();
            String sN = resultSet.getString("long_name");
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
    
    public ArrayList getLocker(String select){
    try{
        databaseConnection();
        
    //    int stationID = stationSelect.getInt().trim();
        
        String sql = "SELECT * FROM lockers WHERE station_id IN (SELECT id FROM statioons WHERE long_name = ? ";
        // select * from lockers where station_id IN (select id from stations where long_name = 'Alkmaar');
        
        prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, select);
        ResultSet resultSet = prepareStatement.executeQuery();
        
        ArrayList<Locker> lockers = new ArrayList<>();
        
        while (resultSet.next()) {
            Locker l = new Locker();
            
            int lId = resultSet.getInt("id");
            l.setId(lId);
            int sID = resultSet.getInt("station_id");
            l.setStationID(sID);
            int lN = resultSet.getInt("locker_number");
            l.setLocker_number(lN);
            int lC = resultSet.getInt("locker_code");
            l.setLocker_code(lC);
            int o = resultSet.getInt("occupied");
            l.setOccupied(o);
            
            lockers.add(l);
        }
        
        return lockers;
        
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
