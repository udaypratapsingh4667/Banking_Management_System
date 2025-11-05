package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup2 extends JFrame implements ActionListener {

    JComboBox<String> comboBox1,comboBox2,comboBox3,comboBox4,comboBox5; // A combination of a text field and a drop-down list
    JTextField textPan,textAadhar;
    JRadioButton r1,r2,e1,e2;
    JButton next;

    String form_no;

    Signup2(String first){
        super("APPLICATION FORM");

        form_no = first;

        // Global Fonts and Colors (like Signup1)
        Font subTitleFont = new Font("Raleway", Font.BOLD, 22);
        Font labelFont    = new Font("Raleway", Font.BOLD, 20);
        Font fieldFont    = new Font("Raleway", Font.BOLD, 15);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image     i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(60,15,100,100);
        add(image);


        JLabel l1 = new JLabel("Page 2: Additional Details");
        l1.setFont(subTitleFont);
        l1.setForeground(Color.BLACK);
        l1.setBounds(300, 70, 600, 40);
        add(l1);

        JPanel line = new JPanel();
        line.setBounds(0, 125, 850, 2);
        line.setBackground(Color.BLACK);
        add(line);

        // for religion
        JLabel l3 = new JLabel("Religion :");
        l3.setFont(labelFont);
        l3.setBounds(100,170,150,30);
        add(l3);

        String[] religion = {"Hindu","Muslim","Sikh","Christian","Other"};
        comboBox1 = new JComboBox<String>(religion);
        comboBox1.setBackground(Color.WHITE);
        comboBox1.setFont(fieldFont);
        comboBox1.setBounds(350,170,320,30);
        add(comboBox1);

        //for category
        JLabel l4 = new JLabel("Category :");
        l4.setFont(labelFont);
        l4.setBounds(100,230,150,30);
        add(l4);

        String[] category = {"General","OBC","SC","ST","Other"};
        comboBox2 = new JComboBox<String>(category);
        comboBox2.setBackground(Color.WHITE);
        comboBox2.setFont(fieldFont);
        comboBox2.setBounds(350,230,320,30);
        add(comboBox2);

        //for income
        JLabel l5 = new JLabel("Income :");
        l5.setFont(labelFont);
        l5.setBounds(100,290,150,30);
        add(l5);

        String[] income = {"Null","<1,50,000","<2,50,000","<5,00,000","<10,00,000","Above 10,00,000"};
        comboBox3 = new JComboBox<String>(income);
        comboBox3.setBackground(Color.WHITE);
        comboBox3.setFont(fieldFont);
        comboBox3.setBounds(350,290,320,30);
        add(comboBox3);

        //for education
        JLabel l6 = new JLabel("Education :");
        l6.setFont(labelFont);
        l6.setBounds(100,350,200,30);
        add(l6);

        String[] education = {"Non-Graduate","Graduate","Post-Graduate","Doctorate","Other"};
        comboBox4 = new JComboBox<String>(education);
        comboBox4.setBackground(Color.WHITE);
        comboBox4.setFont(fieldFont);
        comboBox4.setBounds(350,350,320,30);
        add(comboBox4);

        //for Occupation
        JLabel l7 = new JLabel("Occupation :");
        l7.setFont(labelFont);
        l7.setBounds(100,410,200,30);
        add(l7);

        String[] occupation = {"Salaried","Self-Employed","Business","Student","Retired","Other"};
        comboBox5 = new JComboBox<String>(occupation);
        comboBox5.setBackground(Color.WHITE);
        comboBox5.setFont(fieldFont);
        comboBox5.setBounds(350,410,320,30);
        add(comboBox5);

        //for Pan Number
        JLabel l8 = new JLabel("PAN Number :");
        l8.setFont(labelFont);
        l8.setBounds(100,470,200,30);
        add(l8);

        textPan = new JTextField();
        textPan.setFont(fieldFont);
        textPan.setBounds(350,470,320,30);
        add(textPan);

        //for Aadhaar Number
        JLabel l9 = new JLabel("Aadhaar Number :");
        l9.setFont(labelFont);
        l9.setBounds(100,530,200,30);
        add(l9);

        textAadhar = new JTextField();
        textAadhar.setFont(fieldFont);
        textAadhar.setBounds(350,530,320,30);
        add(textAadhar);

        //for Senior Citizens
        JLabel l10 = new JLabel("Senior Citizen :");
        l10.setFont(labelFont);
        l10.setBounds(100,590,200,30);
        add(l10);

        r1 = new JRadioButton("Yes");
        r1.setFont(fieldFont);
        r1.setBackground(Color.WHITE);
        r1.setBounds(350,590,100,30);
        add(r1);

        r2 = new JRadioButton("No");
        r2.setFont(fieldFont);
        r2.setBackground(Color.WHITE);
        r2.setBounds(450,590,100,30);
        add(r2);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(r1);
        buttonGroup1.add(r2);

        //for Existing Account
        JLabel l11 = new JLabel("Existing Account :");
        l11.setFont(labelFont);
        l11.setBounds(100,650,200,30);
        add(l11);

        e1 = new JRadioButton("Yes");
        e1.setFont(fieldFont);
        e1.setBackground(Color.WHITE);
        e1.setBounds(350,650,100,30);
        add(e1);

        e2 = new JRadioButton("No");
        e2.setFont(fieldFont);
        e2.setBackground(Color.WHITE);
        e2.setBounds(450,650,100,30);
        add(e2);

        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(e1);
        buttonGroup2.add(e2);

        //for Form No
        JLabel l12 = new JLabel("Form No :");
        l12.setFont(new Font("Raleway",Font.BOLD,18));
        l12.setBounds(650,20,100,30);
        add(l12);

        //for Form Numeric Value
        JLabel l13 = new JLabel(form_no);
        l13.setFont(new Font("Raleway",Font.BOLD,18));
        l13.setBounds(745,20,60,30);
        add(l13);

        next = new JButton("Next");
        next.setFont(fieldFont);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620,700,80,30);
        next.addActionListener(this);
        add(next);


        setLayout(null);
        setSize(850,800);
        setLocation(345,30);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }


