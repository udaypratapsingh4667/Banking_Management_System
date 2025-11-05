package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    String pin;

    JButton b1,b2,b3,b4,b5,b6,b7;

    FastCash(String pin){

        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel l1 = new JLabel("SELECT WITHDRAWAL AMOUNT");
        l1.setFont(new Font("System",Font.BOLD,16));
        l1.setBounds(435,200,400,35);
        l1.setForeground(Color.WHITE);
        l3.add(l1);

        // Rs.100 Button
        b1 = new JButton("Rs 100");
        b1.setBackground(new Color(65,125,128));
        b1.setBounds(408,272,150,35);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        // Rs.500 Button
        b2 = new JButton("Rs 500");
        b2.setBackground(new Color(65,125,128));
        b2.setBounds(700,272,150,35);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);

        // Rs.1000 Button
        b3 = new JButton("Rs 1000");
        b3.setBackground(new Color(65,125,128));
        b3.setBounds(408,318,150,35);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        l3.add(b3);

        // Rs.2000 Button
        b4 = new JButton("Rs 2000");
        b4.setBounds(700,318,150,35);
        b4.setBackground(new Color(65,125,128));
        b4.setForeground(Color.WHITE);
        b4.addActionListener(this);
        l3.add(b4);

        // Rs.5000 Button
        b5 = new JButton("Rs 5000");
        b5.setBackground(new Color(65,125,128));
        b5.setBounds(408,364,150,35);
        b5.setForeground(Color.WHITE);
        b5.addActionListener(this);
        l3.add(b5);

        // Rs.10000 Button
        b6 = new JButton("Rs 10000");
        b6.setBackground(new Color(65,125,128));
        b6.setBounds(700,364,150,35);
        b6.setForeground(Color.WHITE);
        b6.addActionListener(this);
        l3.add(b6);

        //Back Button
        b7 = new JButton("BACK");
        b7.setBounds(700,408,150,35);
        b7.setBackground(new Color(65,125,128));
        b7.setForeground(Color.WHITE);
        b7.addActionListener(this);
        l3.add(b7);


        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == b7){
            new main_Class(pin);
            setVisible(false);
        }else{
            String amount = ((JButton)e.getSource()).getText().substring(3);  //because e.getSource return Object
            Conn conn = new Conn();
            Date date = new Date();

            try{
                String q1 = "SELECT * FROM bank WHERE pin = ?";
                conn.ps = conn.connection.prepareStatement(q1);
                conn.ps.setString(1, pin);
                ResultSet resultSet = conn.ps.executeQuery();

                int balance = 0;
                while(resultSet.next()){
                    if(resultSet.getString("type").equals("Deposit")){
                        // balance += Integer.parseInt(resultSet.getString("amount"));
                        balance += resultSet.getInt("amount");
                    }else{
                        // balance -= Integer.parseInt(resultSet.getString("amount"));
                        balance -= resultSet.getInt("amount");
                    }
                }

                if(balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }

                String q2 = "INSERT INTO bank(pin, date, type, amount) VALUES(?, ?, ?, ?)";
                conn.ps = conn.connection.prepareStatement(q2);

                conn.ps.setString(1, pin);
                conn.ps.setTimestamp(2, new java.sql.Timestamp(date.getTime()));
                conn.ps.setString(3, "Withdrawal");
                conn.ps.setInt   (4, Integer.parseInt(amount));

                conn.ps.executeUpdate();

                JOptionPane.showMessageDialog(null,"Rs. " + amount + " debited successfully");

                setVisible(false);
                new main_Class(pin);

            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
