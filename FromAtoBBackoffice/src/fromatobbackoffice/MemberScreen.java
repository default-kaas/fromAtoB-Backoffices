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
    boolean hoogNaarLaag = true; //voor filteren

    public MemberScreen() {
        initComponents();
        connect();
        fetch();

    }

    //method for databaseconnection
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

    //fetch data of all members out of database
    public void fetch() {
        try {
            stmt = conn.createStatement();
                String sql = "SELECT userID, e-mail, first_name, last_name, points, iban, phone number, city, postal_code, house_number FROM users";
            rs = stmt.executeQuery(sql);
            //create table
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //fetch memberdata on ID
    public void fetchID() {
        if ("".equals(jTFID.getText())) {
            JOptionPane.showMessageDialog(null, "Vul id in");
        } else {
            try {
                try {
                    int id = Integer.parseInt(jTFID.getText());
                String sql = "SELECT userID, e-mail, first_name, last_name, points, iban, phone number, city, postal_code, house_number FROM users WHERE userID = ?";
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setInt(1, id);
                    rs = pstmt.executeQuery();
                    //create table
                    jTable1.setModel(DbUtils.resultSetToTableModel(rs));
                    jTFID.setText("");

                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Vul een getal in");
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    //fetch memberdata on email
    public void fetchEmail() {
        if ("".equals(jTFEmail.getText())) {
            JOptionPane.showMessageDialog(null, "Vul e-mail in");
        } else {
            try {
                String email = jTFEmail.getText();
                String sql = "SELECT userID, e-mail, first_name, last_name, points, iban, phone number, city, postal_code, house_number FROM users WHERE e-mail = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, email);
                rs = pstmt.executeQuery();
                //create table
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
                jTFEmail.setText("");

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    //fetch memberdata on city
    public void fetchStad() {
        if ("".equals(jTFStad.getText())) {
            JOptionPane.showMessageDialog(null, "Vul woonplaats in");
        } else {
            try {
                String stad = jTFStad.getText();
                String sql = "SELECT userID, e-mail, first_name, last_name, points, iban, phone number, city, postal_code, house_number FROM users WHERE city = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, stad);
                rs = pstmt.executeQuery();
                //create table
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
                jTFStad.setText("");

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    //fetch memberdata on firstname
    public void fetchFirstname() {
        if ("".equals(jTFvoornaam.getText())) {
            JOptionPane.showMessageDialog(null, "Vul voornaam in");
        } else {
            try {
                String voornaam = "%" + jTFvoornaam.getText() + "%";
                String sql = "SELECT userID, e-mail, first_name, last_name, points, iban, phone number, city, postal_code, house_number FROM users WHERE first_name LIKE ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, voornaam);
                rs = pstmt.executeQuery();
                //create table
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
                jTFvoornaam.setText("");

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    //fetch memberdata on lastname
    public void fetchLastname() {
        if ("".equals(jTFachternaam.getText())) {
            JOptionPane.showMessageDialog(null, "Vul achternaam in");
        } else {
            try {
                String achternaam = "%" + jTFachternaam.getText() + "%";
                String sql = "SELECT userID, e-mail, first_name, last_name, points, iban, phone number, city, postal_code, house_number FROM users WHERE last_name LIKE ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, achternaam);
                rs = pstmt.executeQuery();
                //create table
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
                jTFachternaam.setText("");

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    //order members by points
    public void orderByPoints() {
        if (hoogNaarLaag) {
            try {
                String sql = "SELECT userID, e-mail, first_name, last_name, points, iban, phone number, city, postal_code, house_number FROM users ORDER BY points DESC";
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
                hoogNaarLaag = false;
                //create table ordered by points from most to least
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            try {
                String sql = "SELECT userID, e-mail, first_name, last_name, points, iban, phone number, city, postal_code, house_number FROM users ORDER BY points ASC";
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
                hoogNaarLaag = true;
                //create table ordered by points from least to most
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    // order members by amount of sent packages
    public void orderBySentPackages() {
        if (hoogNaarLaag) {
            try {
                stmt = conn.createStatement();
                String sql = "SELECT DISTINCT userID, e-mail, first_name, last_name, COUNT(*) 'Verstuurde pakketten', points FROM users JOIN packages ON userID = customerID GROUP BY userID ORDER BY COUNT(*) DESC";
                rs = stmt.executeQuery(sql);
                hoogNaarLaag = false;
                //create table ordered by sent packages from most to least
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, e);
            }
        } else {
            try {
                stmt = conn.createStatement();
                String sql = "SELECT DISTINCT userID, e-mail, first_name, last_name, COUNT(*) 'Verstuurde pakketten', points FROM users JOIN packages ON userID = customerID GROUP BY userID ORDER BY COUNT(*)";
                rs = stmt.executeQuery(sql);
                hoogNaarLaag = true;
                //create table ordered by sent packages from least to most
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    //order members by amount of delivered packages
    public void orderByDeliveredPackages() {
        if (hoogNaarLaag) {
            try {
                stmt = conn.createStatement();
                String sql = "SELECT DISTINCT userID, e-mail, first_name, last_name, COUNT(*) 'Bezorgde pakketten', points FROM users JOIN partial routes ON userID = courierID GROUP BY userID ORDER BY COUNT(*) DESC";
                rs = stmt.executeQuery(sql);
                hoogNaarLaag = false;
                //create table ordered by delivered packages from most to least
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, e);
            }

        } else {
            try {
                stmt = conn.createStatement();
                String sql = "SELECT DISTINCT userID, e-mail, first_name, last_name, COUNT(*) 'Bezorgde pakketten', points FROM users JOIN partial routes ON userID = courierID GROUP BY userID ORDER BY COUNT(*)";
                rs = stmt.executeQuery(sql);
                hoogNaarLaag = true;
                //create table ordered by delivered packages from least to most
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, e);
            }
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
        jBorderPoints = new javax.swing.JButton();
        jBorderSent = new javax.swing.JButton();
        jBorderDelivered = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jBstartscreen = new javax.swing.JButton();
        jLvoornaam = new javax.swing.JLabel();
        jLachternaam = new javax.swing.JLabel();
        jTFvoornaam = new javax.swing.JTextField();
        jTFachternaam = new javax.swing.JTextField();
        jBvoornaam = new javax.swing.JButton();
        jBachternaam = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Memberoverzicht");
        setPreferredSize(new java.awt.Dimension(2000, 2000));
        setSize(new java.awt.Dimension(2000, 2000));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
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

        jBEmail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBEmail.setText("Zoeken");
        jBEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEmailActionPerformed(evt);
            }
        });

        jLStad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLStad.setText("Woonplaats");

        jTFStad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

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

        jBorderPoints.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBorderPoints.setText("Aantal punten");
        jBorderPoints.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBorderPointsActionPerformed(evt);
            }
        });

        jBorderSent.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBorderSent.setText("Verstuurde paketten");
        jBorderSent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBorderSentActionPerformed(evt);
            }
        });

        jBorderDelivered.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBorderDelivered.setText("Bezorgde pakketen");
        jBorderDelivered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBorderDeliveredActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Sorteer op:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Zoeken op:");

        jBstartscreen.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBstartscreen.setText("Terug naar Startscherm");
        jBstartscreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBstartscreenActionPerformed(evt);
            }
        });

        jLvoornaam.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLvoornaam.setText("Voornaam");

        jLachternaam.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLachternaam.setText("Achternaam");

        jTFvoornaam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTFachternaam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jBvoornaam.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBvoornaam.setText("Zoeken");
        jBvoornaam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBvoornaamActionPerformed(evt);
            }
        });

        jBachternaam.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBachternaam.setText("Zoeken");
        jBachternaam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBachternaamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBstartscreen)
                    .addComponent(JButtonAllMembers))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jBID, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLID)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTFID)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLEmail)
                                    .addComponent(jBEmail)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBvoornaam)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLvoornaam)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTFvoornaam, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLachternaam)
                                    .addComponent(jBachternaam))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLStad)
                                    .addComponent(jBStad))
                                .addGap(18, 18, 18)
                                .addComponent(jTFStad, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTFachternaam, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBorderSent)
                    .addComponent(jLabel1)
                    .addComponent(jBorderPoints)
                    .addComponent(jBorderDelivered))
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(JButtonAllMembers)
                        .addGap(104, 104, 104))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLID)
                                    .addComponent(jTFID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLEmail)
                                    .addComponent(jTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLStad)
                                    .addComponent(jTFStad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBorderPoints))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jBEmail)
                                        .addComponent(jBID))
                                    .addComponent(jBorderSent)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jBStad)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBstartscreen)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 7, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLvoornaam)
                                            .addComponent(jTFvoornaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLachternaam)
                                            .addComponent(jTFachternaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jBachternaam)
                                    .addComponent(jBvoornaam))
                                .addGap(11, 11, 11))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jBorderDelivered)
                                .addContainerGap())))))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setText("Member Overzicht");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1730, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(491, 491, 491)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addGap(31, 31, 31)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(362, Short.MAX_VALUE))
        );

        setBounds(0, 0, 1766, 1039);
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

    private void jBorderPointsActionPerformed(java.awt.event.ActionEvent evt) {                                              
        orderByPoints();
    }                                             

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     

    }                                    

    private void jBorderSentActionPerformed(java.awt.event.ActionEvent evt) {                                            
        orderBySentPackages();
    }                                           

    private void jBorderDeliveredActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        orderByDeliveredPackages();
    }                                                

    private void jBstartscreenActionPerformed(java.awt.event.ActionEvent evt) {                                              

        StartScreen s = new StartScreen();
        s.setVisible(true);
        dispose();
    }                                             

    private void jBvoornaamActionPerformed(java.awt.event.ActionEvent evt) {                                           
        fetchFirstname();
    }                                          

    private void jBachternaamActionPerformed(java.awt.event.ActionEvent evt) {                                             
        fetchLastname();
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
    private javax.swing.JButton jBachternaam;
    private javax.swing.JButton jBorderDelivered;
    private javax.swing.JButton jBorderPoints;
    private javax.swing.JButton jBorderSent;
    private javax.swing.JButton jBstartscreen;
    private javax.swing.JButton jBvoornaam;
    private javax.swing.JLabel jLEmail;
    private javax.swing.JLabel jLID;
    private javax.swing.JLabel jLStad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLachternaam;
    private javax.swing.JLabel jLvoornaam;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFEmail;
    private javax.swing.JTextField jTFID;
    private javax.swing.JTextField jTFStad;
    private javax.swing.JTextField jTFachternaam;
    private javax.swing.JTextField jTFvoornaam;
    private javax.swing.JTable jTable1;
    // End of variables declaration                   
}
