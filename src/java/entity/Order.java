/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author nguye
 */
public class Order {

    private int OrderID;
    private String CustomerID;
    private int EmployeeID;
    private String OrderDate, RequiredDate, ShippedDate;
    private int ShipVia;
    private double Freight;
    private String ShipName, ShipAddress, ShipCity, ShipRegion, ShipPostalCode, ShipCountry;
    private int OrderStatus;

    public Order() {
    }

    public Order(String CustomerID, int EmployeeID, String OrderDate, String RequiredDate, String ShippedDate, int ShipVia, double Freight, String ShipName, String ShipAddress, String ShipCity, String ShipRegion, String ShipPostalCode, String ShipCountry, int OrderStatus) {
        this.CustomerID = CustomerID;
        this.EmployeeID = EmployeeID;
        this.OrderDate = OrderDate;
        this.RequiredDate = RequiredDate;
        this.ShippedDate = ShippedDate;
        this.ShipVia = ShipVia;
        this.Freight = Freight;
        this.ShipName = ShipName;
        this.ShipAddress = ShipAddress;
        this.ShipCity = ShipCity;
        this.ShipRegion = ShipRegion;
        this.ShipPostalCode = ShipPostalCode;
        this.ShipCountry = ShipCountry;
        this.OrderStatus = OrderStatus;
    }

    public Order(int OrderID, String CustomerID, int EmployeeID, String OrderDate, String RequiredDate, String ShippedDate, int ShipVia, double Freight, String ShipName, String ShipAddress, String ShipCity, String ShipRegion, String ShipPostalCode, String ShipCountry, int OrderStatus) {
        this.OrderID = OrderID;
        this.CustomerID = CustomerID;
        this.EmployeeID = EmployeeID;
        this.OrderDate = OrderDate;
        this.RequiredDate = RequiredDate;
        this.ShippedDate = ShippedDate;
        this.ShipVia = ShipVia;
        this.Freight = Freight;
        this.ShipName = ShipName;
        this.ShipAddress = ShipAddress;
        this.ShipCity = ShipCity;
        this.ShipRegion = ShipRegion;
        this.ShipPostalCode = ShipPostalCode;
        this.ShipCountry = ShipCountry;
        this.OrderStatus = OrderStatus;
    }
    

    public int getOrderID() {
        return OrderID;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public String getRequiredDate() {
        return RequiredDate;
    }

    public String getShippedDate() {
        return ShippedDate;
    }

    public int getShipVia() {
        return ShipVia;
    }

    public double getFreight() {
        return Freight;
    }

    public String getShipName() {
        return ShipName;
    }

    public String getShipAddress() {
        return ShipAddress;
    }

    public String getShipCity() {
        return ShipCity;
    }

    public String getShipRegion() {
        return ShipRegion;
    }

    public String getShipPostalCode() {
        return ShipPostalCode;
    }

    public String getShipCountry() {
        return ShipCountry;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    public void setRequiredDate(String RequiredDate) {
        this.RequiredDate = RequiredDate;
    }

    public void setShippedDate(String ShippedDate) {
        this.ShippedDate = ShippedDate;
    }

    public void setShipVia(int ShipVia) {
        this.ShipVia = ShipVia;
    }

    public void setFreight(double Freight) {
        this.Freight = Freight;
    }

    public void setShipName(String ShipName) {
        this.ShipName = ShipName;
    }

    public void setShipAddress(String ShipAddress) {
        this.ShipAddress = ShipAddress;
    }

    public void setShipCity(String ShipCity) {
        this.ShipCity = ShipCity;
    }

    public void setShipRegion(String ShipRegion) {
        this.ShipRegion = ShipRegion;
    }

    public void setShipPostalCode(String ShipPostalCode) {
        this.ShipPostalCode = ShipPostalCode;
    }

    public void setShipCountry(String ShipCountry) {
        this.ShipCountry = ShipCountry;
    }

    public int getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(int OrderStatus) {
        this.OrderStatus = OrderStatus;
    }

    @Override
    public String toString() {
        return "Order{" + "OrderID=" + OrderID + ", CustomerID=" + CustomerID + ", EmployeeID=" + EmployeeID + ", OrderDate=" + OrderDate + ", RequiredDate=" + RequiredDate + ", ShippedDate=" + ShippedDate + ", ShipVia=" + ShipVia + ", Freight=" + Freight + ", ShipName=" + ShipName + ", ShipAddress=" + ShipAddress + ", ShipCity=" + ShipCity + ", ShipRegion=" + ShipRegion + ", ShipPostalCode=" + ShipPostalCode + ", ShipCountry=" + ShipCountry + ", OrderStatus=" + OrderStatus + '}';
    }

    
    

    

}
