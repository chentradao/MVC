/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author nguye
 */
public class Shipper {

    private int ShipperID;
    private String CompanyName, Phone;
    private int ShipperStatus;

    public Shipper() {
    }

    public Shipper(String CompanyName, String Phone, int ShipperStatus) {
        this.CompanyName = CompanyName;
        this.Phone = Phone;
        this.ShipperStatus = ShipperStatus;
    }

    public Shipper(int ShipperID, String CompanyName, String Phone, int ShipperStatus) {
        this.ShipperID = ShipperID;
        this.CompanyName = CompanyName;
        this.Phone = Phone;
        this.ShipperStatus = ShipperStatus;
    }

    public int getShipperStatus() {
        return ShipperStatus;
    }

    public void setShipperStatus(int ShipperStatus) {
        this.ShipperStatus = ShipperStatus;
    }

    public int getShipperID() {
        return ShipperID;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setShipperID(int ShipperID) {
        this.ShipperID = ShipperID;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    @Override
    public String toString() {
        return "Shipper{" + "ShipperID=" + ShipperID + ", CompanyName=" + CompanyName + ", Phone=" + Phone + ", ShipperStatus=" + ShipperStatus + '}';
    }

    

}
