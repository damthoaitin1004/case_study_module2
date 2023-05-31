package controller;

import java.util.Scanner;

public class BookingManagement {
    private static Scanner scanner = new Scanner(System.in);

    public static void BookingMenu() {
        ENDBOOK:
        while (true) {

            try {
                System.out.println("1.Add new booking");
                System.out.println("2.Display list booking");
                System.out.println("3.Create new contracts");
                System.out.println("4.Display list contracts");
                System.out.println("5.Edit contracts");
                System.out.println("6.Return main menu");
               int enterChose = Integer.parseInt(scanner.nextLine());
                switch (enterChose) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break ENDBOOK;
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
