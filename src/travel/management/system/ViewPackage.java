
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewPackage extends JFrame implements ActionListener {
    
    JButton back;
    
    ViewPackage(String username) {
        
        //Adding a frame
        setBounds(450, 200, 900, 450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("VIEW PACKAGE DETAILS");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(60, 0, 300, 30);
        add(text);
        
        //Adding Username label on frame
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(30, 50, 150, 25);
        add(lblUsername);
        
        JLabel labelUsername = new JLabel();
        labelUsername.setBounds(220, 50, 150, 25);
        add(labelUsername);
        
        //Adding Package label on frame 
        JLabel lblPackage = new JLabel("Package");
        lblPackage.setBounds(30, 90, 150, 25);
        add(lblPackage);
        
        JLabel labelPackage = new JLabel();
        labelPackage.setBounds(220, 90, 150, 25);
        add(labelPackage);
        
        //Adding Total Persons label on frame
        JLabel lblPersons = new JLabel("Total Persons");
        lblPersons.setBounds(30, 130, 150, 25);
        add(lblPersons);
        
        JLabel labelPersons = new JLabel();
        labelPersons.setBounds(220, 130, 150, 25);
        add(labelPersons);
        
        //Adding ID label on frame
        JLabel lblId = new JLabel("ID");
        lblId.setBounds(30, 170, 150, 25);
        add(lblId);
        
        JLabel labelId = new JLabel();
        labelId.setBounds(220, 170, 150, 25);
        add(labelId);
        
        //Adding Number label on frame
        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(30, 210, 150, 25);
        add(lblNumber);
        
        JLabel labelNumber = new JLabel();
        labelNumber.setBounds(220, 210, 150, 25);
        add(labelNumber);
        
        //Adding Phone label on frame
        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(30, 250, 150, 25);
        add(lblPhone);
        
        JLabel labelPhone = new JLabel();
        labelPhone.setBounds(220, 250, 150, 25);
        add(labelPhone);
        
        //Adding Price label on frame
        JLabel lblPrice = new JLabel("Price");
        lblPrice.setBounds(30, 290, 150, 25);
        add(lblPrice);
        
        //Adding price label
        JLabel labelPrice = new JLabel();
        labelPrice.setBounds(220, 290, 150, 25);
        add(labelPrice);
        
        //Adding Back button on frame
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130, 360, 100, 25);
        back.addActionListener(this);
        add(back);
        
        //Adding image on frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 20, 500, 400);
        add(image);
        
        try {
            
            //Fetching data from database
            Conn conn = new Conn();
            String query = "select * from bookPackage where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()) {
                labelUsername.setText(rs.getString("Username"));
                labelId.setText(rs.getString("ID"));
                labelNumber.setText(rs.getString("Number"));
                labelPackage.setText(rs.getString("Package"));
                labelPrice.setText(rs.getString("Price"));
                labelPhone.setText(rs.getString("Phone"));
                labelPersons.setText(rs.getString("Persons"));
                }
        } catch (Exception e) {
            
        }
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }
    
    public static void main(String[] args) {
        new ViewPackage("Komal");
    }
    
}
