/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db_Connection;

import Logic.Register_Form;
import UserInterfaces.Admin_Home;
import static UserInterfaces.User_Home.jTable2;
import UserInterfaces.Userlogin;
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
public class AdminInfo extends BasicInfo implements BasicTablefillup{

    public AdminInfo() {
    }

    public AdminInfo(String name, String age, String email, String id, String gender, String phone) {
        super(name, age, email, id, gender, phone);
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
        
        
        if(username.equals("Email") || password.equals("********")){
            JOptionPane.showMessageDialog(null, "One of more Field is Empty","Login Error",2);
            return; 
        }
        
        String query = "SELECT * FROM `admin` WHERE `email` = ? AND `password` = ?";
        
        try {
            st =My_CNX.getConnection().prepareStatement(query);
            
            st.setString(1, username);
            st.setString(2,password);
            
            rs = st.executeQuery();
            
            if(rs.next()){
                //show a new form
                Admin_Home ai = new Admin_Home();
                ai.setVisible(true);
                Admin_Home.jLabel2.setText("Total Sell = "+Integer.toString(MyFunction.countData("delivered"))+"");
                Admin_Home.jLabel3.setText("Pending Orders = "+Integer.toString(MyFunction.countData("requested"))+"");
                Admin_Home.jLabel5.setText("New Request = "+Integer.toString(MyFunction.countData("requ_medi"))+"");
                
            }else{
                //error message 
                JOptionPane.showMessageDialog(null, "Invalid Email / Password ","Login Error",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Userlogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}


