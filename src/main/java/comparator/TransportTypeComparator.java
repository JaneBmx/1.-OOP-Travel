package comparator;

import entity.Tour;

import java.util.Comparator;

public class TransportTypeComparator implements Comparator<Tour> {
    @Override
    public int compare(Tour o1, Tour o2) {
        Comparator<Tour> comparator = Comparator.comparing(Tour::getTransportType);
        return comparator.compare(o1, o2);
    }
}
