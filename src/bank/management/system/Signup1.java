package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup1 extends JFrame implements ActionListener {

    // for radio buttons
    JRadioButton r1, r2, m1, m2, m3;
    JButton next;

    //Text field because we also have to get the data after the user have given so declaring it globally
    JTextField textName, textFName, textEmail, textAdd, textCity, textPin, textState;
    JDateChooser dateChooser;

    // For Random Number
    Random random = new Random();
    int first4 = random.nextInt(9000) + 1000;
    String first = String.valueOf(first4);
//    long first4 = (random.nextLong() % 9000L) + 1000L;
//    String first = String.valueOf(Math.abs(first4)); // math.abs change the no to +ve and String.valueOf change it to String


    Signup1() {
        super("APPLICATION FORM");

        // global declaration
        Font titleFont = new Font("Raleway", Font.BOLD, 34);
        Font subTitleFont = new Font("Raleway", Font.BOLD, 22);
        Font labelFont = new Font("Raleway", Font.BOLD, 20);
        Font fieldFont = new Font("Raleway", Font.BOLD, 15);

        Color bankBlue = new Color(25, 118, 210);

        //image of bank logo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(60,15,100,100);
        add(image);

        //for form number
        JLabel label1 = new JLabel("APPLICATION FORM NO: " + first);
        label1.setBounds(220, 20, 600, 45);
        label1.setFont(titleFont);
        label1.setForeground(bankBlue);
        add(label1);

        // for Page1
        JLabel label2 = new JLabel("Page 1: Personal Details");
        label2.setBounds(300, 90, 600, 30);
        label2.setFont(subTitleFont);
        label2.setForeground(Color.BLACK);
        add(label2);

//        // for Personal information
//        JLabel label3 = new JLabel("Personal Details");
//        label3.setBounds(300,120,600,40);
//        label3.setFont(subTitleFont);
//        add(label3);

        //line add krna
        JPanel line = new JPanel();
        line.setBounds(0, 130, 850, 2);
        line.setBackground(Color.BLACK);
        add(line);

        //for name
        JLabel labelName = new JLabel("Name :");
        labelName.setFont(labelFont);
        labelName.setBounds(100, 190, 100, 30);
        add(labelName);

        textName = new JTextField();
        textName.setFont(fieldFont);
        textName.setBounds(300, 190, 400, 30);
        add(textName);

        // for father name
        JLabel labelFName = new JLabel("Father's Name :");
        labelFName.setFont(labelFont);
        labelFName.setBounds(100, 240, 200, 30);
        add(labelFName);

        textFName = new JTextField();
        textFName.setFont(fieldFont);
        textFName.setBounds(300, 240, 400, 30);
        add(textFName);

        // for DOB
        JLabel DOB = new JLabel("Date of Birth :");
        DOB.setFont(labelFont);
        DOB.setBounds(100, 340, 200, 30);
        add(DOB);
        //for bringing calendar we have to use class JDateChooser and also importing jar file
        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(300, 340, 400, 30);
        add(dateChooser);

        // for gender
        JLabel labelG = new JLabel("Gender :");
        labelG.setFont(labelFont);
        labelG.setBounds(100, 290, 200, 30);
        add(labelG);

        // for male
        r1 = new JRadioButton("Male");
        r1.setFont(fieldFont);
        r1.setBackground(Color.WHITE);
        r1.setBounds(300, 290, 60, 30);
        add(r1);

        //for female
        r2 = new JRadioButton("Female");
        r2.setFont(fieldFont);
        r2.setBackground(Color.WHITE);
        r2.setBounds(450, 290, 90, 30);
        add(r2);

        //to select only one we use Button group
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(r1);
        buttonGroup1.add(r2);

        // for email
        JLabel labelEmail = new JLabel("Email Address :");
        labelEmail.setBounds(100, 390, 200, 30);
        labelEmail.setFont(labelFont);
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setBounds(300, 390, 400, 30);
        textEmail.setFont(fieldFont);
        add(textEmail);

        // for Marital Status
        JLabel labelMs = new JLabel("Marital Status :");
        labelMs.setBounds(100, 440, 200, 30);
        labelMs.setFont(labelFont);
        add(labelMs);

        //for married
        m1 = new JRadioButton("Married");
        m1.setFont(fieldFont);
        m1.setBounds(300, 440, 100, 30);
        m1.setBackground(Color.WHITE);
        add(m1);
        // for unmarried
        m2 = new JRadioButton("Unmarried");
        m2.setFont(fieldFont);
        m2.setBounds(450, 440, 150, 30);
        m2.setBackground(Color.WHITE);
        add(m2);
        // for other
        m3 = new JRadioButton("Other");
        m3.setFont(fieldFont);
        m3.setBounds(600, 440, 100, 30);
        m3.setBackground(Color.WHITE);
        add(m3);

        // for selecting only one button
        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(m1);
        buttonGroup2.add(m2);
        buttonGroup2.add(m3);

        // for Address
        JLabel labelAdd = new JLabel("Address :");
        labelAdd.setBounds(100, 490, 200, 30);
        labelAdd.setFont(labelFont);
        add(labelAdd);

        textAdd = new JTextField();
        textAdd.setBounds(300, 490, 400, 30);
        textAdd.setFont(fieldFont);
        add(textAdd);

        // for City
        JLabel labelCity = new JLabel("City :");
        labelCity.setBounds(100, 540, 200, 30);
        labelCity.setFont(labelFont);
        add(labelCity);

        textCity = new JTextField();
        textCity.setBounds(300, 540, 400, 30);
        textCity.setFont(fieldFont);
        add(textCity);

        // for Pin Code
        JLabel labelPin = new JLabel("Pin Code :");
        labelPin.setBounds(100, 590, 200, 30);
        labelPin.setFont(labelFont);
        add(labelPin);

        textPin = new JTextField();
        textPin.setBounds(300, 590, 400, 30);
        textPin.setFont(fieldFont);
        add(textPin);

        // for State
        JLabel labelState = new JLabel("State :");
        labelState.setBounds(100, 640, 200, 30);
        labelState.setFont(labelFont);
        add(labelState);

        textState = new JTextField();
        textState.setBounds(300, 640, 400, 30);
        textState.setFont(fieldFont);
        add(textState);

        next = new JButton("Next");
        next.setFont(fieldFont);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620, 710, 80, 30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.WHITE);// ContentPane to set background color
        setLayout(null);
        setSize(850, 800);
        setLocation(345, 30);
        setVisible(true);
    }


