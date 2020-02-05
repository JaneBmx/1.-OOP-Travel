package validation;

import entity.FoodMode;
import entity.TransportType;
import factory.TourType;

import java.math.BigDecimal;

public class TourValidator {
    public static boolean checkDuration(int duration) {
        return duration > 0;
    }

    public static boolean checkRegion(String country, String city) {
        return (isValidString(country) && isValidString(city));
    }

    private static boolean isValidString(String string) {
        return string == null || string.isEmpty();
    }

    public static boolean checkCost(BigDecimal cost) {
        return cost != null && (1 == cost.signum());
    }

    public static boolean checkDescription(String description) {
        return isValidString(description);
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

    public static boolean isFoodType(String s) {
        if (!isValidString(s)) return false;

        for (FoodMode type : FoodMode.values()) {
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
