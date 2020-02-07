package parser;

import entity.FeedType;
import entity.Tour;
import entity.TransportType;
import factory.TourFactory;
import entity.TourType;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static validation.TourValidator.*;


public class TourParser implements Parser {
    private static final String REGEX_TOUR_FORMAT = "(\\w+)\\s+(\\w+)\\s+(\\w+)\\s+(\\d+)\\s+(\\d+\\.?\\d*)\\s+(\\w+_?\\w*)\\s+(\\w+_?\\w*)";
    private static final String SPACES = "\\s++";
    private static final int TOUR_FORMAT_LENGTH = 7;

    private TourParser() {
    }

    private static class Holder {
        private static final TourParser instance = new TourParser();
    }

    public static TourParser getInstance() {
        return Holder.instance;
    }

    public Set<Tour> parse(String text) {
        Set<Tour> tours = new HashSet<>();

        Set<String> strings = findMatches(text);
        Tour tour = null;
        Iterator<String> it = strings.iterator();
        while (it.hasNext()) {
            if ((tour = parseToTour(it.next())) != null) {
                tours.add(tour);
            }
        }
        return tours;
    }


    private static Set<String> findMatches(String text) {
        Set<String> strings = new HashSet<>();
        //TourType(1) country(2) city(3) days(4) cost(5) FoodMode(6) TransportMode(7)
        Pattern pattern = Pattern.compile(REGEX_TOUR_FORMAT);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            strings.add(matcher.group());
        }
        return strings;
    }

    private static Tour parseToTour(String line) {
        String[] params = line.split(SPACES);
        //TourType(0) country(1) city(2) days(3) cost(4) FoodMode(5) TransportMode(6)
        if (!(params.length == TOUR_FORMAT_LENGTH && isTourType(params[0])
                && isFeedType(params[5]) && isTransportType(params[6]))) {

            TourFactory factory = TourFactory.getInstance();
            Tour tour = factory.createTour(TourType.valueOf(params[0]));

            try {
                tour.setCountry(params[1].trim());
                tour.setCity(params[2].trim());
                tour.setDuration(Integer.parseInt(params[3]));
                tour.setCost(BigDecimal.valueOf(Double.parseDouble(params[4].trim())));
                tour.setFeedType(FeedType.valueOf(params[5]));
                tour.setTransportType(TransportType.valueOf(params[6]));
            } catch (Exception e) {
                return null;
            }
            return tour;
        }
        return null;
    }
}
