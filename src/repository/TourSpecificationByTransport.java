package repository;

import entity.Tour;
import entity.TransportType;

public class TourSpecificationByTransport implements TourSpecification {
    private TransportType transportType;

    public TourSpecificationByTransport(TransportType transportType) {
        super();
        this.transportType = transportType;
    }

    @Override
    public boolean specified(Tour tour) {
        return tour.getTransportType() == transportType;
    }
}
