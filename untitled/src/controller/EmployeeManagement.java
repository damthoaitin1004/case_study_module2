package controller;

import service.IEmployeeService;
import service.impl.EmployeeService;

import java.util.Scanner;

public class EmployeeManagement {
    private static Scanner scanner = new Scanner(System.in);
    private static IEmployeeService employeeService = new EmployeeService();

    public static void employeeMenu() {
        ENDEMP:
        while (true) {
            try {
                System.out.println("1.Display list employees");
                System.out.println("2.Add new employee");
                System.out.println("3.Edit employee");
                System.out.println("4.Delete employee");
                System.out.println("5.Search employee");
                System.out.println("6.Return main menu");
                int enterChose = Integer.parseInt(scanner.nextLine());
                switch (enterChose) {
                    case 1:
                        employeeService.displayAll();
                        break;
                    case 2:
                        employeeService.addEmployee();
                        break;
                    case 3:
                         employeeService.settingEmployee();
                        break;
                    case 4:
                        employeeService.deleteEmployee();
                        break;
                    case 5:
                        employeeService.searchEmployee();
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Sai chức năng vui lòng nhập lại");
                }
            } catch (NumberFormatException n) {
                System.out.println("Người dùng nhập không phải số vui lòng nhập lại");
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
    }
}
