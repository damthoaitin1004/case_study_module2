package controller;

import java.util.Scanner;

public class EmployeeManagement {
    public static Scanner scanner = new Scanner(System.in);

    public static void employeeMenu() {
        ENDEMP:
        while (true) {
            try {
                System.out.println("1.Display list employees");
                System.out.println("2.Add new employee");
                System.out.println("3.Edit employee");
                System.out.println("4.Return main menu");
                int enterChose = Integer.parseInt(scanner.nextLine());
                switch (enterChose) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break ENDEMP;
                }
            } catch (NumberFormatException n) {
                System.out.println("Người dùng nhập không phải số vui lòng nhập lại");
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
    }
}
