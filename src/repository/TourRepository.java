package repository;

import entity.Tour;

import java.util.List;
import java.util.Optional;

public interface TourRepository {

    void addTour(List<Tour> tour); //TODO nado add by one?

    void updateTour(Tour tour);


    List<Tour> getToursByParam(TourSpecification... spec);  //TODO check TYPEs or concrete params

}