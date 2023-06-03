package controller;

import service.IFacilityService;
import service.impl.FacilityService;

import java.util.Scanner;

public class FacilityManagement {
    private static Scanner scanner = new Scanner(System.in);
     private static IFacilityService facilityService =new FacilityService();
    public static void FacilityMenu() {

        ENDFACI:
        while (true) {
            try {
                System.out.println("1.Display list facility");
                System.out.println("2.Add new facility");
                System.out.println("3.Display list facility maintenance");
                System.out.println("4.Return main menu");
                int enterChose = Integer.parseInt(scanner.nextLine());
                switch (enterChose) {
                    case 1:
                        facilityService.displayFacility();
                        break;
                    case 2:
                        facilityService.addFacility();
                        break;
                    case 3:

                        break;
                    case 4:
                        return;
                        default:
                        System.out.println("Sai chức năng vui lòng nhập lại");
                }
            } catch (NumberFormatException n) {
                System.out.println("người dùng nhập không phải số");
            } catch (Exception e) {
                System.out.println("Error");
            }
        }

    }
}

