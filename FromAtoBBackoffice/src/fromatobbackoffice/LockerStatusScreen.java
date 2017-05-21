package fromatobbackoffice;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import net.proteanit.sql.DbUtils;

public class LockerStatusScreen extends javax.swing.JFrame {

    private JButton backToStartScreen;
    private JButton backToStationLockerScreen;
    private JTextField code;
    private JButton codeButton;
    private JLabel codeLabel;
    private JLabel idLabel;
    private JComboBox<Locker> idSelect;
    private JLabel jLabel4;
    private JScrollPane scroll;
    private JLabel statusLabel;
    private JComboBox<String> statusSelect;
    private JTable table;
    private JLabel titel;
    
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
    
    public LockerStatusScreen() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        titel = new JLabel();
        idLabel = new JLabel();
        codeLabel = new JLabel();
        jLabel4 = new JLabel();
        idSelect = new JComboBox<>();
        code = new JTextField();
        codeButton = new JButton();
        statusSelect = new JComboBox<>();
        backToStationLockerScreen = new JButton();
        backToStartScreen = new JButton();
        scroll = new JScrollPane();
        table = new JTable();
        statusLabel = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        titel.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        titel.setText("Kluis status of code veranderen");

        idLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        idLabel.setText("Kluis ID selecteren:");

        codeLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        codeLabel.setText("Kluis code instellen:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        idSelect.setEditable(true);
        idSelect.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        DatabaseConnection conn = new DatabaseConnection();
        idSelect.setModel(new LockerComboBoxModel(conn.getLockerID()));
        idSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idSelectActionPerformed(evt);
            }
        });

        code.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeActionPerformed(evt);
            }
        });

        codeButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        codeButton.setText("Kluis code toepassen");
        codeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeButtonActionPerformed(evt);
            }
        });

        statusSelect.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        statusSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "true", "false" }));
        statusSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusSelectActionPerformed(evt);
            }
        });

        backToStationLockerScreen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backToStationLockerScreen.setText("Terug naar station kluis status");
        backToStationLockerScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToStationLockerScreenActionPerformed(evt);
            }
        });

        backToStartScreen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backToStartScreen.setText("Terug naar startscherm");
        backToStartScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToStartScreenActionPerformed(evt);
            }
        });

        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "name", "locker_id", "locker_code", "occupied"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scroll.setViewportView(table);

        statusLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        statusLabel.setText("Kluis status instellen:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(titel)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(idSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(150, 150, 150)
                            .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(backToStartScreen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backToStationLockerScreen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(codeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(code, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codeButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel4))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(statusSelect, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(statusLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titel)
                        .addGap(18, 18, 18)
                        .addComponent(idLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5))
                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(codeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(codeButton)
                .addGap(18, 18, 18)
                .addComponent(statusLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(backToStationLockerScreen)
                .addGap(18, 18, 18)
                .addComponent(backToStartScreen)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void statusSelectActionPerformed(java.awt.event.ActionEvent evt) {                                             
        fetchLockersOnIDAndChangeOccupied();
    }                                            

    private void codeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        fetchLockersOnIDAndRestLockerCode();
    }                                          

    private void idSelectActionPerformed(java.awt.event.ActionEvent evt) {                                         
        fetchLockersOnID();
    }                                        

    private void backToStationLockerScreenActionPerformed(java.awt.event.ActionEvent evt) {                                                          
        StationLockerStatusScreen slss = new StationLockerStatusScreen();
        slss.setVisible(true);
        dispose();
    }                                                         

    private void backToStartScreenActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        StartScreen ss = new StartScreen();
        ss.setVisible(true);
        dispose();
    }                                                 

    private void codeActionPerformed(java.awt.event.ActionEvent evt) {                                     
        fetchLockersOnIDAndChangeLockerCode();
    }           

    private void fetchLockersOnID() {
        try {
        databaseConnection();
            String select = idSelect.getSelectedItem().toString();

            String sql = "SELECT l.id, s.name, locker_number, locker_code, occupied FROM stations s JOIN lockers l  ON  s.id = l.station_id WHERE l.id = ?";
            pstmt  = connection.prepareStatement(sql);
            pstmt.setString(1, select);
            resultSet = pstmt.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
       
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void fetchLockersOnIDAndChangeOccupied() {
        try {
            String select = idSelect.getSelectedItem().toString();
            
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
                
            String sql = "SELECT l.id, s.name, locker_number, locker_code, occupied FROM stations s JOIN lockers l  ON  s.id = l.station_id WHERE l.id = ?";
            pstmt  = connection.prepareStatement(sql);
            pstmt.setString(1, select);
            resultSet = pstmt.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
            
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void fetchLockersOnIDAndChangeLockerCode() {
        try {
            String select = idSelect.getSelectedItem().toString();
            
            databaseConnection();
            String codeInsert = code.getText().toString();

            String sqlf = "UPDATE lockers SET locker_code = ?  WHERE id = ?";
            pstmt  = connection.prepareStatement(sqlf);
            pstmt.setString(1, codeInsert);
            pstmt.setString(2, select);
            pstmt.executeUpdate();
                
            String sql = "SELECT l.id, s.name, locker_number, locker_code, occupied FROM stations s JOIN lockers l  ON  s.id = l.station_id WHERE l.id = ?";
            pstmt  = connection.prepareStatement(sql);
            pstmt.setString(1, select);
            resultSet = pstmt.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
            
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void fetchLockersOnIDAndRestLockerCode() {
        try {
            String select = idSelect.getSelectedItem().toString();
            
            databaseConnection();
            
            String sqlf = "UPDATE lockers SET locker_code = null  WHERE id = ?";
            pstmt  = connection.prepareStatement(sqlf);
            pstmt.setString(1, select);
            pstmt.executeUpdate();
                
            String sql = "SELECT l.id, s.name, locker_number, locker_code, occupied FROM stations s JOIN lockers l  ON  s.id = l.station_id WHERE l.id = ?";
            pstmt  = connection.prepareStatement(sql);
            pstmt.setString(1, select);
            resultSet = pstmt.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
            
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LockerStatusScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LockerStatusScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LockerStatusScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LockerStatusScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LockerStatusScreen().setVisible(true);
            }
        });
    }

             
}
