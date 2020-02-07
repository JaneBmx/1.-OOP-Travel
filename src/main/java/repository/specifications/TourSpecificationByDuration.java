package repository.specifications;

import entity.Tour;
import repository.specifications.TourSpecification;

public class TourSpecificationByDuration implements TourSpecification {
    private static final String TYPE = "DURATION";
    private int maxDuration;
    private int minDuration;

    public TourSpecificationByDuration(int maxDuration, int minDuration) {
        this.maxDuration = maxDuration;
        this.minDuration = minDuration;
    }

    public static String getTYPE() {
        return TYPE;
    }

    @Override
    public boolean specified(Tour tour) {
        return tour.getDuration() >= minDuration
                && tour.getDuration() < maxDuration;
    }
}
