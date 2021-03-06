package factory;

import entity.*;

public class TourFactory {
    private TourFactory() {
    }

    private static class Holder {
        private static final TourFactory instance = new TourFactory();
    }

    public static TourFactory getInstance() {
        return Holder.instance;
    }

    public Tour createTour(TourType type) {
        switch (type) {
            case CRUISE:
                return new Cruise();
            case EXTREME:
                return new Extreme();
            case SHOPPING:
                return new Shopping();
            case EXCURSION:
                return new Excursion();
            case TREATMENT:
                return new Treatment();
            case RECREATION:
                return new Recreation();
            case ENTERTAINMENT:
                return new Entertainment();
        }
        return null;
    }
}
