package reponsitory.imple;

import model.fancility.Facility;
import reponsitory.IFacilityRepository;

import java.util.*;

public class FacilityRepository implements IFacilityRepository {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<Facility, Integer> facilityMap = new LinkedHashMap<Facility, Integer>();
    private static List<Facility> houseList = new ArrayList<>();
    private static List<Facility> villaslist = new ArrayList<>();
    private static List<Facility> roomsList = new ArrayList<>();

//    static {
//        facilityMap.put((Facility) houseList, 0);
//        facilityMap.put((Facility) villaslist, 0);
//        facilityMap.put((Facility) roomsList, 0);
//    }

    @Override
    public List<Facility> getFacilityList() {
        int chose;
        while (true) {
            System.out.println("Facility List");
            System.out.println("1. House List");
            System.out.println("2. Villa List");
            System.out.println("3. Room List");
            chose = Integer.parseInt(scanner.nextLine());
            if (chose == 1) {
                return houseList;
            } else if (chose == 2) {
                return villaslist;
            } else if (chose == 3) {
                return roomsList;
            }
        }

    }

    @Override
    public void removeVilla(Facility facility) {
        villaslist.remove(facility);
    }

    @Override
    public void removeRoom(Facility facility) {
        roomsList.remove(facility);
    }

    @Override
    public void removeHouse(Facility facility) {
        houseList.remove(facility);
    }

    @Override
    public void addVilla(Facility facility) {
        villaslist.add(facility);
    }

    @Override
    public void addHouse(Facility facility) {
        houseList.add(facility);
    }

    @Override
    public void addRoom(Facility facility)




    {
        roomsList.add(facility);
    }

    @Override
    public Facility getByCode(String code) {
        for (Facility h : houseList) {
            if (h.getServiceCode().equals(code)) ;
            return h;
        }
        for (Facility r : roomsList) {
            if (r.getServiceCode().equals(code)) {
                return r;
            }
        }
        for (Facility v : villaslist) {
            if (v.getServiceCode().equals(code)) {
                return v;
            }
        }
        return null;
    }
}
