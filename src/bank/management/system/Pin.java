package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener {

    JButton b1,b2;
    JPasswordField p1,p2;

    String pin;

    Pin(String pin){

        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0,0,1550,830);
        add(label);

        JLabel l1 = new JLabel("CHANGE YOUR PIN: ");
        l1.setFont(new Font("System",Font.BOLD,16));
        l1.setBounds(430,180,400,35);
        l1.setForeground(Color.WHITE);
        label.add(l1);

        JLabel l2 = new JLabel("Create New Pin: ");
        l2.setFont(new Font("System",Font.BOLD,14));
        l2.setBounds(430,220,150,35);
        l2.setForeground(Color.WHITE);
        label.add(l2);

        p1 = new JPasswordField();
        p1.setFont(new Font("Raleway",Font.BOLD,20));
        p1.setBackground(new Color(65,125,128));
        p1.setBounds(580,225,180,25);
        p1.setForeground(Color.WHITE);
        label.add(p1);

        JLabel l3 = new JLabel("Re-Enter New Pin: ");
        l3.setFont(new Font("System",Font.BOLD,14));
        l3.setBounds(430,250,400,35);
        l3.setForeground(Color.WHITE);
        label.add(l3);

        p2 = new JPasswordField();
        p2.setFont(new Font("Raleway",Font.BOLD,20));
        p2.setBackground(new Color(65,125,128));
        p2.setBounds(580,255,180,25);
        p2.setForeground(Color.WHITE);
        label.add(p2);

        //Change Pin Button
        b1 = new JButton("CHANGE");
        b1.setBounds(700,364,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        label.add(b1);

        //Back Button
        b2 = new JButton("BACK");
        b2.setBounds(700,408,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        label.add(b2);

        setSize(1550,1080);
        setLayout(null);
        setLocation(0,0);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        try{
            String pin1 = String.valueOf(p1.getPassword());
            String pin2 = String.valueOf(p2.getPassword());

            if(!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null,"Entered Pin does not match");
                return;
            }
            if(e.getSource() == b1){
                if(pin1.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Enter New Pin");
                    return;
                }
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//                // No need of this because above 2 conditions covers both
//                if(pin2.isEmpty()){
//                    JOptionPane.showMessageDialog(null,"Re-Enter New Pin");
//                    return;
//                }
                
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------                

//                // now for changing the pin we have to change in all databases
//                String q1 = "UPDATE bank SET pin = '"+pin1+"' WHERE pin = '"+pin+"'";
//                String q2 = "UPDATE login SET pin = '"+pin1+"' WHERE pin = '"+pin+"'";
//                String q3 = "UPDATE signup3 SET pin = '"+pin1+"' WHERE pin = '"+pin+"'";
//
//                conn.statement.executeUpdate(q1);
//                conn.statement.executeUpdate(q2);
//                conn.statement.executeUpdate(q3);

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
                
                Conn conn = new Conn();

                // Query 1: Update 'bank' table
                String q1 = "UPDATE bank SET pin = ? WHERE pin = ?";
                conn.ps = conn.connection.prepareStatement(q1);
                conn.ps.setString(1, pin1); // Set the NEW pin
                conn.ps.setString(2, pin);  // Where old pin matches
                conn.ps.executeUpdate();

                // Query 2: Update 'login' table
                String q2 = "UPDATE login SET pin = ? WHERE pin = ?";
                conn.ps = conn.connection.prepareStatement(q2);
                conn.ps.setString(1, pin1); // Set the NEW pin
                conn.ps.setString(2, pin);  // Where old pin matches
                conn.ps.executeUpdate();

                  // No need now
//                // Query 3: Update 'signup3' table
//                String q3 = "UPDATE signup3 SET pin = ? WHERE pin = ?";
//                conn.ps = conn.connection.prepareStatement(q3);
//                conn.ps.setString(1, pin1); // Set the NEW pin
//                conn.ps.setString(2, pin);  // Where old pin matches
//                conn.ps.executeUpdate();
                
                JOptionPane.showMessageDialog(null,"Pin changed successfully");
                setVisible(false);
                new main_Class(pin1);
            }
            else if (e.getSource() == b2) {
                setVisible(false);
                new main_Class(pin);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
