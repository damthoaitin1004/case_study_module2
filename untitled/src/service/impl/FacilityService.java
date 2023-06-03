package service.impl;

import model.fancility.Facility;
import reponsitory.IFacilityRepository;
import reponsitory.imple.FacilityRepository;
import service.IFacilityService;

import java.util.List;
import java.util.Scanner;

public class FacilityService implements IFacilityService {
    private static  IFacilityRepository facilityRepository = new FacilityRepository();
    private static  Scanner scanner = new Scanner(System.in);

    @Override
    public void addFacility() {
        while (true) {
            try {
                System.out.println("Add new facility");
                System.out.println("1.Add Villa");
                System.out.println("2.Add House");
                System.out.println("3.Add Room");
                System.out.println("4.Return menu");
                int chose = Integer.parseInt(scanner.nextLine());
                switch (chose) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        RoomService.addFacility();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("This function is not available, please re-enter");

                }
            } catch (NumberFormatException n) {
                System.out.println("Not the number please re-enter");
            } catch (Exception e) {
                System.out.println("Error");
            }
        }


    }

    @Override
    public void deleteFacility() {
        while (true) {
            try {
                System.out.println("Delete Facility");
                System.out.println("1.Delete Villa");
                System.out.println("2.Delete Room");
                System.out.println("3.Delete House");
                System.out.println("4.Return menu");
                int chose = Integer.parseInt(scanner.nextLine());
                switch (chose) {
                    case 1:
                        break;
                    case 2:
                        RoomService.deleteFacility();
                        break;
                    case 3:
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("This function is not available, please re-enter");
                }
            }catch (NumberFormatException n){
                System.out.println("Not the number please re-enter");
            }catch (Exception e){
                System.out.println("Error");
            }
        }


    }

    @Override
    public void displayFacility() {
           List<Facility> facilityList = facilityRepository.getFacilityList();
        for (Facility f:facilityList) {
            System.out.println(f);
        }
    }

    @Override
    public void displayFacilityMaintenance() {

    }
}
