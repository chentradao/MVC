/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author nguye
 */
public class CustomerDemographic {
    	private String CustomerTypeID,CustomerDesc;
        private int DemographicStatus;

    public CustomerDemographic() {
    }

    public CustomerDemographic(String CustomerTypeID, String CustomerDesc, int DemographicStatus) {
        this.CustomerTypeID = CustomerTypeID;
        this.CustomerDesc = CustomerDesc;
        this.DemographicStatus = DemographicStatus;
    }


    public String getCustomerTypeID() {
        return CustomerTypeID;
    }

    public String getCustomerDesc() {
        return CustomerDesc;
    }

    public void setCustomerTypeID(String CustomerTypeID) {
        this.CustomerTypeID = CustomerTypeID;
    }

    public void setCustomerDesc(String CustomerDesc) {
        this.CustomerDesc = CustomerDesc;
    }

    public int getDemographicStatus() {
        return DemographicStatus;
    }

    public void setDemographicStatus(int DemographicStatus) {
        this.DemographicStatus = DemographicStatus;
    }

    @Override
    public String toString() {
        return "CustomerDemographic{" + "CustomerTypeID=" + CustomerTypeID + ", CustomerDesc=" + CustomerDesc + ", DemographicStatus=" + DemographicStatus + '}';
    }
    

    
        
}
