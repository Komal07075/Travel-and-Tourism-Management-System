
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class BookHotel extends JFrame implements ActionListener {
    
    Choice cHotel, cAc, cFood;
    JTextField tfPersons, tfDays;
    String username;
    JLabel labelUsername, labelId, labelNumber, labelPrice, labelPhone;
    JButton checkPrice, bookPackage, back;
    
    BookHotel(String username) {
        this.username = username;
        
        setBounds(350, 200, 1100, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("BOOK HOTEL");
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
        
        //Adding Select Hotel label on frame 
        JLabel lblPackage = new JLabel("Select Hotel");
        lblPackage.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblPackage.setBounds(40, 110, 150, 20);
        add(lblPackage);
        
        cHotel = new Choice();
        cHotel.setBounds(250, 110, 200, 20);
        add(cHotel);
        
        try {
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while(rs.next()) {
                cHotel.add(rs.getString("name"));
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        //Adding 'Total Persons' label on frame
        JLabel lblPersons = new JLabel("Total Persons");
        lblPersons.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblPersons.setBounds(40, 150, 150, 25);
        add(lblPersons);
        
        tfPersons = new JTextField("1");
        tfPersons.setBounds(250, 150, 200, 25);
        add(tfPersons);
        
        //Adding 'Number of Days' label on frame
        JLabel lblDays = new JLabel("Number of Days");
        lblDays.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblDays.setBounds(40, 190, 150, 25);
        add(lblDays);
        
        tfDays = new JTextField("1");
        tfDays.setBounds(250, 190, 200, 25);
        add(tfDays);
        
        //Adding 'Number of Days' label on frame
        JLabel lblAc = new JLabel("AC/ Non-AC");
        lblAc.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblAc.setBounds(40, 230, 150, 25);
        add(lblAc);
        
        cAc = new Choice();
        cAc.add("AC");
        cAc.add("Non-AC");
        cAc.setBounds(250, 230, 200, 20);
        add(cAc);
        
        //Adding 'Number of Days' label on frame
        JLabel lblFood = new JLabel("Food Included");
        lblFood.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblFood.setBounds(40, 270, 150, 25);
        add(lblFood);
        
        cFood = new Choice();
        cFood.add("Yes");
        cFood.add("No");
        cFood.setBounds(250, 270, 200, 20);
        add(cFood);
        
        //Adding ID label on frame
        JLabel lblId = new JLabel("ID");
        lblId.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblId.setBounds(40, 310, 150, 20);
        add(lblId);
        
        labelId = new JLabel();
        labelId.setBounds(250, 310, 200, 25);
        add(labelId);
        
        //Adding Number label on frame
        JLabel lblNumber = new JLabel("Number");
        lblNumber.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNumber.setBounds(40, 350, 150, 25);
        add(lblNumber);
        
        labelNumber = new JLabel();
        labelNumber.setBounds(250, 350, 150, 25);
        add(labelNumber);
        
        //Adding Phone label on frame
        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblPhone.setBounds(40, 390, 150, 20);
        add(lblPhone);
        
        labelPhone = new JLabel();
        labelPhone.setBounds(250, 390, 150, 25);
        add(labelPhone);
        
        //Adding 'Total Price' label on frame
        JLabel lblTotal = new JLabel("Total Price");
        lblTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTotal.setBounds(40, 430, 150, 25);
        add(lblTotal);
        
        labelPrice = new JLabel();
        labelPrice.setBounds(250, 430, 150, 25);
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
        checkPrice.setBounds(60, 490, 120, 25);
        checkPrice.addActionListener(this);
        add(checkPrice);
        
        bookPackage = new JButton("Book Hotel");
        bookPackage.setBackground(Color.BLACK);
        bookPackage.setForeground(Color.WHITE);
        bookPackage.setBounds(200, 490, 120, 25);
        bookPackage.addActionListener(this);
        add(bookPackage);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340, 490, 120, 25);
        back.addActionListener(this);
        add(back);
        
        //Adding image on panel 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(500, 50, 600, 300);
        add(l12);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == checkPrice) {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotel where name = '" + cHotel.getSelectedItem() + "'");
                while (rs.next()) {
                    int cost = Integer.parseInt(rs.getString("costPerPerson"));
                    int food = Integer.parseInt(rs.getString("foodIncluded"));
                    int ac = Integer.parseInt(rs.getString("acRoom"));

                    int persons = Integer.parseInt(tfPersons.getText());
                    int days = Integer.parseInt(tfDays.getText());

                    String acSelected = cAc.getSelectedItem();
                    String foodSelected = cFood.getSelectedItem();

                    if (persons * days > 0) {
                        int total = 0;
                        total += acSelected.equals("AC") ? ac : 0;
                        total += foodSelected.equals("Yes") ? food : 0;
                        total += cost;
                        total = total * persons * days;
                        labelPrice.setText("Rs " + total);

                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if(ae.getSource() == bookPackage) {
            
            try {
                
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookHotel values('"+labelUsername.getText()+"', '"+cHotel.getSelectedItem()+"', '"+tfPersons.getText()+"', '"+tfDays.getText()+"', '"+cAc.getSelectedItem()+"', '"+cFood.getSelectedItem()+"', '"+labelId.getText()+"', '"+labelNumber.getText()+"', '"+labelPhone.getText()+"', '"+labelPrice.getText()+"')");
                
                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                setVisible(false);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        
        new BookHotel("Komal");
    }
}
