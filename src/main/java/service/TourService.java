package service;

import entity.Tour;
import exception.FileReadException;
import repository.specifications.TourSpecification;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public interface TourService {
    List<Tour> getSuitableTours(Collection<TourSpecification> specifications, Comparator<Tour> comparators) throws FileReadException;
}
