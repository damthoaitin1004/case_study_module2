package controller;

import service.ICustomerService;
import service.impl.CustomerService;

import java.util.Scanner;

public class CustomerManagement {
    private static Scanner scanner = new Scanner(System.in);
    private static ICustomerService customerService = new CustomerService();

    public static void CustomerMenu() {
        ENDCUS:
        while (true) {
            try {
                System.out.println("1.Display list customers");
                System.out.println("2.Add new customer");
                System.out.println("3.Edit customer");
                System.out.println("4.Delete customer");
                System.out.println("5.Search customer");
                System.out.println("0.Return main menu");
                int enterChose = Integer.parseInt(scanner.next());
                switch (enterChose) {
                    case 1:
                        customerService.displayAll();
                        break;
                    case 2:
                        customerService.addCustomer();
                        break;
                    case 3:
                        customerService.settingCustomer();
                        break;
                    case 4:
                        customerService.deleteCustomer();
                        break;
                    case 5:
                        customerService.searchCustomer();
                        break;
                    case 0:
                        break ENDCUS;
                    default:
                        System.out.println("Sai chức năng vui lòng nhập lại");
                }
            } catch (NumberFormatException n) {
                System.out.println("Người dùng nhập không phải số");
            } catch (Exception e) {
                System.out.println("Error");
            }

        }
    }
}
