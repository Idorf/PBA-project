
package main.domain;

/**
 *
 * @author Idorf
// */

public class Customer {


    private Integer customerId;
    private Integer customerType;
    private String customerName;
    private String city;
    private String addressLine1StreetName;
    private String addressLine2StreetNo;
    private String addressLine3BuildingNo;
    private Integer zipcode;
    private String otherAdressDetails;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }


    public Integer getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Integer customerType) {
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressLine1StreetName() {
        return addressLine1StreetName;
    }

    public void setAddressLine1StreetName(String addressLine1StreetName) {
        this.addressLine1StreetName = addressLine1StreetName;
    }

    public String getAddressLine2StreetNo() {
        return addressLine2StreetNo;
    }

    public void setAddressLine2StreetNo(String addressLine2StreetNo) {
        this.addressLine2StreetNo = addressLine2StreetNo;
    }

    public String getAddressLine3BuildingNo() {
        return addressLine3BuildingNo;
    }

    public void setAddressLine3BuildingNo(String addressLine3BuildingNo) {
        this.addressLine3BuildingNo = addressLine3BuildingNo;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public String getOtherAdressDetails() {
        return otherAdressDetails;
    }

    public void setOtherAdressDetails(String otherAdressDetails) {
        this.otherAdressDetails = otherAdressDetails;
    }

}
