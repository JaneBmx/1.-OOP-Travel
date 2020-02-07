package repository.specifications;

import entity.FeedType;
import entity.Tour;

public class TourSpecificationByFeed implements TourSpecification {
    private static final String TYPE = "FEED";
    private FeedType feedType;

    public TourSpecificationByFeed(FeedType feedType) {
        this.feedType = feedType;
    }

    public static String getTYPE() {
        return TYPE;
    }

    @Override
    public boolean specified(Tour tour) {
        return tour.getFeedType() == feedType;
    }
}
