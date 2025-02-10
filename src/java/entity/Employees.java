/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author nguye
 */
public class Employees {

    private int EmployeeID;
    private String LastName, FirstName, Title, TitleOfCourtesy, BirthDate, HireDate;
    private String Address, City, Region, PostalCode, Country, HomePhone, Extension, Photo, Notes;
    private int ReportsTo;
    private String PhotoPath;
    private int EmployeeStatus;

    public Employees() {
    }

    public Employees(String LastName, String FirstName, String Title, String TitleOfCourtesy, String BirthDate, String HireDate, String Address, String City, String Region, String PostalCode, String Country, String HomePhone, String Extension, String Photo, String Notes, int ReportsTo, String PhotoPath, int EmployeeStatus) {
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.Title = Title;
        this.TitleOfCourtesy = TitleOfCourtesy;
        this.BirthDate = BirthDate;
        this.HireDate = HireDate;
        this.Address = Address;
        this.City = City;
        this.Region = Region;
        this.PostalCode = PostalCode;
        this.Country = Country;
        this.HomePhone = HomePhone;
        this.Extension = Extension;
        this.Photo = Photo;
        this.Notes = Notes;
        this.ReportsTo = ReportsTo;
        this.PhotoPath = PhotoPath;
        this.EmployeeStatus = EmployeeStatus;
    }

    public Employees(int EmployeeID, String LastName, String FirstName, String Title, String TitleOfCourtesy,
            String BirthDate, String HireDate, String Address, String City, String Region,
            String PostalCode, String Country, String HomePhone, String Extension, String Photo, 
            String Notes, int ReportsTo, String PhotoPath, int EmployeeStatus) {
        this.EmployeeID = EmployeeID;
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.Title = Title;
        this.TitleOfCourtesy = TitleOfCourtesy;
        this.BirthDate = BirthDate;
        this.HireDate = HireDate;
        this.Address = Address;
        this.City = City;
        this.Region = Region;
        this.PostalCode = PostalCode;
        this.Country = Country;
        this.HomePhone = HomePhone;
        this.Extension = Extension;
        this.Photo = Photo;
        this.Notes = Notes;
        this.ReportsTo = ReportsTo;
        this.PhotoPath = PhotoPath;
        this.EmployeeStatus = EmployeeStatus;
    }

    public int getEmployeeStatus() {
        return EmployeeStatus;
    }

    public void setEmployeeStatus(int EmployeeStatus) {
        this.EmployeeStatus = EmployeeStatus;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public String getLastName() {
        return LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getTitle() {
        return Title;
    }

    public String getTitleOfCourtesy() {
        return TitleOfCourtesy;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public String getHireDate() {
        return HireDate;
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

    public String getHomePhone() {
        return HomePhone;
    }

    public String getExtension() {
        return Extension;
    }

    public String getPhoto() {
        return Photo;
    }

    public String getNotes() {
        return Notes;
    }

    public int getReportsTo() {
        return ReportsTo;
    }

    public String getPhotoPath() {
        return PhotoPath;
    }

    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setTitleOfCourtesy(String TitleOfCourtesy) {
        this.TitleOfCourtesy = TitleOfCourtesy;
    }

    public void setBirthDate(String BirthDate) {
        this.BirthDate = BirthDate;
    }

    public void setHireDate(String HireDate) {
        this.HireDate = HireDate;
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

    public void setHomePhone(String HomePhone) {
        this.HomePhone = HomePhone;
    }

    public void setExtension(String Extension) {
        this.Extension = Extension;
    }

    public void setPhoto(String Photo) {
        this.Photo = Photo;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
    }

    public void setReportsTo(int ReportsTo) {
        this.ReportsTo = ReportsTo;
    }

    public void setPhotoPath(String PhotoPath) {
        this.PhotoPath = PhotoPath;
    }

    @Override
    public String toString() {
        return "Employees{" + "EmployeeID=" + EmployeeID + ", LastName=" + LastName + ", FirstName=" + FirstName + ", Title=" + Title + ", TitleOfCourtesy=" + TitleOfCourtesy + ", BirthDate=" + BirthDate + ", HireDate=" + HireDate + ", Address=" + Address + ", City=" + City + ", Region=" + Region + ", PostalCode=" + PostalCode + ", Country=" + Country + ", HomePhone=" + HomePhone + ", Extension=" + Extension + ", Photo=" + Photo + ", Notes=" + Notes + ", ReportsTo=" + ReportsTo + ", PhotoPath=" + PhotoPath + ", EmployeeStatus=" + EmployeeStatus + '}';
    }





}
