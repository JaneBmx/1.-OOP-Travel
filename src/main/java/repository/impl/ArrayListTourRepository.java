package repository.impl;

import entity.Tour;
import repository.TourRepository;
import repository.specifications.TourSpecification;

import java.util.ArrayList;
import java.util.List;
public class ArrayListTourRepository implements TourRepository {
    List<Tour> tours = new ArrayList<>();

    @Override
    public void addTour(Tour tour) {
        tours.add(tour);
    }

    @Override
    public void removeTour(Tour tour) {
        //potom pridumau krasivo
    }

    @Override
    public void updateTour(Tour tour) {

    }

    @Override
    public List<Tour> query(TourSpecification spec) {
       // switch (spec.)
        return null;
    }
}
