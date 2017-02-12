
package main.domain;

/**
 *
 * @author Idorf
// */

public class User {


    Integer userID;
    Integer customerId;
    Integer userType;
    String firstName;
    String lastName;
    String email;
    Integer telephoneNo;

    
    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer customerType) {
        this.userType = customerType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(Integer telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

}
