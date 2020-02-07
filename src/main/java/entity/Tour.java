package entity;

import java.io.Serializable;
import java.math.BigDecimal;

public abstract class Tour implements Serializable {
    protected int duration;
    protected String country;
    protected String city;
    protected BigDecimal cost;
    protected FoodMode foodMode;
    protected TransportType transportType;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public FoodMode getFoodMode() {
        return foodMode;
    }

    public void setFoodMode(FoodMode foodMode) {
        this.foodMode = foodMode;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Tour{"
                + "duration=" + duration +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", cost=" + cost +
                ", foodMode=" + foodMode +
                ", transportType=" + transportType +
                '}';
    }
}
