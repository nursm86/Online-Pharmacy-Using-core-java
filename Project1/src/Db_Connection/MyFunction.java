/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db_Connection;

import Db_Connection.My_CNX;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nur_Islam
 */
public class MyFunction {
    
    public static int countData(String tableName){
        PreparedStatement st;
        ResultSet rs;
       
        
        String query = "SELECT COUNT(*) FROM "+tableName+"";
        int total=0;
     
        try {
            st =My_CNX.getConnection().prepareStatement(query);
            //st.setString(1,tableName);
            
            rs = st.executeQuery();
            
            while(rs.next()){
                total = rs.getInt(1);
            }
        } catch(SQLException ex) {
            Logger.getLogger(MyFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
            
}
