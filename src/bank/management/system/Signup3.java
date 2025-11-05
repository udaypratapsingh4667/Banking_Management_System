package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {

    JRadioButton a1,a2,a3,a4;    // like circle dot buttons
    JCheckBox s1,s2,s3,s4,s5,s6; // for tick box
    JCheckBox c1;
    JButton s,c; // manual clickable buttons

    String form_no;

    Signup3(String form_no){
        super("Account Details Form");

        this.form_no = form_no;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(60,15,100,100);
        add(image);

        JLabel l1 = new JLabel("Page 3: Account Details" );
        l1.setForeground(Color.BLACK);
        l1.setBounds(305, 70, 600, 40);
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        add(l1);

        JPanel line = new JPanel();
        line.setBounds(0, 130, 850, 2);
        line.setBackground(Color.BLACK);
        add(line);

//        JLabel l2 = new JLabel("" );
//        l2.setBounds(310,80,400,40);
//        l2.setFont(new Font("Raleway",Font.BOLD,22));
//        add(l2);

        // For Account Type
        JLabel l3 = new JLabel("Account Type:" );
        l3.setBounds(105,145,200,40);
        l3.setFont(new Font("Arial",Font.BOLD,18));
        add(l3);

        a1 = new JRadioButton("Savings Account");
        a1.setFont(new Font("Arial",Font.BOLD,14));
        a1.setBackground(Color.WHITE);
        a1.setBounds(105,180,200,40);
        add(a1);

        a2 = new JRadioButton("Fixed Deposit Account");
        a2.setFont(new Font("Arial",Font.BOLD,14));
        a2.setBackground(Color.WHITE);
        a2.setBounds(355,180,300,40);
        add(a2);

        a3 = new JRadioButton("Current Account");
        a3.setFont(new Font("Arial",Font.BOLD,14));
        a3.setBackground(Color.WHITE);
        a3.setBounds(105,220,200,40);
        add(a3);

        a4 = new JRadioButton("Recurring Deposit Account");
        a4.setFont(new Font("Arial",Font.BOLD,14));
        a4.setBackground(Color.WHITE);
        a4.setBounds(355,220,300,40);
        add(a4);

        //grouping all buttons
        ButtonGroup a1234 = new ButtonGroup();
        a1234.add(a1);
        a1234.add(a2);
        a1234.add(a3);
        a1234.add(a4);

        // For Card Number
        JLabel l4 = new JLabel("Card Number:");
        l4.setFont(new Font("Raleway",Font.BOLD,18));
        l4.setBounds(105,300,200,30);
        add(l4);

        JLabel l5 = new JLabel("(Your 16-digit Card Number)");
        l5.setFont(new Font("Raleway",Font.BOLD,12));
        l5.setBounds(105,330,200,20);
        add(l5);

        JLabel l6 = new JLabel("XXXX-XXXX-XXXX-4667");
        l6.setFont(new Font("Raleway",Font.BOLD,18));
        l6.setBounds(335,300,250,30);
        add(l6);

        JLabel l7 = new JLabel("(It would appear on ATM Card/Cheque Book and Statements)");
        l7.setFont(new Font("Raleway",Font.BOLD,12));
        l7.setBounds(335,330,400,20);
        add(l7);

        // For Pin
        JLabel l8 = new JLabel("PIN:");
        l8.setFont(new Font("Raleway",Font.BOLD,18));
        l8.setBounds(105,370,200,30);
        add(l8);

        JLabel l9 = new JLabel("XXXX");
        l9.setFont(new Font("Raleway",Font.BOLD,18));
        l9.setBounds(335,370,250,30);
        add(l9);

        JLabel l10 = new JLabel("(4-digit password)");
        l10.setFont(new Font("Raleway",Font.BOLD,12));
        l10.setBounds(105,400,400,20);
        add(l10);

        // For Services Required
        JLabel l11 = new JLabel("Services Required:");
        l11.setFont(new Font("Raleway",Font.BOLD,18));
        l11.setBounds(105,450,200,30);
        add(l11);

        s1 = new JCheckBox("ATM Card");
        s1.setFont(new Font("Raleway",Font.BOLD,14));
        s1.setBackground(Color.WHITE);
        s1.setBounds(110,500,100,30);
        add(s1);

        s2 = new JCheckBox("Internet Banking");
        s2.setFont(new Font("Raleway",Font.BOLD,14));
        s2.setBackground(Color.WHITE);
        s2.setBounds(360,500,150,30);
        add(s2);

        s3 = new JCheckBox("Mobile Banking");
        s3.setFont(new Font("Raleway",Font.BOLD,14));
        s3.setBackground(Color.WHITE);
        s3.setBounds(110,545,150,30);
        add(s3);

        s4 = new JCheckBox("EMAIL Alerts");
        s4.setFont(new Font("Raleway",Font.BOLD,14));
        s4.setBackground(Color.WHITE);
        s4.setBounds(360,545,150,30);
        add(s4);

        s5 = new JCheckBox("Cheque Book");
        s5.setFont(new Font("Raleway",Font.BOLD,14));
        s5.setBackground(Color.WHITE);
        s5.setBounds(110,590,150,30);
        add(s5);

        s6 = new JCheckBox("E-Statement");
        s6.setFont(new Font("Raleway",Font.BOLD,14));
        s6.setBackground(Color.WHITE);
        s6.setBounds(360,590,150,30);
        add(s6);

        // we write true to have default tick
        c1 = new JCheckBox("I hearby declared that the above entered details correct to the best of my knowledge.",true);
        c1.setFont(new Font("Raleway",Font.BOLD,12));
        c1.setBounds(105,660,550,20);
        c1.setBackground(Color.WHITE);
        add(c1);

        // For form no. at top-right corner
        JLabel l12 = new JLabel("Form No :");
        l12.setFont(new Font("Raleway",Font.BOLD,18));
        l12.setBounds(655,20,100,30);
        add(l12);

        //for Form Numeric Value
        JLabel l13 = new JLabel(form_no);
        l13.setFont(new Font("Raleway",Font.BOLD,18));
        l13.setBounds(750,20,60,30);
        add(l13);

        // for submit button
        s = new JButton("Submit");
        s.setFont(new Font("Raleway",Font.BOLD,14));
        s.setBounds(245,700,100,30);
        s.setForeground(Color.WHITE);
        s.setBackground(Color.BLACK);
        s.addActionListener(this);
        add(s);

        // for cancel button
        c = new JButton("Cancel");
        c.setFont(new Font("Raleway",Font.BOLD,14));
        c.setBounds(425,700,100,30);
        c.setForeground(Color.WHITE);
        c.setBackground(Color.BLACK);
        c.addActionListener(this);
        add(c);


        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(345,30);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String acctype = null;
        if(a1.isSelected()){
            acctype = "Savings Account";
        }else if(a2.isSelected()){
            acctype = "Fixed Deposit Account";
        }else if(a3.isSelected()){
            acctype = "Current Account";
        }else if(a4.isSelected()){
            acctype = "Recurring Deposit Account";
        }

        // for card_no and pin
        Random ran     = new Random();

        long first7    = ((ran.nextLong() % 90000000L) + 4667251200000000L); // and its like first8 -> 46672512 is written on own then the random 8 digits
        String card_no = String.valueOf(Math.abs(first7));

        int first3 = ran.nextInt(9000) + 1000;
        String pin = String.valueOf(first3);
//      long first3    = ((ran.nextLong() % 9000L) + 1000L);  // it is same like first4 because it is first4 only, but we can't take same variable name
//      String pin     = String.valueOf(Math.abs(first3));

        // for services || can't use null because it is later treated as a string when concatenated
        String ser = "";
        // not else if -> because after executing any one true condition it will exit
        if (s1.isSelected()) {
            ser += " ATM Card";  // += because we have to store all selection not just one like radio buttons
        } if (s2.isSelected()) {
            ser += " Internet Banking";
        } if (s3.isSelected()) {
            ser += " Mobile Banking";
        } if (s4.isSelected()) {
            ser += " EMAIl Alerts";
        } if (s5.isSelected()) {
            ser += " Cheque Book";
        } if (s6.isSelected()) {
            ser += " E-Statement";
        }
//---------------------------------------------------------------------------------------------------------------------------------------------------------
//        // now after fetching store the value
//        try{
//            if(ex.getSource() == s){  // Agar 'Submit' button daba
//                if(acctype.equals("") || ser.equals("")){
//                    JOptionPane.showMessageDialog(null,"Fill all the required fields");
//                }else if (!c1.isSelected()) { // for declaration because it is mandatory
//                    JOptionPane.showMessageDialog(null, "Please accept the declaration");
//                }else{
//                    Conn conn3 = new Conn();
//                    String q1  = "INSERT INTO signup3 VALUES('"+form_no+"','"+acctype+"','"+card_no+"','"+pin+"','"+ser+"')";
//                    String q2  = "INSERT INTO login VALUES('"+form_no+"','"+card_no+"','"+pin+"')";
//                    conn3.statement.executeUpdate(q1);
//                    conn3.statement.executeUpdate(q2);
//                    JOptionPane.showMessageDialog(null,"Card Number: " + card_no + "\n Pin: " + pin);
//                    setVisible(false);
//                }
//            } else if(ex.getSource() == c) {
//                // System.exit(0); -> because it is just closing everything
//                setVisible(false);
//                new Login();
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//    }
//-------------------------------------------------------------------------------------------------------------------------------------------------------

         // now after fetching store the value
        try{
        if(e.getSource() == s){ // Agar 'Submit' button daba

            // FIXED: Validation ko == null se check kiya
            if(acctype == null){
                JOptionPane.showMessageDialog(null,"Please select an Account Type");
            } else if (ser.isEmpty()) { // .equals("") ki jagah .isEmpty()
                JOptionPane.showMessageDialog(null, "Please select at least one Service");
            } else if (!c1.isSelected()) { // Declaration check
                JOptionPane.showMessageDialog(null, "Please accept the declaration");
            } else {

                // Validation passed, ab database mein save karo
                Conn conn3 = new Conn();

                /// --- YEH HAI SAHI FIX ---
                // Hum column ke naam bata rahe hain
                // (PIN ko customer table mein save nahi karte)
                String q1 = "UPDATE customer SET account_type = ?, card_number = ?, services = ? WHERE form_no = ?";

                conn3.ps = conn3.connection.prepareStatement(q1);
                conn3.ps.setString(1, acctype);
                conn3.ps.setString(2, card_no);
                conn3.ps.setString(3, ser.trim());
                conn3.ps.setString(4, form_no); // 'form_no' aakhri '?' hai
                conn3.ps.executeUpdate();

                // Column ke naam yahaan bhi batao
                String q2 = "INSERT INTO login(form_no, card_number, pin) VALUES(?, ?, ?)";

                conn3.ps = conn3.connection.prepareStatement(q2);
                conn3.ps.setString(1, form_no);
                conn3.ps.setString(2, card_no);
                conn3.ps.setString(3, pin);
                conn3.ps.executeUpdate();

                // to display the card number and pin
                JOptionPane.showMessageDialog(null,"Card Number: " + card_no + "\n Pin: " + pin);

                // sending pin to deposit
                new Deposit(pin);
                setVisible(false);
            }
        } else if(e.getSource() == c) { // Agar 'Cancel' button daba
            setVisible(false);
            new Login();
        }
        }catch (Exception ex) {
            ex.printStackTrace();
            }
        }
// no need of main method because the start is login --------------------------------------------------------------------------------------------------------------------
//    public static void main(String[] args) {
//        new Signup3("");
//    }
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

}
