package comparator;

import entity.Tour;

import java.util.Comparator;

public class TourTypeAndCountryComparator implements Comparator<Tour> {
    @Override
    public int compare(Tour o1, Tour o2) {
        Comparator<Tour> comparator = Comparator.comparing(Tour::getTourType)
                .thenComparing(Tour::getCountry).thenComparing(Tour::getCost);
        return comparator.compare(o1, o2);
    }
}
