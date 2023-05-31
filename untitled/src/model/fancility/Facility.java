package model.fancility;

import java.util.Objects;

public abstract class Facility {
    private String serviceCode;
    private String nameService;
    private float area;
    private float price;
    private int capacity;
    private String RentalType;

    public Facility() {

    }

    public Facility(String serviceCode, String nameService, float area, float price, int capacity, String rentalType) {
        this.serviceCode = serviceCode;
        this.nameService = nameService;
        this.area = area;
        this.price = price;
        this.capacity = capacity;
        RentalType = rentalType;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getRentalType() {
        return RentalType;
    }

    public void setRentalType(String rentalType) {
        RentalType = rentalType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Facility facility)) return false;
        return getServiceCode().equals(facility.getServiceCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getServiceCode());
    }

    @Override
    public String toString() {
        return "serviceCode='" + serviceCode + '\'' +
                ", nameService='" + nameService + '\'' +
                ", area=" + area +
                ", price=" + price +
                ", capacity=" + capacity +
                ", RentalType='" + RentalType + '\''
                ;
    }
}
