package controller;

import java.util.Scanner;

public class FuramaController {
    private static Scanner scanner = new Scanner(System.in);

    public static void displayMainMenu() {
        END:
        while (true) {
            try {
                System.out.println("Furama Menu");
                System.out.println("1.Employee Management");
                System.out.println("2.Customer Management");
                System.out.println("3.Facility Management ");
                System.out.println("4.Booking Management");
                System.out.println("5.Promotion Management");
                System.out.println("6.Exit");
                int choseNumber = Integer.parseInt(scanner.nextLine());
                switch (choseNumber) {
                    case 1:
                        System.out.println("Employee Management menu");
                        EmployeeManagement.employeeMenu();
                        break;
                    case 2:
                        System.out.println("Customer Management");
                        CustomerManagement.CustomerMenu();
                        break;
                    case 3:
                        System.out.println("Facility Management");
                        FacilityManagement.FacilityMenu();
                        break;
                    case 4:
                        System.out.println("Booking Management menu");
                        BookingManagement.BookingMenu();
                        break;
                    case 5:
                        System.out.println("Promotion Management");
                        PromotionManagement.PromotionMenu();
                        break;
                    case 6:
                        break END;
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
