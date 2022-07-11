
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class BookPackage extends JFrame implements ActionListener {
    
    Choice cPackage;
    JTextField tfPersons;
    String username;
    JLabel labelUsername, labelId, labelNumber, labelPrice, labelPhone;
    JButton checkPrice, bookPackage, back;
    
    BookPackage(String username) {
        this.username = username;
        
        setBounds(350, 200, 1100, 500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);
        
        //Adding Username label on frame
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblUsername.setBounds(40, 70, 100, 20);
        add(lblUsername);
        
        labelUsername = new JLabel();
        labelUsername.setBounds(250, 70, 200, 20);
        add(labelUsername);
        
        //Adding ID label on frame 
        JLabel lblPackage = new JLabel("Select Package");
        lblPackage.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblPackage.setBounds(40, 110, 150, 20);
        add(lblPackage);
        
        cPackage = new Choice();
        cPackage.add("Gold Package");
        cPackage.add("Silver Package");
        cPackage.add("Bronze Package");
        cPackage.setBounds(250, 110, 200, 20);
        add(cPackage);
        
        //Adding Number label on frame
        JLabel lblPersons = new JLabel("Total Persons");
        lblPersons.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblPersons.setBounds(40, 150, 150, 25);
        add(lblPersons);
        
        tfPersons = new JTextField("1");
        tfPersons.setBounds(250, 150, 200, 25);
        add(tfPersons);
        
        //Adding Name label on frame
        JLabel lblId = new JLabel("ID");
        lblId.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblId.setBounds(40, 190, 150, 20);
        add(lblId);
        
        labelId = new JLabel();
        labelId.setBounds(250, 190, 200, 25);
        add(labelId);
        
        //Adding Gender label on frame
        JLabel lblNumber = new JLabel("Number");
        lblNumber.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNumber.setBounds(40, 230, 150, 25);
        add(lblNumber);
        
        labelNumber = new JLabel();
        labelNumber.setBounds(250, 230, 150, 25);
        add(labelNumber);
        
        //Adding Country label on frame
        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblPhone.setBounds(40, 270, 150, 20);
        add(lblPhone);
        
        labelPhone = new JLabel();
        labelPhone.setBounds(250, 270, 150, 25);
        add(labelPhone);
        
        //Adding Gender label on frame
        JLabel lblTotal = new JLabel("Total Price");
        lblTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTotal.setBounds(40, 310, 150, 25);
        add(lblTotal);
        
        labelPrice = new JLabel();
        labelPrice.setBounds(250, 310, 150, 25);
        add(labelPrice);
        
        try {
            
            //Fetching data from database
            Conn conn = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()) {
                labelUsername.setText(rs.getString("username"));
                labelId.setText(rs.getString("ID"));
                labelNumber.setText(rs.getString("Number"));
                labelPhone.setText(rs.getString("Phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        checkPrice = new JButton("Check Price");
        checkPrice.setBackground(Color.BLACK);
        checkPrice.setForeground(Color.WHITE);
        checkPrice.setBounds(60, 380, 120, 25);
        checkPrice.addActionListener(this);
        add(checkPrice);
        
        bookPackage = new JButton("Book Package");
        bookPackage.setBackground(Color.BLACK);
        bookPackage.setForeground(Color.WHITE);
        bookPackage.setBounds(200, 380, 120, 25);
        bookPackage.addActionListener(this);
        add(bookPackage);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340, 380, 120, 25);
        back.addActionListener(this);
        add(back);
        
        //Adding image on panel 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(550, 50, 500, 300);
        add(l12);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == checkPrice) {
            String pack = cPackage.getSelectedItem();
            int cost = 0;
            if(pack.equals("Gold Package")) {
                cost += 12000;
            } else if(pack.equals("Silver Package")) {
                cost += 25000;
            } else {
                cost += 32000;
            }
            
            int persons = Integer.parseInt(tfPersons.getText());
            cost *= persons;
            labelPrice.setText("Rs " +cost);
            
        } else if(ae.getSource() == bookPackage) {
            
            try {
                
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookPackage values('"+labelUsername.getText()+"', '"+cPackage.getSelectedItem()+"', '"+tfPersons.getText()+"', '"+labelId.getText()+"', '"+labelNumber.getText()+"', '"+labelPhone.getText()+"', '"+labelPrice.getText()+"')");
                
                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                setVisible(false);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        
        new BookPackage("Komal");
    }
}
