package repository;

import entity.FoodMode;
import entity.Tour;

public class TourSpecificationByFeed implements TourSpecification {
    private FoodMode foodMode;

    public TourSpecificationByFeed(FoodMode foodMode) {
        super();
        this.foodMode = foodMode;
    }

    @Override
    public boolean specified(Tour tour) {
        return tour.getFoodMode() == foodMode;
    }
}
