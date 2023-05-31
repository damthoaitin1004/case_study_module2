package model.fancility;

public class Villa extends Facility {
    private String quality;
    private float poolArea;
    private int numberFloor;

    public Villa() {

    }

    public Villa(String quality, float poolArea, int numberFloor) {
        this.quality = quality;
        this.poolArea = poolArea;
        this.numberFloor = numberFloor;
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

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }

    @Override
    public String toString() {
        return super.toString() +
                "quality='" + quality + '\'' +
                ", poolArea=" + poolArea +
                ", numberFloor=" + numberFloor
                ;
    }
}
