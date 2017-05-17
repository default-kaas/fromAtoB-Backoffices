
package fromatobbackoffice;

import javax.swing.*;
import java.awt.*;

public class LockerStatusScreen extends javax.swing.JFrame {
    
    private JButton backToStartScreen;
    private JLabel stationLabel;
    private JComboBox<Station> stationSelect;
    private JButton statusCheck;
    private JLabel titel;
    private Station station;
    
    public LockerStatusScreen() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
                             
    private void initComponents() {

        titel = new JLabel();
        stationSelect = new JComboBox<>();
        statusCheck = new JButton();
        stationLabel = new JLabel();
        backToStartScreen = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        titel.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        titel.setText("Kluis status ");
        titel.setPreferredSize(new Dimension(500, 500));

        stationSelect.setFont(new Font("Tahoma", 1, 11)); // NOI18N
        
        DatabaseConnection conn = new DatabaseConnection();
        stationSelect.setModel(new StationComboBoxModel(conn.getStationNames()));
        
        
        stationSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stationSelectActionPerformed(evt);
            }
        });

        statusCheck.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        statusCheck.setText("Kluis status zien");
        statusCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusCheckActionPerformed(evt);
            }
        });

        stationLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        stationLabel.setText("Station");

        backToStartScreen.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        backToStartScreen.setText("Terug naar start scherm");
        backToStartScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToStartScreenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(titel, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(stationLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(statusCheck))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backToStartScreen)
                            .addComponent(stationSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(titel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(stationLabel)
                .addGap(18, 18, 18)
                .addComponent(stationSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(statusCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addComponent(backToStartScreen)
                .addGap(119, 119, 119))
        );

        pack();
    }// </editor-fold>                        

    private void stationSelectActionPerformed(java.awt.event.ActionEvent evt) {                                              
        
    }                                             

    private void statusCheckActionPerformed(java.awt.event.ActionEvent evt) {                                            
        String select = stationSelect.getSelectedItem().toString();
        System.out.println(select);
        getLocker(select);
        
    }                                           

    private void backToStartScreenActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        StartScreen ss = new StartScreen();
        ss.setVisible(true);
        dispose();
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