package validation;

import entity.FeedType;
import entity.Tour;
import entity.TransportType;
import entity.TourType;

import java.math.BigDecimal;

public class TourValidator {
    public static boolean isValidTour(Tour tour) {
        if (tour != null) {
            return (isValidRegion(tour.getCountry(), tour.getCity())
                    && isValidDuration(tour.getDuration())
                    && isValidCost(tour.getCost())
                    && isTourType(tour.getTourType().toString())
                    && isTransportType(tour.getTransportType().toString())
                    && isFeedType(tour.getFeedType().toString()));
        }
        return false;
    }

    public static boolean isValidDuration(int duration) {
        return duration > 0;
    }

    public static boolean isValidRegion(String country, String city) {
        return (isValidString(country) && isValidString(city));
    }

    private static boolean isValidString(String string) {
        return string == null || string.isEmpty();
    }

    public static boolean isValidCost(BigDecimal cost) {
        return cost != null && (1 == cost.signum());
    }

    public static boolean isTourType(String s) {
        if (!isValidString(s)) return false;

        for (TourType type : TourType.values()) {
            if (s.equals(type.toString())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isFeedType(String s) {
        if (!isValidString(s)) return false;

        for (FeedType type : FeedType.values()) {
            if (s.equals(type.toString())) {
                return true;
            }
        }
        return false;
    }//TODO remove code duplicate

    public static boolean isTransportType(String s) {
        if (!isValidString(s)) return false;

        for (TransportType type : TransportType.values()) {
            if (s.equals(type.toString())) {
                return true;
            }
        }
        return false;
    }//TODO lol, duplicate again ;C
}
