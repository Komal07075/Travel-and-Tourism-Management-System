
package travel.management.system;


import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener {
    
    JLabel labelUsername, labelName;
    JComboBox comboId;
    JTextField tfNumber, tfAddress, tfCountry, tfEmail, tfPhone;
    JRadioButton rMale, rFemale;
    JButton add, back;
    
    AddCustomer(String username) {
        //Adding frame
        setBounds(450, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        //Adding 'Username' label on frame
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(30, 50, 150, 25);
        add(lblUsername);
        
        //Adding label for username field
        labelUsername = new JLabel("");
        labelUsername.setBounds(220, 50, 150, 25);
        add(labelUsername);
        
        //Adding 'ID' label on frame
        JLabel lblId = new JLabel("ID");
        lblId.setBounds(30, 90, 150, 25);
        add(lblId);
        
        //Adding drop down choices for ID
        comboId = new JComboBox(new String[] {"Passport", "Aadhar Card", "Pan Card", "Ration Card"});
        comboId.setBounds(220, 90, 150, 25);
        comboId.setBackground(Color.WHITE);
        add(comboId);
        
        //Adding 'Number' label on frame
        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(30, 130, 150, 25);
        add(lblNumber);
        
        //Adding text field for Number
        tfNumber = new JTextField();
        tfNumber.setBounds(220, 130, 150, 25);
        add(tfNumber);
        
        //Adding 'Name' label on frame
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(30, 170, 150, 25);
        add(lblName);
        
        //Adding label for name field
        labelName = new JLabel("");
        labelName.setBounds(220, 170, 150, 25);
        add(labelName);
        
        //Adding 'Gender' label on frame
        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(30, 210, 150, 25);
        add(lblGender);
        
        //Adding a 'Male' Radio Button for Gender
        rMale = new JRadioButton("Male");
        rMale.setBounds(220, 210, 70, 25);
        rMale.setBackground(Color.WHITE);
        add(rMale);
        
        //Adding a 'Female' Radio Button for Gender
        rFemale = new JRadioButton("Female");
        rFemale.setBounds(300, 210, 70, 25);
        rFemale.setBackground(Color.WHITE);
        add(rFemale);
        
        //Grouping the radio buttoms
        ButtonGroup bg = new ButtonGroup();
        bg.add(rMale);
        bg.add(rFemale);
        
        //Adding 'Country' label on frame
        JLabel lblCountry = new JLabel("Country");
        lblCountry.setBounds(30, 250, 150, 25);
        add(lblCountry);
        
        //Adding text field for Country
        tfCountry = new JTextField();
        tfCountry.setBounds(220, 250, 150, 25);
        add(tfCountry);
        
        //Adding 'Address' label on frame
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(30, 290, 150, 25);
        add(lblAddress);
        
        //Adding text field for Address
        tfAddress = new JTextField();
        tfAddress.setBounds(220, 290, 150, 25);
        add(tfAddress);
        
        //Adding 'Phone' label on frame
        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(30, 330, 150, 25);
        add(lblPhone);
        
        //Adding text field for Phone
        tfPhone = new JTextField();
        tfPhone.setBounds(220, 330, 150, 25);
        add(tfPhone);
        
        //Adding 'Email' label on frame
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(30, 370, 150, 25);
        add(lblEmail);
        
        //Adding text field for Email
        tfEmail = new JTextField();
        tfEmail.setBounds(220, 370, 150, 25);
        add(tfEmail);
        
        //Adding 'Add' button
        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(70, 430, 100, 25);
        add.addActionListener(this);
        add(add);
        
        //Adding 'Back' button
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(220, 430, 100, 25);
        back.addActionListener(this);
        add(back);
        
        //Adding image on right side of frame 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 40, 450, 420);
        add(image);
        
        //Fetching the username and name field from database
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from account where username = '"+username+"'");
            while(rs.next()) {
                labelUsername.setText(rs.getString("username"));
                labelName.setText(rs.getString("name"));
            }
            
        }  catch (Exception e) {
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        //When add button clicked, add all the text field information to database
        if(ae.getSource() == add) {
            String username = labelUsername.getText();
            String id = (String) comboId.getSelectedItem();
            String number = tfNumber.getText();
            String name = labelName.getText();
            String gender = null;
            if (rMale.isSelected()) {
                gender = "Male";
            } else {
                gender = "Female";
            }
            String country = tfCountry.getText();
            String address = tfAddress.getText();
            String phone = tfPhone.getText();
            String email = tfEmail.getText();
            
            
            try {
                //Adding all the information to database
                Conn c = new Conn();
                String query = "insert into customer values('"+username+"', '"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+address+"', '"+phone+"', '"+email+"')";
                c.s.executeUpdate(query);
                
                //Creating a popup when query runs successfully
                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                setVisible(false);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        
        //When back button clicked, make the AddCustomer frame invisible    
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new AddCustomer("Komal");
    }
    
}
