
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewCustomer extends JFrame implements ActionListener {
    
    JButton back;
    
    ViewCustomer(String username) {
        
        //Adding a frame
        setBounds(450, 180, 870, 625);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //Adding Username label on frame
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(30, 50, 150, 25);
        add(lblUsername);
        
        JLabel labelUsername = new JLabel();
        labelUsername.setBounds(220, 50, 150, 25);
        add(labelUsername);
        
        //Adding ID label on frame 
        JLabel lblId = new JLabel("ID");
        lblId.setBounds(30, 110, 150, 25);
        add(lblId);
        
        JLabel labelId = new JLabel();
        labelId.setBounds(220, 110, 150, 25);
        add(labelId);
        
        //Adding Number label on frame
        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(30, 170, 150, 25);
        add(lblNumber);
        
        JLabel labelNumber = new JLabel();
        labelNumber.setBounds(220, 170, 150, 25);
        add(labelNumber);
        
        //Adding Name label on frame
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(30, 230, 150, 25);
        add(lblName);
        
        JLabel labelName = new JLabel();
        labelName.setBounds(220, 230, 150, 25);
        add(labelName);
        
        //Adding Gender label on frame
        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(30, 290, 150, 25);
        add(lblGender);
        
        JLabel labelGender = new JLabel();
        labelGender.setBounds(220, 290, 150, 25);
        add(labelGender);
        
        //Adding Country label on frame
        JLabel lblCountry = new JLabel("Country");
        lblCountry.setBounds(500, 50, 150, 25);
        add(lblCountry);
        
        JLabel labelCountry = new JLabel();
        labelCountry.setBounds(690, 50, 150, 25);
        add(labelCountry);
        
        //Adding Address label on frame
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(500, 110, 150, 25);
        add(lblAddress);
        
        JLabel labelAddress = new JLabel();
        labelAddress.setBounds(690, 110, 150, 25);
        add(labelAddress);
        
        //Adding Phone label on frame
        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(500, 170, 150, 25);
        add(lblPhone);
        
        JLabel labelPhone = new JLabel();
        labelPhone.setBounds(690, 170, 150, 25);
        add(labelPhone);
        
        //Adding Email label on frame
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(500, 230, 150, 25);
        add(lblEmail);
        
        JLabel labelEmail = new JLabel();
        labelEmail.setBounds(690, 230, 150, 25);
        add(labelEmail);
        
        //Adding Back button on frame
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(350, 350, 100, 25);
        back.addActionListener(this);
        add(back);
        
        //Adding image on frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20, 400, 600, 200);
        add(image);
        
        //Adding duplicate image on frame
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(600, 400, 600, 200);
        add(image2);
        
        try {
            
            //Fetching data from database
            Conn conn = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()) {
                labelUsername.setText(rs.getString("username"));
                labelId.setText(rs.getString("ID"));
                labelNumber.setText(rs.getString("Number"));
                labelName.setText(rs.getString("Name"));
                labelGender.setText(rs.getString("Gender"));
                labelCountry.setText(rs.getString("Country"));
                labelAddress.setText(rs.getString("Address"));
                labelPhone.setText(rs.getString("Phone"));
                labelEmail.setText(rs.getString("Email"));
                }
        } catch (Exception e) {
            
        }
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }
    
    public static void main(String[] args) {
        new ViewCustomer("Komal");
    }
    
}
