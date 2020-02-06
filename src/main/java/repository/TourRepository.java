package repository;

import entity.Tour;
import repository.specifications.TourSpecification;

import java.util.List;

public interface TourRepository {

    void addTour(Tour tour);

    void removeTour(Tour tour);

    void updateTour(Tour tour);

    List<Tour> query(TourSpecification spec);  //TODO check TYPEs or concrete params
}