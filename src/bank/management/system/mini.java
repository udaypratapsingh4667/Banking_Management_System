package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class mini extends JFrame implements ActionListener {

    String pin;
    JButton button1,button2;

    mini(String pin){

        this.pin = pin;

        JLabel l1 = new JLabel();
        l1.setBounds(20,140,400,250);
        add(l1);

        JLabel l2 = new JLabel("Mini Statement");
        l2.setFont(new Font("System",Font.BOLD,15));
        l2.setBounds(150,20,200,20);
        add(l2);

        JPanel line = new JPanel();
        line.setBounds(148, 42, 114, 2);
        line.setBackground(Color.BLACK);
        add(line);

        JLabel l3 = new JLabel();
        l3.setBounds(20,80,300,20);
        add(l3);

        JLabel l4 = new JLabel();
        l4.setBounds(20,400,300,22);
        add(l4);

        // label3 ka kaam hogya
        try{
            Conn conn = new Conn();

            // 1. Prepared the secure query
            String q1 = "SELECT * FROM login WHERE pin = ?";
            conn.ps = conn.connection.prepareStatement(q1);
            conn.ps.setString(1, pin);

            // 2. Executed it
            ResultSet resultSet = conn.ps.executeQuery();

            while(resultSet.next()){
                l3.setText("Card Number: " + resultSet.getString("card_number").substring(0,4) + "-XXXX-XXXX-" + resultSet.getString("card_number").substring(12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try{
            Conn conn = new Conn();

            // 1. Prepared the secure query
            String q2 = "SELECT * FROM bank WHERE pin = ?";
            conn.ps = conn.connection.prepareStatement(q2);
            conn.ps.setString(1, pin);

            // 2. Executed it
            ResultSet resultSet = conn.ps.executeQuery();

            int balance = 0;

            // --- 3. HTML TABLE SHURU KARO ---
            // 'width' set karne se columns align rahenge
            l1.setText("<html><table width='260px'>");

            while(resultSet.next()){

                java.sql.Timestamp ts = resultSet.getTimestamp("date");
                String date = (ts != null) ? ts.toString().substring(0, 19) : "N/A";
             // String date = ts.toString().substring(0, 19); // '2025-11-05 12:30:00'

                String type    = resultSet.getString("type");
                int amount_int = resultSet.getInt("amount");
                String amount = String.valueOf(amount_int);

                // --- 4. DATA KO TABLE ROW (<tr>) MEIN DAALO ---
                String newRow = "<tr>" +
                        "<td width='150' align='left'>" + date + "</td>" +
                        "<td width='120' align='center'>" + type + "</td>" +
                        "<td width='80'  align='right'>" + amount + "</td>" + // 'align=right' se amount right mein dikhega
                        "</tr>";

                l1.setText(l1.getText() + newRow); // Nayi row ko table mein add karo

                // --- Balance waala logic bilkul waisa hi rahega ---
                if(resultSet.getString("type").equals("Deposit")){
                    balance += resultSet.getInt("amount");
                }
                else{
                    balance -= resultSet.getInt("amount");
                }
            }

            // --- 5. TABLE KO BAND KARO ---
            l1.setText(l1.getText() + "</table></html>");

            l4.setText("Your total balance is Rs. " + balance);

        } catch (Exception e) {
            e.printStackTrace();
        }

        button1 = new JButton("Back");
        button1.setBounds(80,500,90,25);
        button1.addActionListener(this);
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        add(button1);

        button2 = new JButton("Exit");
        button2.setBounds(220,500,90,25);
        button2.addActionListener(this);
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);
        add(button2);


        getContentPane().setBackground(new Color(105, 226, 246));
        setLayout(null);
        setSize(400,600);
        setLocation(570,100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == button1){
            new main_Class(pin);
            setVisible(false);
        }
        else{
            System.exit(0);
        }
    }
}
