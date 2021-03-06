/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fromatobbackoffice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class PackageStatusScreen extends javax.swing.JFrame {

    
    private javax.swing.JButton jButton2;
    private javax.swing.JTextField jTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    
    private static final String USERNAME = "wnk012";
    private static final String PASSWORD = "wnk012";
    private static final String CONN_STRING = "jdbc:mysql://jestii.nl:3306/wnk012";
    private Connection conn;

    public PackageStatusScreen() {
        initComponents();
        fillTable(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToStartScreenActionPerformed(evt);
            }
        });

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoekActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String[]{
                    "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Pakketoverzicht");
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("Zoek op pakket, klant, koerier, station of status: ");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null}
                },
                new String[]{
                    "Pakketnummer", "Klant", "Koerier", "Beginstation", "Eindstation", "Status"
                }
        ));
        jScrollPane1.setViewportView(jTable2);

        jButton2.setText("Terug naar startscreen");
        jButton3.setText("Zoek");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButton3)
                                                .addComponent(jButton2))))
                        .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addContainerGap(130, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("Succes");
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }

    public void fillTable(String input) {
        connect();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        jTable2.setModel(model);
        try {
            ResultSet rs;
            ResultSet rs2;

            if (input != null && !input.isEmpty()) {
                try {
                    Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Vul alsjeblieft een nummer in");
                    fillTable(null);
                    return;
                }
                String sql = "SELECT p.id, owner_id,  p.start_station, p.end_station, p.status, pc.courier_id FROM packages p LEFT JOIN package_courses pc ON p.id = pc.package_id WHERE p.id = ? OR p.owner_id = ? OR p.start_station = ? OR p.end_station = ? OR p.status = ? OR pc.courier_id = ?";
                //SQL query, er wordt gezocht binnen elk mogelijke attribuut of deze (deels) overeenkomst met de zoekterm
                PreparedStatement pstmt = conn.prepareStatement(sql);
                PreparedStatement pstmt2 = conn.prepareStatement(sql);
                //Prepared statements tegen SQL injecties
                int newInt = Integer.parseInt(input);
                pstmt.setInt(1, newInt);
                pstmt.setInt(2, newInt);
                pstmt.setInt(3, newInt);
                pstmt.setInt(4, newInt);
                pstmt.setInt(5, newInt);
                pstmt.setInt(6, newInt);
                pstmt2.setInt(1, newInt);
                pstmt2.setInt(2, newInt);
                pstmt2.setInt(3, newInt);
                pstmt2.setInt(4, newInt);
                pstmt2.setInt(5, newInt);
                pstmt2.setInt(6, newInt);
                rs = pstmt.executeQuery();
                rs2 = pstmt2.executeQuery();
            } else {
                Statement stmt = conn.createStatement();
                Statement stmt2 = conn.createStatement();
                //Normaal statement: hier is niks ingevuld, dus hoeft er geen Prepared statement gebruikt te worden, omdat er geen risico is op SQL injecties
                rs = stmt.executeQuery("SELECT id, owner_id,  start_station, end_station, status FROM packages");
                rs2 = stmt2.executeQuery("SELECT id, owner_id,  start_station, end_station, status FROM packages");
            }
            int row = 0;
            model = (DefaultTableModel) jTable2.getModel();

            int rowCount = 0;
            while (rs2.next()) {
                rowCount++;
            }
            model.setRowCount(rowCount);
            jTable2.setModel(model);

            while (rs.next()) {
                int id = rs.getInt("id"); 	         // 1e kolom
                int owner_id = rs.getInt("owner_id");  // 2e kolom
                int courier_id = rs.getInt(5); // 3e kolom
                String start_station = rs.getString("start_station"); 	   // 4e kolom
                String end_station = rs.getString("end_station"); // 5e kolom
                String status = rs.getString("status"); // 6e kolom
                jTable2.getModel().setValueAt(id, row, 0);
                jTable2.getModel().setValueAt(owner_id, row, 1);
                jTable2.getModel().setValueAt(courier_id, row, 2);
                jTable2.getModel().setValueAt(start_station, row, 3);
                jTable2.getModel().setValueAt(end_station, row, 4);
                jTable2.getModel().setValueAt(status, row, 5);
                row++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(PackageStatusScreen.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Something went wrong with executing the query");
        }
    }

    private void backToStartScreenActionPerformed(java.awt.event.ActionEvent evt) {
        StartScreen ss = new StartScreen();
        ss.setVisible(true);
        dispose();
    }

    private void zoekActionPerformed(java.awt.event.ActionEvent evt) {
        String input = jTextField.getText();
        fillTable(input);
    }      
}
