
package travel.management.system;


import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCustomer extends JFrame implements ActionListener {
    
    JLabel labelUsername, labelName;
    JComboBox comboId;
    JTextField tfNumber, tfAddress, tfCountry, tfEmail, tfPhone, tfId, tfGender;
    JRadioButton rMale, rFemale;
    JButton update, back;
    
    UpdateCustomer(String username) {
        //Adding frame
        setBounds(500, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        //Adding 'UPDATE CUSTOMER DETAILS' label on frame
        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(50, 0, 300, 25);
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(text);
        
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
        
        //Adding text field for ID
        tfId = new JTextField();
        tfId.setBounds(220, 90, 150, 25);
        add(tfId);
        
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
        
        //Adding text field for Gender
        tfGender = new JTextField();
        tfGender.setBounds(220, 210, 150, 25);
        add(tfGender);
        
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
        
        //Adding 'Update' button
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(70, 430, 100, 25);
        update.addActionListener(this);
        add(update);
        
        //Adding 'Back' button
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(220, 430, 100, 25);
        back.addActionListener(this);
        add(back);
        
        //Adding image on right side of frame 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 100, 450, 300);
        add(image);
        
        //Fetching the all imformation from database
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
            while(rs.next()) {
                labelUsername.setText(rs.getString("username"));
                labelName.setText(rs.getString("name"));
                tfId.setText(rs.getString("ID"));
                tfNumber.setText(rs.getString("Number"));
                tfGender.setText(rs.getString("Gender"));
                tfCountry.setText(rs.getString("Country"));
                tfAddress.setText(rs.getString("Address"));
                tfPhone.setText(rs.getString("Phone"));
                tfEmail.setText(rs.getString("Email"));
                
            }
            
        }  catch (Exception e) {
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        //When update button clicked, update all the text field information in database
        if(ae.getSource() == update) {
            String username = labelUsername.getText();
            String id = tfId.getText();
            String number = tfNumber.getText();
            String name = labelName.getText();
            String gender = tfGender.getText();
            String country = tfCountry.getText();
            String address = tfAddress.getText();
            String phone = tfPhone.getText();
            String email = tfEmail.getText();
            
            
            try {
                //Updating all the information in database
                Conn c = new Conn();
                String query = "update customer set username = '"+username+"', id = '"+id+"', number = '"+number+"', name = '"+name+"',gender = '"+gender+"',country = '"+country+"', address = '"+address+"', phone = '"+phone+"',email = '"+email+"'";
                c.s.executeUpdate(query);
                
                //Creating a popup when query runs successfully
                JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
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
        new UpdateCustomer("Komal");
    }
    
}
