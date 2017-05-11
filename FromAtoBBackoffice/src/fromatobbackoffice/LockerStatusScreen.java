package fromatobbackoffice;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LockerStatusScreen extends JDialog implements ActionListener {

    private JLabel stationnaam = new JLabel("StationNaam");
    private JTextField station = new JTextField(10);
    private JButton statusBekijken = new JButton("Check Status"), closeB = new JButton("Afsluiten");
    

    public LockerStatusScreen(JFrame frame) {
        super(frame,true);
        
        setTitle("Kluis status");
        setSize(500, 500);
        setLayout(new FlowLayout());

        
        add(stationnaam);
        add(station);
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
