package model.fancility;

public class Room extends Facility {
    private String freeService;


    public Room() {

    }

    public Room(String serviceCode, String nameService, float area, float price, int capacity, String rentalType, String freeService) {
        super(serviceCode, nameService, area, price, capacity, rentalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return super.toString() +
                "freeService='" + freeService
                ;
    }
}
