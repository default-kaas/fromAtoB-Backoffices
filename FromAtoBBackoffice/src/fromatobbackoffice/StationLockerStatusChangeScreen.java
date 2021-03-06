package fromatobbackoffice;

import javax.swing.*;
import java.awt.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.proteanit.sql.DbUtils;

public class StationLockerStatusChangeScreen extends javax.swing.JFrame {

    private JTextField code;
    private JLabel codeLabel;
    private JButton codeRestButton;
    private JLabel idLabel;
    private JTextField idSelect;
    private JButton backToStartScreenAction;
    private JScrollPane scroll;
    private JLabel stationLabel;
    private JComboBox<Station> stationSelect;
    private JLabel statusLabel;
    private JComboBox<String> statusSelect;
    private JTable table;
    private JLabel titel;
    
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement pstmt;
    
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
    
    public StationLockerStatusChangeScreen() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")                         
    private void initComponents() {

        titel = new JLabel();
        stationLabel = new JLabel();
        stationSelect = new JComboBox<>();
        idLabel = new JLabel();
        idSelect = new JTextField();
        codeLabel = new JLabel();
        code = new JTextField();
        codeRestButton = new JButton();
        statusLabel = new JLabel();
        statusSelect = new JComboBox<>();
        backToStartScreenAction = new JButton();
        scroll = new JScrollPane();
        table = new JTable();
        DatabaseConnection conn = new DatabaseConnection();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        titel.setFont(new Font("Tahoma", 1, 48)); 
        titel.setText("Stationskluis status wijzigingsscherm");

        stationLabel.setFont(new Font("Tahoma", 1, 12)); 
        stationLabel.setText("Station selecteren:");

        stationSelect.setEditable(false);
        stationSelect.setFont(new Font("Tahoma", 0, 12)); 
        stationSelect.setModel(new StationComboBoxModel(conn.getStationNames()));
        stationSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stationSelectActionPerformed(evt);
            }
        });

        idLabel.setFont(new Font("Tahoma", 1, 12)); 
        idLabel.setText("KluisID invoeren:");

        //idSelect.setEditable(false);
        //idSelect.setModel(new LockerComboBoxModel(conn.getLockerID()));
        idSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idSelectActionPerformed(evt);
            }
        });

        codeLabel.setFont(new Font("Tahoma", 1, 12)); 
        codeLabel.setText("Kluiscode instellen:");

        code.setFont(new Font("Tahoma", 0, 12)); 
        code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeActionPerformed(evt);
            }
        });

        codeRestButton.setFont(new Font("Tahoma", 1, 12)); 
        codeRestButton.setText("Reset kluiscode");
        codeRestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeRestButtonActionPerformed(evt);
            }
        });

        statusLabel.setFont(new Font("Tahoma", 1, 12)); 
        statusLabel.setText("Kluisstatus instellen:");

        statusSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "true", "false" }));
        statusSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusSelectActionPerformed(evt);
            }
        });

        backToStartScreenAction.setFont(new Font("Tahoma", 1, 12)); 
        backToStartScreenAction.setText("Terug naar startscherm");
        backToStartScreenAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToStartScreenActionActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "id", "name", "locker_number", "occupied"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scroll.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(titel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(stationLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(stationSelect, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idSelect, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(codeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(code, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codeRestButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(statusLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(statusSelect, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(backToStartScreenAction, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(129, 129, 129)
                        .addComponent(scroll)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(titel)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(stationLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stationSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(idLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(codeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codeRestButton)
                        .addGap(18, 18, 18)
                        .addComponent(statusLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statusSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backToStartScreenAction)
                        .addGap(50, 50, 50))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(40, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>                        

    private void stationSelectActionPerformed(java.awt.event.ActionEvent evt) {                                              
        fetchStationLockersOnName();
    }                                             

    private void idSelectActionPerformed(java.awt.event.ActionEvent evt) {                                         
        fetchLockersOnID();
    }                                        

    private void codeActionPerformed(java.awt.event.ActionEvent evt) {                                     
        fetchLockersOnIDAndChangeLockerCode();
    }                                    

    private void codeRestButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        fetchLockersOnIDAndRestLockerCode();
    }                                              

    private void statusSelectActionPerformed(java.awt.event.ActionEvent evt) {                                             
        fetchLockersOnIDAndChangeOccupied();
    }                                            

    private void backToStartScreenActionActionPerformed(java.awt.event.ActionEvent evt) {                                         
        StartScreen ss = new StartScreen();
        ss.setVisible(true);
        dispose();
    }                                        

    private void fetchStationLockersOnName() {       
        try {
        databaseConnection();
        String select = stationSelect.getSelectedItem().toString();

        String sql = "SELECT l.id, s.name, locker_number, occupied FROM lockers l JOIN stations s ON l.station_id = s.id WHERE name = ?"; 
        pstmt  = connection.prepareStatement(sql);
        pstmt.setString(1, select);
        resultSet = pstmt.executeQuery();
        table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }      
    }
    
    private void fetchLockersOnID() {
        try {
        databaseConnection();
        String select = idSelect.getText().toString();

        String sql = "SELECT l.id, s.name, locker_number, occupied FROM stations s JOIN lockers l  ON  s.id = l.station_id WHERE l.id = ?";
        pstmt  = connection.prepareStatement(sql);
        pstmt.setString(1, select);
        resultSet = pstmt.executeQuery();
        table.setModel(DbUtils.resultSetToTableModel(resultSet));
       
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void fetchLockersOnIDAndChangeOccupied() {
        if ("".equals(idSelect.getText())){
            JOptionPane.showMessageDialog(null, "Er moet een kluis id zijn ingevuld.");
        }else{
            try {
                String select = idSelect.getText().toString();
                databaseConnection();
                String selectStatus = statusSelect.getSelectedItem().toString();
                    if(selectStatus == "false"){
                        String sqlf = "UPDATE lockers SET occupied = 0  WHERE id = ?";
                        pstmt  = connection.prepareStatement(sqlf);
                        pstmt.setString(1, select);
                        pstmt.executeUpdate();
                    }else{
                        String sqlf = "UPDATE lockers SET occupied = 1  WHERE id = ?";
                        pstmt  = connection.prepareStatement(sqlf);
                        pstmt.setString(1, select);
                        pstmt.executeUpdate();
                    }   
                String sql = "SELECT l.id, s.name, locker_number, occupied FROM stations s JOIN lockers l  ON  s.id = l.station_id WHERE l.id = ?";
                pstmt  = connection.prepareStatement(sql);
                pstmt.setString(1, select);
                resultSet = pstmt.executeQuery();
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
    private void fetchLockersOnIDAndChangeLockerCode() {
        if ("".equals(idSelect.getText())){
            JOptionPane.showMessageDialog(null, "Er moet een kluis id zijn ingevuld.");
        }else{
            Pattern pc = Pattern.compile("^[0-9]{6}$");
            Matcher mc = pc.matcher(code.getText().toString());
            boolean bc = mc.matches();
            if(bc == false){
                JOptionPane.showMessageDialog(null, "Een code bestaat alleen uit 6 cijfers.");
            }else{
                try {
                    String select = idSelect.getText().toString();
            
                    databaseConnection();
                    String codeInsert = code.getText().toString();
                    System.out.println(codeInsert);
                    
                    String sqlf = "UPDATE lockers SET locker_code = ?  WHERE id = ?";
                    pstmt  = connection.prepareStatement(sqlf);
                    pstmt.setString(1, codeInsert);
                    pstmt.setString(2, select);
                    pstmt.executeUpdate();
                
                    String sql = "SELECT l.id, s.name, locker_number, occupied FROM stations s JOIN lockers l  ON  s.id = l.station_id WHERE l.id = ?";
                    pstmt  = connection.prepareStatement(sql);
                    pstmt.setString(1, select);
                    resultSet = pstmt.executeQuery();
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                    JOptionPane.showMessageDialog(null, "De code is succevol toegepast.");
                } catch (Exception e) {
                // JOptionPane.showMessageDialog(null, e);
                // System.out.println(e);
                }
            }
        }
    }
    
    private void fetchLockersOnIDAndRestLockerCode() {
        if ("".equals(idSelect.getText())){
            JOptionPane.showMessageDialog(null, "Er moet een kluis id zijn ingevuld.");
        }else{
            try {
                String select = idSelect.getText().toString();
            
                databaseConnection();
            
                String sqlf = "UPDATE lockers SET locker_code = null  WHERE id = ?";
                pstmt  = connection.prepareStatement(sqlf);
                pstmt.setString(1, select);
                pstmt.executeUpdate();
                
                String sql = "SELECT l.id, s.name, locker_number, occupied FROM stations s JOIN lockers l  ON  s.id = l.station_id WHERE l.id = ?";
                pstmt  = connection.prepareStatement(sql);
                pstmt.setString(1, select);
                resultSet = pstmt.executeQuery();
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            
                JOptionPane.showMessageDialog(null, "De code is succevol gereset");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }                      
}
