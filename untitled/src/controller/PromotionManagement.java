package controller;

import java.util.Scanner;

public class PromotionManagement {
    private static Scanner scanner = new Scanner(System.in);

    public static void PromotionMenu() {
        ENDPRO:
        while (true) {
            try {
                System.out.println("1.Display list customers use service");
                System.out.println("2.Display list customers get voucher");
                System.out.println("3.Return main menu");
                int enterChose = Integer.parseInt(scanner.nextLine());
                switch (enterChose) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break ENDPRO;
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
