package repository.impl;

import entity.Tour;
import repository.TourRepository;
import repository.specifications.TourSpecification;

import java.util.ArrayList;
import java.util.List;
public class ArrayListTourRepository implements TourRepository {
    List<Tour> tours = new ArrayList<>();

    public void add(Tour tour){
        tours.add(tour);
    }

    @Override
    public void addTour(List<Tour> tour) {
        this.tours.addAll(tour);
    }

    @Override
    public void updateTour(Tour tour) {
    //TODO is it real necessary?
    }

    @Override
    public List<Tour> find(TourSpecification spec) {
       // switch (spec.)



        return null;
    }
}
