/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fromatobbackoffice;

import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Milan
 */
public class MemberScreen extends javax.swing.JFrame {

    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    boolean hoogNaarLaag = true;

    public MemberScreen() {
        initComponents();
        connect();
        fetch();

    }

    public void connect() {
        // JDBC driver name and database URL
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://jestii.nl:3306/wnk012";

        //  Database credentials
        String USER = "wnk012";
        String PASS = "wnk012";

        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }

    public void fetch() {
        try {
            stmt = conn.createStatement();
            String sql = "SELECT u.id, email, COUNT(owner_id), points, iban, firstname, lastname, phonenumber, city, zip_code, housenumber, u.created_at FROM users u JOIN packages p ON u.id = owner_id GROUP BY u.id";
            rs = stmt.executeQuery(sql);

            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
       
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void fetchID() {
        try {
            try {
                int id = Integer.parseInt(jTFID.getText());
                String sql = "SELECT id, email, points, iban, firstname, lastname, phonenumber, city, zip_code, housenumber, created_at FROM users WHERE id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, id);
                rs = pstmt.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (NumberFormatException nfe) {
                int id = 0;
                JOptionPane.showMessageDialog(null, "Vul een getal in");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void fetchEmail() {
        try {
            String email = jTFEmail.getText();

            String sql = "SELECT id, email, points, iban, firstname, lastname, phonenumber, city, zip_code, housenumber, created_at FROM users WHERE email = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();

            jTable1.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void fetchStad() {
        try {
            String stad = jTFStad.getText();

            String sql = "SELECT id, email, points, iban, firstname, lastname, phonenumber, city, zip_code, housenumber, created_at FROM users WHERE city = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, stad);
            rs = pstmt.executeQuery();

            jTable1.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void filterPoints() {

        if (hoogNaarLaag) {
            try {
                String sql = "SELECT id, email, points, iban, firstname, lastname, phonenumber, city, zip_code, housenumber, created_at FROM users ORDER BY points DESC";
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
                hoogNaarLaag = false;
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            try {
                String sql = "SELECT id, email, points, iban, firstname, lastname, phonenumber, city, zip_code, housenumber, created_at FROM users ORDER BY points ASC";
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
                hoogNaarLaag = true;
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }
    
    public void filterSentPackages() {
                try {
            stmt = conn.createStatement();
            String sql = "SELECT DISTINCT u.id, email, firstname, lastname, COUNT(*) 'Verstuurde pakketten', points FROM users u JOIN packages p ON u.id = owner_id GROUP BY u.id ORDER BY COUNT(*) DESC";
            rs = stmt.executeQuery(sql);

            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e);
        }
    }

        public void filterDeliveredPackages() {
                try {
            stmt = conn.createStatement();
            String sql = "SELECT DISTINCT u.id, email, firstname, lastname, COUNT(*) 'Bezorgde pakketten', points FROM users u JOIN packages p ON u.id = deliver_id GROUP BY u.id ORDER BY COUNT(*) DESC";
            rs = stmt.executeQuery(sql);

            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLID = new javax.swing.JLabel();
        jTFID = new javax.swing.JTextField();
        jBID = new javax.swing.JButton();
        jLEmail = new javax.swing.JLabel();
        jTFEmail = new javax.swing.JTextField();
        jBEmail = new javax.swing.JButton();
        jLStad = new javax.swing.JLabel();
        jTFStad = new javax.swing.JTextField();
        jBStad = new javax.swing.JButton();
        JButtonAllMembers = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Memberoverzicht");
        setPreferredSize(new java.awt.Dimension(1366, 778));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Email", "Points", "Firstname", "Lastname"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLID.setText("ID");

        jTFID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTFID.setText("<ID>");

        jBID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBID.setText("Zoeken");
        jBID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIDActionPerformed(evt);
            }
        });

        jLEmail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLEmail.setText("E-mail");

        jTFEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTFEmail.setText("<e-mail>");

        jBEmail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBEmail.setText("Zoeken");
        jBEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEmailActionPerformed(evt);
            }
        });

        jLStad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLStad.setText("Stad");

        jTFStad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTFStad.setText("<stad>");

        jBStad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBStad.setText("Zoeken");
        jBStad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBStadActionPerformed(evt);
            }
        });

        JButtonAllMembers.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JButtonAllMembers.setText("Overzicht Alle Members");
        JButtonAllMembers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonAllMembersActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Aantal punten");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Verstuurde paketten");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Bezorgde pakketen");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Filter op:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Zoeken op:");

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Terug naar Startscherm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JButtonAllMembers)
                    .addComponent(jButton4))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLID)
                                .addGap(18, 18, 18)
                                .addComponent(jTFID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jBID))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLEmail)
                                .addGap(18, 18, 18)
                                .addComponent(jTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jBEmail))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLStad)
                                .addGap(18, 18, 18)
                                .addComponent(jTFStad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jBStad)))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLID)
                    .addComponent(jLEmail)
                    .addComponent(jTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLStad)
                    .addComponent(jTFStad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JButtonAllMembers))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBID)
                        .addComponent(jBEmail)
                        .addComponent(jButton4))
                    .addComponent(jBStad))
                .addGap(30, 30, 30))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(699, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(204, 204, 204))
        );

        setBounds(0, 0, 1766, 538);
    }// </editor-fold>                        

    private void JButtonAllMembersActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        fetch();
    }                                                 

    private void jBIDActionPerformed(java.awt.event.ActionEvent evt) {                                     
        fetchID();
    }                                    

    private void jBEmailActionPerformed(java.awt.event.ActionEvent evt) {                                        
        fetchEmail();
    }                                       

    private void jBStadActionPerformed(java.awt.event.ActionEvent evt) {                                       
        fetchStad();
    }                                      

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        filterPoints();
    }                                        

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
    }                                    

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        filterSentPackages();
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        filterDeliveredPackages();
    }                                        

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(MemberScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MemberScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MemberScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MemberScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MemberScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton JButtonAllMembers;
    private javax.swing.JButton jBEmail;
    private javax.swing.JButton jBID;
    private javax.swing.JButton jBStad;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLEmail;
    private javax.swing.JLabel jLID;
    private javax.swing.JLabel jLStad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFEmail;
    private javax.swing.JTextField jTFID;
    private javax.swing.JTextField jTFStad;
    private javax.swing.JTable jTable1;
    // End of variables declaration                   
}
