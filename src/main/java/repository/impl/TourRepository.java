package repository.impl;

import entity.Tour;
import exception.FileReadException;
import parser.TourParser;
import reader.Reader;
import reader.TXTReader;
import repository.Repository;
import repository.specifications.TourSpecification;
import validation.TourValidator;

import java.io.File;
import java.util.*;

public class TourRepository implements Repository {
    private List<Tour> tours = new ArrayList<>();
    private static final String DEFAULT_PATH = "src\\main\\resources\\Tours list.txt";
    private String path;
    private static TourRepository instance;


    private TourRepository(String path) throws FileReadException {
        File file = new File(path);
        this.path = file.exists() ? path : DEFAULT_PATH;
        TourParser tp = TourParser.getInstance();
        Reader tr = TXTReader.getInstance();
        tours.addAll( tp.parse(tr.read(path)));
    }

    public static Repository getInstance(String path) throws FileReadException {
        if (instance == null) instance = new TourRepository(path);
        return instance;
    }

    @Override
    public void addTour(Tour tour) {
        tours.add(tour);
    }

    @Override
    public void removeTour(Tour tour) {
        tours.remove(tour);
    }

    @Override
    public void updateTour(Tour tour) {
        if (TourValidator.isValidTour(tour)) {
            for (Tour t : tours) {
                if (tour.getId() == t.getId()) {
                    t.setCity(tour.getCity());
                    t.setTransportType(tour.getTransportType());
                    t.setCountry(tour.getCountry());
                    t.setFeedType(tour.getFeedType());
                    t.setCost(tour.getCost());
                    t.setTourType(tour.getTourType());
                    t.setDuration(tour.getDuration());
                }
            }
        }
    }

    @Override
    public List<Tour> query(TourSpecification spec) {
        List<Tour> result = new ArrayList<>();

        for (Tour t : tours) {
            if (spec.specified(t)) {
                result.add(t);
            }
        }
        return result;
    }
}
