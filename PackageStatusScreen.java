package fromatob_backoffice;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;// Text area is een veld waar tekst in kan staan
import javax.swing.JTextField;// Text is een klom waar alle tekst in kan staan. Als je de waards wilt gebruiken zoals int, double etc. moet je deze eerst converte.

public class PackageStatusScreen extends JDialog implements ActionListener {

    private JLabel mailAdresInvullen;
    private JTextField mailAdresKlant;
    private JButton statusBekijken, closeB;
    

    public PackageStatusScreen(JFrame frame) {
        super(frame,true);
        
        setTitle("Pakket status");
        setSize(500, 500);
        setLayout(new FlowLayout());

        mailAdresInvullen = new JLabel("E mail adres");
        add(mailAdresInvullen);
        mailAdresKlant = new JTextField(30);
        add(mailAdresKlant);
        statusBekijken = new JButton("Check Status");
        add(statusBekijken);
        
        closeB = new JButton("Afsluiten");
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
