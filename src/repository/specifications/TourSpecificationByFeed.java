package repository.specifications;

import entity.FoodMode;
import entity.Tour;
import repository.specifications.TourSpecification;

public class TourSpecificationByFeed implements TourSpecification {
    private static final String TYPE = "FEED";
    private FoodMode foodMode;

    public TourSpecificationByFeed(FoodMode foodMode) {
        super();
        this.foodMode = foodMode;
    }

    public static String getTYPE() {
        return TYPE;
    }

    @Override
    public boolean specified(Tour tour) {
        return tour.getFoodMode() == foodMode;
    }
}
