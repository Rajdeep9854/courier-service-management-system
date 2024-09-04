package com.courier.model;

public class Customer {
    private int customerId;
    private String customerName;
    private String email;
    private String phoneNumber;

    // Getters and Setters
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }


    @Override
    public String toString() {
        return "Customer ID: " + customerId + "\n" +
                "Customer Name: " + customerName + "\n" +
                "Email: " + email + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "-----------------------------";
    }

}
