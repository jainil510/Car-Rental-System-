/**
 * @author Jainil Ulhas Patil
 * @github github.com/jainil510
 */

package com;

/**
 * Represents a customer in the car rental system.
 */
public class Customer {
    private String customerId;
    private String name;
    private String mobileNumber;
    private String email;

    /**
     * Constructs a new Customer object.
     *
     * @param customerId   The unique ID of the customer.
     * @param name         The name of the customer.
     * @param mobileNumber The mobile number of the customer.
     * @param email        The email address of the customer.
     */
    public Customer(String customerId, String name, String mobileNumber, String email) {
        this.customerId = customerId;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
