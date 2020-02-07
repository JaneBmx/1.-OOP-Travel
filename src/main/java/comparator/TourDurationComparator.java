package comparator;

import entity.Tour;

import java.util.Comparator;

public class TourDurationComparator implements Comparator<Tour> {
    @Override
    public int compare(Tour o1, Tour o2) {
        Comparator<Tour> comparator = Comparator.comparing(Tour::getDuration);
        return comparator.compare(o1, o2);
    }
}
