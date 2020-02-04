package entity;

public abstract class Tour {
    protected static long globalId = 0;
    protected final long id;
    protected int duration;
    protected String country;
    protected String city;
    protected double cost;
    protected FoodMode foodMode;
    protected TransportType transportType;

    Tour(){
        id = ++globalId;
    }

    public long getId() {
        return id;
    }

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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
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
}
