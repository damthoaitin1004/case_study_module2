package reponsitory.imple;

import model.person.Employee;
import reponsitory.IEmployeeRepository;
import untils.common.WriteAndReadFilePerson;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private static List<Employee> employeeList = new ArrayList<>();
    private static final String EMPLOYEE_PATH = "untitled/src/untils/data/customer.csv";

    @Override
    public List<Employee> getEmployeeList() {
        List<String> strings = WriteAndReadFilePerson.readFile(EMPLOYEE_PATH);
        employeeList.clear();
        String[] info;
        for (String str : strings) {
            info = str.split(",");
            employeeList.add(new Employee(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7], info[8], Float.parseFloat(info[9])));
        }
        return employeeList;
    }

    @Override
    public void removeEmployee(Employee person) {
        employeeList = getEmployeeList();
        employeeList.remove(person);
        List<String> string = new ArrayList<>();
        for (Employee e : employeeList) {
            string.add(e.getCodePerson() + "," + e.getNamePerson() + "," + e.getDateOfBirth() + "," + e.isGender() + "," + e.getIdentityCard() + "," + e.getPhoneNumber() + "," + e.getEmail() + "," + e.getLevel() + "," + e.getPosition() + "," + e.getSalary());
        }
        WriteAndReadFilePerson.writeFile(EMPLOYEE_PATH, string, false);
    }


    @Override
    public void addEmployee(Employee person) {
        List<String> strings = new ArrayList<>();
        strings.add(person.getCodePerson() + "," + person.getNamePerson() + "," + person.getDateOfBirth() + "," + person.isGender() + "," + person.getIdentityCard() + "," + person.getPhoneNumber() + "," + person.getEmail() + "," + person.getLevel() + "," + person.getPosition() + "," + person.getSalary());
        WriteAndReadFilePerson.writeFile(EMPLOYEE_PATH, strings, true);
    }

    @Override
    public Employee getByCode(String code) {
        employeeList = getEmployeeList();
        for (Employee employee : employeeList) {
            if (employee.getCodePerson().equals(code)) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public void editEmployee() {
        employeeList = getEmployeeList();
    }

    @Override
    public void editUpFile() {
        List<String> string = new ArrayList<>();
        for (Employee e : employeeList) {
            string.add(e.getCodePerson() + "," + e.getNamePerson() + "," + e.getDateOfBirth() + "," + e.isGender() + "," + e.getIdentityCard() + "," + e.getPhoneNumber() + "," + e.getEmail() + "," + e.getLevel() + "," + e.getPosition() + "," + e.getSalary());
        }
        WriteAndReadFilePerson.writeFile(EMPLOYEE_PATH, string, false);
    }

    @Override
    public List<Employee> searchEmployee(String name) {
        employeeList = getEmployeeList();
        List<Employee> employeeList1 = new ArrayList<>();
        for (Employee e : employeeList) {
            if (e.getNamePerson().toLowerCase().contains(name.toLowerCase())) {
                employeeList1.add(e);
            }
        }
        return employeeList1;
    }
}
