package fromatob_backoffice;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;// Text area is een veld waar tekst in kan staan
import javax.swing.JTextField;// Text is een klom waar alle tekst in kan staan. Als je de waards wilt gebruiken zoals int, double etc. moet je deze eerst converte.

public class StartScreen extends JFrame implements ActionListener {

    private JLabel jlNaam;
    private JButton packageStatusB, lockerStatusB, closeB;
    private JLabel packageStatusL, lockerStatusL;
    private JTextArea jtafVeld;

    public StartScreen() {

        setTitle("Backoffice applicatie");
        setSize(500, 500);
        setLayout(new FlowLayout());
        
        packageStatusL = new JLabel("Status van pakket controleren");
        add(packageStatusL);
        packageStatusB = new JButton("Klik");
        add(packageStatusB);
        
        lockerStatusL = new JLabel("Kluisjes status controleren");
        add(lockerStatusL);
        lockerStatusB = new JButton("Klik");
        add(lockerStatusB);
        
        closeB = new JButton("Afsluiten");
        add(closeB);
        
        packageStatusB.addActionListener(this);
        lockerStatusB.addActionListener(this);
        closeB.addActionListener(this);
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == packageStatusB) {
            PackageStatusScreen pss = new PackageStatusScreen(this);
            
        }else if(e.getSource() == lockerStatusB){
            LockerStatusScreen lss = new LockerStatusScreen(this);
        }else if(e.getSource() == closeB){
            setVisible(false);
        }
    }
}