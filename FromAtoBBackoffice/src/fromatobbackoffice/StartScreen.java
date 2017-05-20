
package fromatobbackoffice;


public class StartScreen extends javax.swing.JFrame {

    
    public StartScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MemberListButton = new javax.swing.JButton();
        PackageListButton = new javax.swing.JButton();
        LockerStatusButton = new javax.swing.JButton();
        CloseButton = new javax.swing.JButton();
        Titel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 600));
        setResizable(false);

        MemberListButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        MemberListButton.setText("Leden lijst");
        MemberListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MemberListButtonActionPerformed(evt);
            }
        });

        PackageListButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        PackageListButton.setText("Pakket lijst van klant");
        PackageListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PackageListButtonActionPerformed(evt);
            }
        });

        LockerStatusButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LockerStatusButton.setText("Station kluis status");
        LockerStatusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LockerStatusButtonActionPerformed(evt);
            }
        });

        CloseButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CloseButton.setText("Afsluiten");
        CloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseButtonActionPerformed(evt);
            }
        });

        Titel.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        Titel.setText("A to B backoffice");
        Titel.setPreferredSize(new java.awt.Dimension(500, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(Titel, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
            .addGroup(layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CloseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LockerStatusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PackageListButton)
                    .addComponent(MemberListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(Titel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addComponent(MemberListButton)
                .addGap(18, 18, 18)
                .addComponent(PackageListButton)
                .addGap(18, 18, 18)
                .addComponent(LockerStatusButton)
                .addGap(106, 106, 106)
                .addComponent(CloseButton)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MemberListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MemberListButtonActionPerformed
        MemberScreen ms = new MemberScreen();
        ms.setVisible(true);
        dispose();
    }//GEN-LAST:event_MemberListButtonActionPerformed

    private void PackageListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PackageListButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PackageListButtonActionPerformed

    private void LockerStatusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LockerStatusButtonActionPerformed
        StationLockerStatusScreen slss = new StationLockerStatusScreen();
        slss.setVisible(true);
        dispose();
    }//GEN-LAST:event_LockerStatusButtonActionPerformed

    private void CloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_CloseButtonActionPerformed

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
            java.util.logging.Logger.getLogger(StartScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CloseButton;
    private javax.swing.JButton LockerStatusButton;
    private javax.swing.JButton MemberListButton;
    private javax.swing.JButton PackageListButton;
    private javax.swing.JLabel Titel;
    // End of variables declaration//GEN-END:variables
}
