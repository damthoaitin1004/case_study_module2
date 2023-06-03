package reponsitory;

import model.person.Employee;
import model.person.Person;

import java.util.List;

public interface IEmployeeRepository {
    void removeEmployee(Employee person);
    void addEmployee(Employee person);
    List<Employee> getEmployeeList();
    void editEmployee();
    Employee getByCode(String code);
    public void editUpFile();
    List<Employee> searchEmployee(String name);
}
