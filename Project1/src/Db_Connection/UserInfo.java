/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db_Connection;

import Db_Connection.BasicInfo;
import Db_Connection.BasicInfo;
import Db_Connection.My_CNX;
import Db_Connection.My_CNX;
import Logic.Register_Form;
import Logic.Register_Form;
import UserInterfaces.Admin_Home;
import UserInterfaces.User_Home;
import UserInterfaces.User_Home;
import UserInterfaces.User_Home;
import static UserInterfaces.User_Home.jTable2;
import UserInterfaces.Userlogin;
import UserInterfaces.Userlogin;
import UserInterfaces.Userlogin;
import static UserInterfaces.Userlogin.name;
import static UserInterfaces.Userlogin.pass;
import static UserInterfaces.Userlogin.uid;
import static UserInterfaces.Userlogin.uname;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nur_Islam
 */
public class UserInfo extends BasicInfo{
    
    public String sq;

    public UserInfo(){};
    
    public UserInfo(String sq) {
        this.sq = sq;
    }

    public UserInfo(String sq, String name, String age, String email, String id, String gender, String phone) {
        super(name, age, email, id, gender, phone);
        this.sq = sq;
    }
    
    public static void fillTable(){
        jTable2.setModel(new DefaultTableModel(null,new Object[]{"Medicine Name","Power","Company","Quantity","Price (per tab)"}));
        PreparedStatement st;
        ResultSet rs;
        String query = "SELECT `mname`, `power`, `company`, `quantity`, `price(per tab)` FROM `medicine`" ;
                
        try {
            st = My_CNX.getConnection().prepareStatement(query);
            rs = st.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
            
            Object [] row;
            while(rs.next()){
                row = new Object[5];
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getInt(4);
                row[4] = rs.getInt(5);
                
                model.addRow(row);
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(Register_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void getValue(String username,String password){
        PreparedStatement st;
        ResultSet rs;
        
        uname = username;
        pass = password;
        
        if(username.equals("Email or Phone_Number") || password.equals("********")){
            JOptionPane.showMessageDialog(null, "One of more Field is Empty","Login Error",2);
            return; 
        }
        String query = "SELECT * FROM `users` WHERE (`email` = ? OR `phone` = ?) AND password = ?";
        
        try {
            st =My_CNX.getConnection().prepareStatement(query);
            
            st.setString(1, username);
            st.setString(3,password);
            st.setString(2, username);
            
            rs = st.executeQuery();
            
            
            
            if(rs.next()){
                
                User_Home ui = new User_Home();
                ui.setVisible(true);
                
            }else{
                //error message 
                JOptionPane.showMessageDialog(null, "Invalid Email / Password ","Login Error",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Userlogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
}
