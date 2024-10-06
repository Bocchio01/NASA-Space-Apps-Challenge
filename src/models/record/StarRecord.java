package models.record;

public class StarRecord {
    private int x, y;
    private double distanceFromPlanet;
    private int brightness;

    public StarRecord(int x, int y, double distanceFromPlanet, int brightness) {
        this.x = x;
        this.y = y;
        this.distanceFromPlanet = distanceFromPlanet;
        this.brightness = brightness;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getDistanceFromPlanet() {
        return distanceFromPlanet;
    }

    public int getBrightness() {
        return brightness;
    }
}