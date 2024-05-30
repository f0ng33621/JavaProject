package service;

import domain.Customer;

import java.util.Collection;

public interface CustomerRepository {
    public Customer CreateCustomer(String customerName);
    public Customer updateCustomer(Customer customer);
    public Customer findCustomer(String customerId);
    public Collection<Customer> allCustomers();

}
