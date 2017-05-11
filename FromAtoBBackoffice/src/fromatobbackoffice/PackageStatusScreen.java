package fromatobbackoffice;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PackageStatusScreen extends JDialog implements ActionListener {

    private JLabel mailAdresInvullen = new JLabel("E mail adres");
    private JTextField mailAdresKlant = new JTextField(30);
    private JButton statusBekijken = new JButton("Check Status"), closeB = new JButton("Afsluiten");
    

    public PackageStatusScreen(JFrame frame) {
        super(frame,true);
        
        setTitle("Pakket status");
        setSize(500, 500);
        setLayout(new FlowLayout());

        
        add(mailAdresInvullen);
        add(mailAdresKlant);
        add(statusBekijken);
        
        add(closeB);

        statusBekijken.addActionListener(this);
        closeB.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == statusBekijken) {

        }else if(e.getSource() == closeB){
            setVisible(false);
        }
    }
    
}
