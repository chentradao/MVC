/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author nguye
 */
public class Bill {
    private int OrderID;
    private String OrderDate;
    private String RequiredDate;
    private String CustomerID;
    private String ContactName;
    private int EmployeeID;
    private String FirstName;
    private int ProductID;
    private String ProductName;
    private double UnitPrice;
    private int Quantity;
    private double Discount;

    public Bill(int OrderID, String OrderDate, String RequiredDate, String CustomerID, String ContactName, int EmployeeID, String FirstName, int ProductID, String ProductName, double UnitPrice, int Quantity, double Discount) {
        this.OrderID = OrderID;
        this.OrderDate = OrderDate;
        this.RequiredDate = RequiredDate;
        this.CustomerID = CustomerID;
        this.ContactName = ContactName;
        this.EmployeeID = EmployeeID;
        this.FirstName = FirstName;
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.UnitPrice = UnitPrice;
        this.Quantity = Quantity;
        this.Discount = Discount;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    public String getRequiredDate() {
        return RequiredDate;
    }

    public void setRequiredDate(String RequiredDate) {
        this.RequiredDate = RequiredDate;
    }


    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public double getDiscount() {
        return Discount;
    }

    public void setDiscount(double Discount) {
        this.Discount = Discount;
    }

    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String ContactName) {
        this.ContactName = ContactName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    @Override
    public String toString() {
        return "Bill{" + "OrderID=" + OrderID + ", OrderDate=" + OrderDate + ", RequiredDate=" + RequiredDate + ", CustomerID=" + CustomerID + ", ContactName=" + ContactName + ", EmployeeID=" + EmployeeID + ", FirstName=" + FirstName + ", ProductID=" + ProductID + ", ProductName=" + ProductName + ", UnitPrice=" + UnitPrice + ", Quantity=" + Quantity + ", Discount=" + Discount + '}';
    }

    
    

    
    
}
