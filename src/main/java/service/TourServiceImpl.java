package service;

import comparator.*;

import entity.Tour;
import exception.FileReadException;
import repository.Repository;
import repository.impl.TourRepository;
import repository.specifications.TourSpecification;

import java.util.*;

public class TourServiceImpl implements TourService {
    List<Tour> tours = new ArrayList<>();

    @Override
    public List<Tour> getSuitableTours(Collection<TourSpecification> specifications, Comparator<Tour> comparator) throws FileReadException {
        List<Tour> result = new ArrayList<>();
        result.addAll(tours);

        Repository tr = TourRepository.getInstance(null);

        for (TourSpecification sp: specifications){
            result =tr.query(sp);
        }
        result.sort(comparator);
        return result;
    }

    private void sortByCountry() {
        tours.sort(new CountryAndCostComparator());
    }

    private void sortByDuration() {
        tours.sort(new TourDurationComparator().thenComparing(new TourDurationComparator()));
    }

    private void sortByFeedType() {
        tours.sort(new FeedTypeComparator());
    }
}
