package reponsitory;

import model.person.Customer;
import model.person.Employee;

import java.util.List;

public interface ICustomerRepository {
    void removeCustomer(Customer person);
    void addCustomer(Customer person);
    List<Customer> getCustomer();
    void editCustomer();
    Customer getByCode(String code);
     void editUpFile();
    List<Customer> searchCustomer(String name);
}
