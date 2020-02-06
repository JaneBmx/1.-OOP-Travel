package util.parser;

import entity.FoodMode;
import entity.Tour;
import entity.TransportType;
import factory.TourFactory;
import factory.TourType;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static validation.TourValidator.*;


public class TourParser {
    private static final String REGEX_TOUR_FORMAT = "(\\w+)\\s+(\\w+)\\s+(\\w+)\\s+(\\d+)\\s+(\\d+\\.?\\d*)\\s+(\\w+_?\\w*)\\s+(\\w+_?\\w*)";
    private static final String SPACES = "\\s++";
    private static final int TOUR_FORMAT_LENGTH = 7;

    public static void main(String[] args) {
        String tempText = "id  type   country     city   days  cost   feed  transport  \n" +
                "-----------------------------------------------//\n" +
                "CRUISE  Russia   Ekb    12    120    all            BUS\n" +
                "TREATMENT  Russia   Spb    7     100    ALL_INCLUSIVE  BUS\n" +
                "EXCURSION Belarus  Brest  2     30     brcf           BUS\n" +
                "EXTREME Belarus  Minsk  999   999      NOT_INCLUDED   BUS";
        TourParser parser = new TourParser();
        List<String> set = parser.findMatches(tempText);
        Object o = parser.parseToTour(set.get(0));
    }

    public Set<Tour> parse(String text) {
        Set<Tour> tours = new HashSet<>();

        List<String> matches = findMatches(text);




    }


    public static List<String> findMatches(String text) {
        List<String> strings = new ArrayList<>();
        //TourType(1) country(2) city(3) days(4) cost(5) FoodMode(6) TransportMode(7)
        Pattern pattern = Pattern.compile(REGEX_TOUR_FORMAT);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            strings.add(matcher.group());
        }
        return strings;
    }

    Tour parseToTour(String line) {
        String[] params = line.split(SPACES);
        //TourType(0) country(1) city(2) days(3) cost(4) FoodMode(5) TransportMode(6)
        if (!(params.length == TOUR_FORMAT_LENGTH && isTourType(params[0])
                && isFoodType(params[5]) && isTransportType(params[6]))) {

            TourFactory factory = TourFactory.getInstance();
            Tour tour = factory.createTour(TourType.valueOf(params[0]));

            try {
                tour.setCountry(params[1].trim());
                tour.setCity(params[2].trim());
                tour.setDuration(Integer.parseInt(params[3]));
                tour.setCost(BigDecimal.valueOf(Double.parseDouble(params[4].trim())));
                tour.setFoodMode(FoodMode.valueOf(params[5]));
                tour.setTransportType(TransportType.valueOf(params[6]));
            } catch (Exception e) {
                return null;
            }
            return tour;
        }
        return null;
    }
}
