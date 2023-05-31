package controller;

import java.util.Scanner;

public class CustomerManagement {
    private static Scanner scanner = new Scanner(System.in);

    public static void CustomerMenu() {
        ENDCUS:
        while (true) {
            try {
                System.out.println("1.Display list customers");
                System.out.println("2.Add new customer");
                System.out.println("3.Edit customer");
                System.out.println("4.Return main menu");
                int enterChose = Integer.parseInt(scanner.next());
                switch (enterChose) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
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
