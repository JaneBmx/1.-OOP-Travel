package repository;

import entity.Tour;
import repository.specifications.TourSpecification;

import java.util.List;

public interface TourRepository {

    void addTour(List<Tour> tour); //TODO nado add by one?

    void updateTour(Tour tour);

    List<Tour> find(TourSpecification spec);  //TODO check TYPEs or concrete params
}