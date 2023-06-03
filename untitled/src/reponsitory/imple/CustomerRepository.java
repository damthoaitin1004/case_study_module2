package reponsitory.imple;

import model.person.Customer;
import model.person.Employee;
import reponsitory.ICustomerRepository;
import untils.common.WriteAndReadFilePerson;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static List<Customer> customerList = new ArrayList<>();
    private static  String CUSTOMER_PATH = "untitled/src/untils/data/employee.csv";

    @Override
    public void removeCustomer(Customer person) {
        customerList = getCustomer();
        customerList.remove(person);
        List<String> strings = new ArrayList<>();
        for (Customer customer : customerList) {
            strings.add(customer.getCodePerson() + "," + customer.getNamePerson() + "," + customer.getDateOfBirth() + "," + customer.isGender() + "," + customer.getIdentityCard() + "," + customer.getPhoneNumber() + "," + customer.getEmail() + "," + customer.getCustomerType() + "," + customer.getAddress());
        }
        WriteAndReadFilePerson.writeFile(CUSTOMER_PATH, strings, false);
    }

    @Override
    public void addCustomer(Customer person) {
        List<String> stringList = new ArrayList<>();
        stringList.add(person.getCodePerson() + "," + person.getNamePerson() + "," + person.getDateOfBirth() + "," + person.isGender() + "," + person.getIdentityCard() + "," + person.getPhoneNumber() + "," + person.getEmail() + "," + person.getCustomerType() + "," + person.getAddress());
        WriteAndReadFilePerson.writeFile(CUSTOMER_PATH, stringList, true);
    }

    //(String codePerson, String namePerson, String dateOfBirth, String gender, String identityCard, String phoneNumber, String email, String customerType, String address
    @Override
    public List<Customer> getCustomer() {
        customerList.clear();
        List<String> stringList = WriteAndReadFilePerson.readFile(CUSTOMER_PATH);
        String[] info;
        for (String s : stringList) {
            info = s.split(",");
            customerList.add(new Customer(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7], info[8]));
        }
        return customerList;

    }

    @Override
    public void editCustomer() {
        customerList = getCustomer();
    }

    @Override
    public Customer getByCode(String code) {
            customerList = getCustomer();
            for (Customer person : customerList) {
                if (person.getCodePerson().equals(code)) {
                    return person;
                }
            }
            return null;
    }

    @Override
    public void editUpFile() {
        List<String> string = new ArrayList<>();
        for (Customer e : customerList) {
            string.add(e.getCodePerson() + "," + e.getNamePerson() + "," + e.getDateOfBirth() + "," + e.isGender() + "," + e.getIdentityCard() + "," + e.getPhoneNumber() + "," + e.getEmail() + "," + e.getCustomerType() + "," + e.getAddress());
        }
        WriteAndReadFilePerson.writeFile(CUSTOMER_PATH, string, false);
    }

    @Override
    public List<Customer> searchCustomer(String name) {
        List<Customer> customerSearch = new ArrayList<>();
        customerList = getCustomer();
        for (Customer c : customerList) {
            if (c.getNamePerson().toLowerCase().contains(name.toLowerCase())) {
                customerSearch.add(c);
            }
        }
        return customerSearch;
    }
}
