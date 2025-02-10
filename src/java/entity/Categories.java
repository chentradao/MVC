/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author nguye
 */
public class Categories {

    private int CategoryID;
    private String CategoryName, Description, Picture;
    private int CategoryStatus;

    public Categories() {
    }

    public Categories(String CategoryName, String Description, String Picture, int CategoryStatus) {
        this.CategoryName = CategoryName;
        this.Description = Description;
        this.Picture = Picture;
        this.CategoryStatus = CategoryStatus;
    }

    public Categories(int CategoryID, String CategoryName, String Description, String Picture, int CategoryStatus) {
        this.CategoryID = CategoryID;
        this.CategoryName = CategoryName;
        this.Description = Description;
        this.Picture = Picture;
        this.CategoryStatus = CategoryStatus;
    }


    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int CategoryID) {
        this.CategoryID = CategoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public String getDescription() {
        return Description;
    }

    public String getPicture() {
        return Picture;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setPicture(String Picture) {
        this.Picture = Picture;
    }

    public int getCategoryStatus() {
        return CategoryStatus;
    }

    public void setCategoryStatus(int CategoryStatus) {
        this.CategoryStatus = CategoryStatus;
    }

    @Override
    public String toString() {
        return "Categories{" + "CategoryID=" + CategoryID + ", CategoryName=" + CategoryName + ", Description=" + Description + ", Picture=" + Picture + ", CategoryStatus=" + CategoryStatus + '}';
    }
    
    

}