// no need of main method because the start is login ------------------------------------------------------------------------------------------------------------------
//    public static void main(String[] args) {
//        new Signup1();
//    }
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------


    @Override
    public void actionPerformed(ActionEvent e) {

        // data ko lene ke liye
        String formno = first;                   // for taking input from the user
        String name = textName.getText();
        String fname = textFName.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        // For gender
        String gender = null;
        if (r1.isSelected()) {
            gender = "Male";
        } else if (r2.isSelected()) {
            gender = "Female";
        }
        // for email
        String email = textEmail.getText();
        // for marital status
        String marital = null;
        if (m1.isSelected()) {
            marital = "Married";
        } else if (m2.isSelected()) {
            marital = "Unmarried";
        } else if (m3.isSelected()) {
            marital = "Other";
        }

        String address = textAdd.getText();
        String city = textCity.getText();
        String pincode = textPin.getText();
        String state = textState.getText();

        // data ko store krane ke liye
        try {
            // if(textName.getText().equals("")) ki jgh -> name.isEmpty()
            if (name.isEmpty() || fname.isEmpty() || dob.isEmpty() || email.isEmpty() || address.isEmpty() || city.isEmpty() || pincode.isEmpty() || state.isEmpty()) {
                //JOptionPane - to show popups like yes/no or warnings like fill out the field
                JOptionPane.showMessageDialog(null, "Please fill out all required fields");
            } else if (gender == null) {
                // Radio buttons ke liye .isEmpty() nahi, == null check hota hai
                JOptionPane.showMessageDialog(null, "Please select a gender");
            } else if (marital == null) {
                JOptionPane.showMessageDialog(null, "Please select marital status");
            } else {
                Conn conn1 = new Conn(); // created the object of Conn(connection establishing) class
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                // it's a query, and it has a proper syntax like '"+code+"' -> + is string concatenation " is syntax of starting any String in java ' is sql syntax of writing varchar
                //String q = "INSERT INTO signup VALUES('"+formno+"' , '"+name+"' , '"+fname+"' , '"+dob+"' , '"+gender+"' , '"+email+"' , '"+marital+"' , '"+address+"' , '"+city+"' , '"+pincode+"' ,  '"+state+"')";
                // for executing the query
                //conn1.statement.executeUpdate(q);
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

                // 1. Template banaya || ? ko placeholders kehte hain
                String q = "INSERT INTO customer(form_no, name, father_name, DOB, gender, email, marital_status, address, city, pincode, state) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                // 2. Template ko database par prepare kiya
                conn1.ps = conn1.connection.prepareStatement(q);

                // 3. Ab template ko bhara
                conn1.ps.setString(1, formno);
                conn1.ps.setString(2, name);
                conn1.ps.setString(3, fname);
                conn1.ps.setString(4, dob);
                conn1.ps.setString(5, gender);
                conn1.ps.setString(6, email);
                conn1.ps.setString(7, marital);
                conn1.ps.setString(8, address);
                conn1.ps.setString(9, city);
                conn1.ps.setString(10, pincode);
                conn1.ps.setString(11, state);

                // 4. Ab execute kiya
                conn1.ps.executeUpdate();

                // working after clicking next
                new Signup2(first);
                setVisible(false);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
