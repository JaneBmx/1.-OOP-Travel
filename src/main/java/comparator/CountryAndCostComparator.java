package comparator;

import entity.Tour;

import java.util.Comparator;

public class CountryAndCostComparator implements Comparator<Tour> {
    @Override
    public int compare(Tour o1, Tour o2) {
        Comparator<Tour> comparator = Comparator.comparing(Tour::getCountry)
                .thenComparing(Tour::getCost);
        return comparator.compare(o1, o2);
    }
}
