/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db_Connection;

/**
 *
 * @author Nur_Islam
 */
public class MedicineInfo{
    public String mname,power,company,price,quantity;

    public MedicineInfo(){}
    
    public MedicineInfo(String mname, String power, String company, String price, String quantity) {
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
    
}
