package repository.database;

import domain.Customer;
import service.CustomerRepository;

import java.util.Collection;

public class MongoCustomerRepo implements CustomerRepository {
    @Override
    public Customer CreateCustomer(String customerName) {
        return null;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return null;
    }

    @Override
    public Customer findCustomer(String customerId) {
        return null;
    }

    @Override
    public Collection<Customer> allCustomers() {
        return null;
    }
}
