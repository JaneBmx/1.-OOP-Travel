package util.parser;

import entity.FoodMode;
import entity.Tour;
import entity.TransportType;
import factory.TourFactory;
import factory.TourType;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static validation.TourValidator.*;


public class TourParser { //TODO помажь интерфейсами
    private static final String regExTourFormat = "(\\d+)\\s+(\\w+)\\s+(\\w+)\\s+(\\w+)\\s+(\\d+)\\s+(\\d+\\.?\\d*)\\s+(\\w+_?\\w*)\\s+(\\w+_?\\w*)";

    public static void main(String[] args) {
        String tempText = "id  type   country     city   days  cost   feed  transport  \n" +
                "-----------------------------------------------//\n" +
                "1  CRUISE  Russia   Ekb    12    120    all            BUS\n" +
                "2  TREATMENT  Russia   Spb    7     100    ALL_INCLUSIVE  BUS\n" +
                "3  EXCURSION Belarus  Brest  2     30     brcf           BUS\n" +
                "4  EXTREME Belarus  Minsk  999   999      NOT_INCLUDED   BUS";
    }


    public Set<String> parser(String text) {
        Set<String> strings = new HashSet<>();
        // id(1) TourType(2) country(3) city(4) days(5) cost(6) FoodMode(7) TransportMode(8)
        Pattern pattern = Pattern.compile(regExTourFormat);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            strings.add(matcher.group());
        }
        return strings;
    }

    static Tour tourConverter(String line) {
        String[] params = line.split("\\s++");
        //TODO пофикси беду с пробелами(если более одного)

        // id(1) TourType(2) country(3) city(4) days(5) cost(6) FoodMode(7) TransportMode(8)
        if (!(isTourType(params[2]) && isFoodType(params[7]) && isTransportType(params[8]))) {
            //TODO быть ексепшену или не быть?
            return null;
        }

        TourFactory factory = TourFactory.getInstance();
        Tour tour = factory.createTour(TourType.valueOf(params[1]));

        try {
            tour.setCountry(params[3].trim());
            tour.setCity(params[4].trim());
            tour.setDuration(Integer.parseInt(params[5]));
            tour.setCost(BigDecimal.valueOf(Double.parseDouble(params[6].trim())));
            tour.setFoodMode(FoodMode.valueOf(params[7]));
            tour.setTransportType(TransportType.valueOf(params[8]));
        } catch (Exception e) {
            //TODO кидать ексепшен? врядли. надо как-то просто скипать. пусть чекает получатель
            return null;
        }
        return tour;
        //TODO айди не либо не будут уникальными, либо не будут совпадать с айди из тхт. убрать?
    }
}
