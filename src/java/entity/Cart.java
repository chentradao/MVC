/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author nguye
 */
public class Cart {
    private int ProductID;
    private String ProductName;
    private double UnitPrice;
    private int Quantity;
    private double Discount;

    public Cart() {
    }

    public Cart(int ProductID, String ProductName, double UnitPrice, int Quantity, double Discount) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.UnitPrice = UnitPrice;
        this.Quantity = Quantity;
        this.Discount = Discount;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
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

    @Override
    public String toString() {
        return "Cart{" + "ProductID=" + ProductID + ", ProductName=" + ProductName + ", UnitPrice=" + UnitPrice + ", Quantity=" + Quantity + ", Discount=" + Discount + '}';
    }
    
}
