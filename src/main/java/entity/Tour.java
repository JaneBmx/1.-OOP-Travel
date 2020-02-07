package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public abstract class Tour implements Serializable {
    protected static long globalID;
    protected long id;
    protected int duration;
    protected String country;
    protected String city;
    protected BigDecimal cost;
    protected FeedType feedType;
    protected TransportType transportType;
    protected TourType tourType;

    public Tour() {
        this.id = ++globalID;
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

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public FeedType getFeedType() {
        return feedType;
    }

    public void setFeedType(FeedType feedType) {
        this.feedType = feedType;
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

    public TourType getTourType() {
        return tourType;
    }

    public void setTourType(TourType tourType) {
        this.tourType = tourType;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return id == tour.id &&
                duration == tour.duration &&
                country.equals(tour.country) &&
                city.equals(tour.city) &&
                cost.equals(tour.cost) &&
                feedType == tour.feedType &&
                transportType == tour.transportType &&
                tourType == tour.tourType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, duration, country, city, cost, feedType, transportType, tourType);
    }

    @Override
    public String toString() {
        return "Tour{" +
                "duration=" + duration +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", cost=" + cost +
                ", feedType=" + feedType +
                ", transportType=" + transportType +
                ", tourType=" + tourType +
                '}';
    }
}
