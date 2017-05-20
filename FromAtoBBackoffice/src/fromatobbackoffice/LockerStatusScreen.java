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

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement pstmt;
    private Station station;
    private Locker locker;
    
    private JTable Table;
    private JButton backToStartScreen;
    private JScrollPane jScrollPane1;
    private JLabel stationLabel;
    private JComboBox<Station> stationSelect;
    private JButton statusCheck;
    private JLabel titel;
    
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

        titel = new javax.swing.JLabel();
        stationSelect = new javax.swing.JComboBox<>();
        backToStartScreen = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        stationLabel = new javax.swing.JLabel();
        statusCheck = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(900, 800));

        titel.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        titel.setText("Kluis status");

        stationSelect.setEditable(true);
        
        
        DatabaseConnection conn = new DatabaseConnection();
        stationSelect.setModel(new StationComboBoxModel(conn.getStationNames()));
        
        stationSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stationSelectActionPerformed(evt);
            }
        });

        backToStartScreen.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        backToStartScreen.setText("Terug naar startscherm");
        backToStartScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToStartScreenActionPerformed(evt);
            }
        });

        Table.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "id", "name", "locker_number", "locker_code", "occupied"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(Table);

        stationLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        stationLabel.setText("Station selecteren :");

        statusCheck.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        statusCheck.setText("Kluis status of code veranderen ");
        statusCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusCheckActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(backToStartScreen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(stationSelect, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(stationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(statusCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(70, 70, 70)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(titel)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(titel)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(stationLabel)
                        .addGap(18, 18, 18)
                        .addComponent(stationSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(statusCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backToStartScreen))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(86, 86, 86))
        );

        pack();
    }// </editor-fold>                        

    private void stationSelectActionPerformed(java.awt.event.ActionEvent evt) {                                              
        fetch();
    }                                             
    
    private void backToStartScreenActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        StartScreen ss = new StartScreen();
        ss.setVisible(true);
        dispose();
    }                                                 

    private void statusCheckActionPerformed(java.awt.event.ActionEvent evt) {                                            
        
        
    }     
    
    private void fetch() {
        try {
            databaseConnection();
            String select = stationSelect.getSelectedItem().toString();

            String sql = "SELECT l.id, s.name, locker_number, locker_code, occupied FROM lockers l JOIN stations s ON l.station_id = s.id WHERE name = ?"; 
            pstmt  = connection.prepareStatement(sql);
            pstmt.setString(1, select);
            resultSet = pstmt.executeQuery();
            Table.setModel(DbUtils.resultSetToTableModel(resultSet));
       
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e);
        }
    }

    
    public static void main(String args[]) {
        
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
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LockerStatusScreen().setVisible(true);
            }
        });
    }

                        
    
                     
}
