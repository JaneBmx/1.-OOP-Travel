package services;

import entity.Tour;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TourServiceImpl implements TourService {

    List<Tour>tours = new ArrayList<>();
    /*TODO тут по идее должен гетаться лист с бд
    который бы парсился, чекался на валидность и ТОЛЬКО потом добавлялся
    в ЭТОТ лист*/

    @Override
    public List<Tour> getSuitableTours() {
        return null;
    }
     //TODO is next methods should be in this class?

    private static void sortByCountry(List<Tour> tours) {
        tours.sort(Comparator.comparing(Tour::getCountry)
                .thenComparing(Tour::getCity));
    }

    private static void sortByDuration(List<Tour> tours) {
        tours.sort(Comparator.comparingInt(Tour::getDuration));
    }

    private static void sortByCost(List<Tour> tours) {
        // tours.sort(Comparator.comparingDouble(Tour::getCost));
    }
    //TODO с
//    private List<Tour> searchTour(String country, String city, int duration, double cost, FoodMode food, TourType tourType, TransportType transportType) {
//        return tours.stream().filter(t -> t.getCountry().equalsIgnoreCase(country == null ? t.getCountry() : country)
//                && t.getCity().equalsIgnoreCase(city == null ? t.getCity() : city)
//                && t.getDuration() >= (duration == 0 ? t.getDuration() : duration)
//                && t.getCost() <= (cost == 0 ? t.getCost() : cost)
//                && t.getFood() == (food == null ? t.getFood() : food)
//                && t.getTourType() == (tourType == null ? t.getTourType() : tourType)
//                && t.getTransport() == (transportType == null ? t.getTransport() : transportType))
//                .collect(Collectors.toList());
//    }
}
