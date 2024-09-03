package com.courier.service;

import com.courier.dao.CustomerDao;
import com.courier.model.Customer;

import java.util.List;

public class CustomerService {
    private CustomerDao customerDAO;

    public CustomerService() {
        customerDAO = new CustomerDao();
    }

    public void addCustomer(Customer customer) {
        customerDAO.addCustomer(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    public void updateCustomer(Customer customer) {
        customerDAO.updateCustomer(customer);
    }

    public void deleteCustomer(int customerId) {
        customerDAO.deleteCustomer(customerId);
    }
}
