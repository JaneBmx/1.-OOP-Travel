package repository.specifications;

import entity.Tour;
import entity.TransportType;
import repository.specifications.TourSpecification;

public class TourSpecificationByTransport implements TourSpecification {
    private static final String TYPE = "TRANSPORT";
    private TransportType transportType;

    public TourSpecificationByTransport(TransportType transportType) {
        this.transportType = transportType;
    }

    public static String getTYPE() {
        return TYPE;
    }

    @Override
    public boolean specified(Tour tour) {
        return tour.getTransportType() == transportType;
    }
}
