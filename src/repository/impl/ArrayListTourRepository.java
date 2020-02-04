package repository.impl;

import entity.Tour;
import repository.TourRepository;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTourRepository implements TourRepository {
    List<Tour> tours = new ArrayList<>();

    @Override
    public void addTour(List<Tour> tour) {
        this.tours.addAll(tour);
    }

    @Override
    public void updateTour(Tour tour) {
    //TODO is it real necessary?
    }

    @Override
    public List<Tour> getToursByParam() {
        List<Tour>result = new ArrayList<>();



        //многоходовочки с итераторами по параметрам.
        return result;
    }//TODO check Optional
}
