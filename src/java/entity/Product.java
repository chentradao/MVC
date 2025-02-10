/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author nguye
 */
public class Product {
    private int ProductID ;
    private String ProductName ;
    private int SupplierID,CategoryID;
    private String QuantityPerUnit;
    private double UnitPrice;
    private int UnitsInStock, UnitsOnOrder, ReorderLevel;
    private boolean Discontinued;

    public Product(String ProductName, int SupplierID, int CategoryID, String QuantityPerUnit, double UnitPrice, int UnitsInStock, int UnitsOnOrder, int ReorderLevel, boolean Discontinued) {
        this.ProductName = ProductName;
        this.SupplierID = SupplierID;
        this.CategoryID = CategoryID;
        this.QuantityPerUnit = QuantityPerUnit;
        this.UnitPrice = UnitPrice;
        this.UnitsInStock = UnitsInStock;
        this.UnitsOnOrder = UnitsOnOrder;
        this.ReorderLevel = ReorderLevel;
        this.Discontinued = Discontinued;
    }
     

    public Product(int ProductID, String ProductName, int SupplierID, int CategoryID, String QuantityPerUnit, double UnitPrice, int UnitsInStock, int UnitsOnOrder, int ReorderLevel, boolean Discontinued) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.SupplierID = SupplierID;
        this.CategoryID = CategoryID;
        this.QuantityPerUnit = QuantityPerUnit;
        this.UnitPrice = UnitPrice;
        this.UnitsInStock = UnitsInStock;
        this.UnitsOnOrder = UnitsOnOrder;
        this.ReorderLevel = ReorderLevel;
        this.Discontinued = Discontinued;
    }

    public int getProductID() {
        return ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public int getSupplierID() {
        return SupplierID;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public String getQuantityPerUnit() {
        return QuantityPerUnit;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public int getUnitsInStock() {
        return UnitsInStock;
    }

    public int getUnitsOnOrder() {
        return UnitsOnOrder;
    }

    public int getReorderLevel() {
        return ReorderLevel;
    }

    public boolean isDiscontinued() {
        return Discontinued;
    }

    @Override
    public String toString() {
        return "Product{" + "ProductID=" + ProductID + ", ProductName=" + ProductName + ", SupplierID=" + SupplierID + ", CategoryID=" + CategoryID + ", QuantityPerUnit=" + QuantityPerUnit + ", UnitPrice=" + UnitPrice + ", UnitsInStock=" + UnitsInStock + ", UnitsOnOrder=" + UnitsOnOrder + ", ReorderLevel=" + ReorderLevel + ", Discontinued=" + Discontinued + '}';
    }
      
}
