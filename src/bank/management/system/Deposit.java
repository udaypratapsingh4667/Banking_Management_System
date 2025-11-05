package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    String pin;
    JTextField textField;
    JButton b1,b2;

    Deposit(String pin){

        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setFont(new Font("System",Font.BOLD,16));
        l1.setBounds(460,180,400,35);
        l1.setForeground(Color.WHITE);
        l3.add(l1);                                                          // when you want to override then l3.add() otherwise simply on the JFrame add()

        textField = new JTextField();
        textField.setBounds(460,230,320,25);
        textField.setFont(new Font("Raleway",Font.BOLD,20));
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.WHITE);
        l3.add(textField);

        //Deposit Button
        b1 = new JButton("DEPOSIT");
        b1.setBounds(700,364,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        //Back Button
        b2 = new JButton("BACK");
        b2.setBounds(700,408,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);


        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            try {
                String amount = textField.getText();
                Date date = new Date();
                if (e.getSource()==b1){
                    if (amount.isEmpty()){
                        JOptionPane.showMessageDialog(null,"Please enter the Amount you want to Deposit");
                        return;
                    }
// -------------------------------------------------------------------------------------------------------------------------------------------------------------------
                    // protection from bad data
                    int depositAmount = 0;
                    try {
                        // 1. Check if it's a valid number
                        depositAmount = Integer.parseInt(amount);
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid numeric amount (e.g., 500)");
                        return;
                    }

                    // 2. Check if it's a positive number
                    if (depositAmount <= 0) {
                        JOptionPane.showMessageDialog(null, "Amount must be greater than 0");
                        return;
                    }
// -------------------------------------------------------------------------------------------------------------------------------------------------------------------
                        Conn c = new Conn();
                        // --- SECURITY FIX ---

                        // 1. Template banaao
                        String q = "INSERT INTO bank(pin, date, type, amount) VALUES(?, ?, ?, ?)";

                        // 2. Template ko prepare karo
                        c.ps = c.connection.prepareStatement(q);

                        // 3. Placeholders ko bharo
                        c.ps.setString(1, pin);
                        c.ps.setTimestamp(2, new java.sql.Timestamp(date.getTime()));
                        c.ps.setString(3, "Deposit");
                        c.ps.setInt   (4, depositAmount);

                        // 4. Execute kara
                        c.ps.executeUpdate();
                        // ---------------------
                        JOptionPane.showMessageDialog(null,"Rs. "+amount+" Deposited Successfully");
                        new main_Class(pin);
                        setVisible(false);

                }else if (e.getSource()==b2){
                    new main_Class(pin);    // back button
                    setVisible(false);
                }
            }catch (Exception E){
                E.printStackTrace();
            }
        }
// no need of main method because the start is login ------------------------------------------------------------------------------------------------------------------
//    public static void main(String[] args) {
//        new Deposit("");
//    }
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------

}

