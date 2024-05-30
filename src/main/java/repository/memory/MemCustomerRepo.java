package repository.memory;

import domain.Customer;
import service.CustomerRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemCustomerRepo implements CustomerRepository {
    private static long nextCustomerId = 0;
    private final Map<String,Customer> repo = new HashMap<>();
    @Override
    public Customer CreateCustomer(String customerName) {
        String customerId = "C" + ++nextCustomerId;
        Customer c = new Customer(customerId,customerName);
        if (repo.putIfAbsent(customerId, c) == null) return c;
        return null;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        try {
            repo.replace(customer.getId(),customer);
        }catch (Exception e){
            return null;
        }
        return customer;
    }

    @Override
    public Customer findCustomer(String customerId) {
        return repo.get(customerId);
    }

    @Override
    public Collection<Customer> allCustomers() {
        return repo.values();
    }
}
