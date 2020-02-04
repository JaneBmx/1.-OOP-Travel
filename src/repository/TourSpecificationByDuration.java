package repository;

import entity.Tour;

public class TourSpecificationByDuration implements TourSpecification {
    private int maxDuration;
    private int minDuration;

    public TourSpecificationByDuration(int maxDuration, int minDuration) {
        super();
        this.maxDuration = maxDuration;
        this.minDuration = minDuration;
    }

    @Override
    public boolean specified(Tour tour) {
        return tour.getDuration() >= minDuration
                && tour.getDuration() < maxDuration;
    }
}
