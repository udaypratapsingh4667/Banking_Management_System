package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {

    String pin;
    JTextField textField;
    JButton b1,b2;

    Withdrawal(String pin){

        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel l1 = new JLabel("MAXIMUM WITHDRAWAL IS Rs.10,000");
        l1.setFont(new Font("System",Font.BOLD,16));
        l1.setBounds(480,160,400,35);
        l1.setForeground(Color.WHITE);
        l3.add(l1);                                // when you want to override then l3.add() otherwise simply on the JFrame add()

        JLabel l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setFont(new Font("System",Font.BOLD,16));
        l2.setBounds(435,210,400,35);
        l2.setForeground(Color.WHITE);
        l3.add(l2);

        textField = new JTextField();
        textField.setBounds(435,250,320,25);
        textField.setFont(new Font("Raleway",Font.BOLD,20));
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.WHITE);
        l3.add(textField);

        //Withdraw Button
        b1 = new JButton("WITHDRAW");
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
        try{
            if (e.getSource() == b2) { // BACK button
                setVisible(false);
                new main_Class(pin);
                return; // Exit the method || because we are not using if and else
            }

            String amount = textField.getText();
            Date date     = new Date();

            int withdrawAmount = 0;
            try {
                // 1. Check if it's a valid number
                withdrawAmount = Integer.parseInt(amount);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Please enter a valid numeric amount (e.g., 500)");
                return;
            }
            // 2. Check if it's a positive number
            if (withdrawAmount <= 0) {
                JOptionPane.showMessageDialog(null, "Amount to withdraw must be greater than 0");
                return;
            }

                Conn conn = new Conn();

                String selectQuery = "SELECT * FROM bank WHERE pin = ?";
                conn.ps = conn.connection.prepareStatement(selectQuery);
                conn.ps.setString(1, pin);

                ResultSet resultSet = conn.ps.executeQuery();

                int balance = 0;
                while(resultSet.next()){
                    if(resultSet.getString("type").equals("Deposit")){
                        balance += resultSet.getInt("amount");
                    }
                    else{
                        balance -= resultSet.getInt("amount");
                    }
                }
                if(balance < withdrawAmount){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }

                String q = "INSERT INTO bank(pin, date, type, amount) VALUES(?, ?, ?, ?)";
                conn.ps = conn.connection.prepareStatement(q);

                conn.ps.setString(1, pin);
                conn.ps.setTimestamp(2, new java.sql.Timestamp(date.getTime()));
                conn.ps.setString(3, "Withdrawal");
                conn.ps.setInt   (4, withdrawAmount);

                conn.ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Rs."+ amount + " Debited Successfully");
                setVisible(false);
                new main_Class(pin);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
