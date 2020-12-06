package Db_Connection;

import Logic.Register_Form;
import static UserInterfaces.Cart.jLabel2;
import static UserInterfaces.Cart.jTable1;
import UserInterfaces.Userlogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nur_Islam
 */
public class Cart implements BasicTablefillup{
    public String mname,power,company,price,quantity;

    public Cart(){}
    
    public Cart(String mname, String power, String company, String price, String quantity) {
        this.mname = mname;
        this.power = power;
        this.company = company;
        this.price = price;
        this.quantity = quantity;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    
    
    public static int tprice=0;
    public static int fillTable(){
        tprice =0;
        jTable1.setModel(new DefaultTableModel(null,new Object[]{"Medicine","Power","Quantity"," Total Price "}));
        PreparedStatement st;
        ResultSet rs;
        String query = "SELECT `mname`, `power`, `price`, `quantity` FROM `cart` WHERE `uid` = ?" ;
                
        try {
            st = My_CNX.getConnection().prepareStatement(query);
            st.setString(1,Userlogin.uid.toString());
            rs = st.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            
            Object [] row;
            while(rs.next()){
                row = new Object[4];
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(4);
                row[3] = rs.getInt(3);
                tprice += Integer.parseInt(rs.getString(3));
                model.addRow(row);
            }
            return tprice;
                    
        } catch (SQLException ex) {
            Logger.getLogger(Register_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tprice;
    }
}
