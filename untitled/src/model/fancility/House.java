package model.fancility;

public class House extends Facility {
    private String quality;
    private float poolArea;

    public House() {

    }

    public House(String serviceCode, String nameService, float area, float price, int capacity, String rentalType, String quality, float poolArea) {
        super(serviceCode, nameService, area, price, capacity, rentalType);
        this.quality = quality;
        this.poolArea = poolArea;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public float getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(float poolArea) {
        this.poolArea = poolArea;
    }

    @Override
    public String toString() {
        return super.toString() +
                "quality='" + quality + '\'' +
                ", poolArea=" + poolArea +
                '}';
    }
}
