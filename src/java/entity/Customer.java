/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author nguye
 */
public class Customer {

    private String CustomerID, CompanyName, ContactName, ContactTitle, Address, City, Region, PostalCode, Country, Phone, Fax;
    private int CustomerStatus;

    public Customer() {
    }

    
    public Customer(String Phone, String Fax) {
        this.Phone = Phone;
        this.Fax = Fax;
    }

    public Customer(String CustomerID, String CompanyName, String ContactName, String ContactTitle, String Address, String City, String Region, String PostalCode, String Country, String Phone, String Fax, int CustomerStatus) {
        this.CustomerID = CustomerID;
        this.CompanyName = CompanyName;
        this.ContactName = ContactName;
        this.ContactTitle = ContactTitle;
        this.Address = Address;
        this.City = City;
        this.Region = Region;
        this.PostalCode = PostalCode;
        this.Country = Country;
        this.Phone = Phone;
        this.Fax = Fax;
        this.CustomerStatus = CustomerStatus;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public String getContactName() {
        return ContactName;
    }

    public String getContactTitle() {
        return ContactTitle;
    }

    public String getAddress() {
        return Address;
    }

    public String getCity() {
        return City;
    }

    public String getRegion() {
        return Region;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public String getCountry() {
        return Country;
    }

    public String getPhone() {
        return Phone;
    }

    public String getFax() {
        return Fax;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public void setContactName(String ContactName) {
        this.ContactName = ContactName;
    }

    public void setContactTitle(String ContactTitle) {
        this.ContactTitle = ContactTitle;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public void setPostalCode(String PostalCode) {
        this.PostalCode = PostalCode;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public void setFax(String Fax) {
        this.Fax = Fax;
    }

    public int getCustomerStatus() {
        return CustomerStatus;
    }

    public void setCustomerStatus(int CustomerStatus) {
        this.CustomerStatus = CustomerStatus;
    }

    @Override
    public String toString() {
        return "Customer{" + "CustomerID=" + CustomerID + ", CompanyName=" + CompanyName + ", ContactName=" + ContactName + ", ContactTitle=" + ContactTitle + ", Address=" + Address + ", City=" + City + ", Region=" + Region + ", PostalCode=" + PostalCode + ", Country=" + Country + ", Phone=" + Phone + ", Fax=" + Fax + ", CustomerStatus=" + CustomerStatus + '}';
    }

}
