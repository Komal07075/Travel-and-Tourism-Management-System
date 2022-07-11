
package travel.management.system;

import java.sql.*;

public class Conn {
    
    Connection c; //Instantiating Connection object
    
    Statement s; //Instantiating statement
    
    //Creating Constructor for Conn class
    Conn() {
        //Applying try and catch because mysql is an external entity
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //Initializing the driver
            
            //Establishing connection to mysql
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmanagementsystem", "root", "komal@2000");
            
            s = c.createStatement(); //Creating the statement
            
            
        } catch(Exception e) {
            e.printStackTrace(); //Printing the exception
        
        }
    }
}
