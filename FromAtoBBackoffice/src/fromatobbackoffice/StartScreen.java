package fromatobbackoffice;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class StartScreen extends JFrame implements ActionListener {

    private JButton packageStatusB = new JButton("Klik"), lockerStatusB = new JButton("Klik"), closeB = new JButton("Afsluiten");
    private JLabel packageStatusL = new JLabel("Status van pakket controleren"), lockerStatusL = new JLabel("Kluisjes status controleren");
    

    public StartScreen() {

        setTitle("Backoffice applicatie");
        setSize(500, 500);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        add(packageStatusL);
        add(packageStatusB);
        
        add(lockerStatusL);
        add(lockerStatusB);
        
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
            System.exit(0);
        }
    }
}