// no need of main method because the start is login ------------------------------------------------------------------------------------------------------------------
//    public static void main(String[] args) {
//        new Signup2("");
//    }
//-------------------------------------------------- ------------------------------------------------------------------------------------------------------------------


    @Override
    public void actionPerformed(ActionEvent e) {
        String rel  = String.valueOf(comboBox1.getSelectedItem());
        String cate = String.valueOf(comboBox2.getSelectedItem());
        String inc  = String.valueOf(comboBox3.getSelectedItem());
        String edu  = String.valueOf(comboBox4.getSelectedItem());
        String occ  = String.valueOf(comboBox5.getSelectedItem());

        String pan     = textPan.getText();
        String aadhaar = textAadhar.getText();

        String senior  = null;
        if(r1.isSelected()){
            senior = "Yes";
        }
        else if(r2.isSelected()){
            senior = "No";
        }

        String acc_exist  = null;
        if(e1.isSelected()){
            acc_exist = "Yes";
        }
        else if(e2.isSelected()){
            acc_exist = "No";
        }

        //String form_no = first;

        try{
            if(pan.isEmpty() || aadhaar.isEmpty()){
                JOptionPane.showMessageDialog(null,"Fill out all the required fields");
            }
            else if (senior == null) {
                // Radio buttons ke liye .isEmpty() nahi, == null check hota hai
                JOptionPane.showMessageDialog(null, "Please select yes or no");
            }
            else if (acc_exist == null) {
                JOptionPane.showMessageDialog(null, "Please select yes or no");
            }
            else{
                Conn conn2 = new Conn();
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                // String q = "INSERT INTO signup2 VALUES('"+form_no+"' , '"+rel+"' , '"+cate+"' , '"+inc+"' , '"+edu+"' , '"+occ+"' , '"+pan+"' , '"+aadhaar+"' , '"+senior+"' , '"+acc_exist+"')";
                //conn2.statement.executeUpdate(q);
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

                // 1. Template banaya || ? ko placeholders kehte hain
                String q = "UPDATE customer SET religion = ?, category = ?, income = ?, education = ?, occupation = ?, pan = ?, aadhaar = ?, senior_citizen = ?, existing_account = ? WHERE form_no = ?";
                // 2. Template ko database par prepare kiya
                conn2.ps = conn2.connection.prepareStatement(q);

                // 3. Ab template ko bhara
                conn2.ps.setString(1, rel);
                conn2.ps.setString(2, cate);
                conn2.ps.setString(3, inc);
                conn2.ps.setString(4, edu);
                conn2.ps.setString(5, occ);
                conn2.ps.setString(6, pan);
                conn2.ps.setString(7, aadhaar);
                conn2.ps.setString(8, senior);
                conn2.ps.setString(9, acc_exist);
                conn2.ps.setString(10, form_no);

                // 4. Ab execute kiya
                conn2.ps.executeUpdate();

                new Signup3(form_no);
                setVisible(false);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}