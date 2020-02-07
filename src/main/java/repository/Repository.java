package repository;

import entity.Tour;
import repository.specifications.TourSpecification;

import java.util.List;

public interface Repository {



    void addTour(Tour tour);

    void removeTour(Tour tour);

    void updateTour(Tour tour);

    List<Tour> query(TourSpecification spec);
}