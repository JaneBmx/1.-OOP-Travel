import entity.Extreme;
import entity.FoodMode;
import entity.Tour;
import entity.TransportType;
import factory.TourFactory;
import factory.TourType;

import static validation.TourValidator.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test {
    public static void main(String[] args) {
        String text = "id  type   cntr     city   days  cost   feed           transport  \n" +
                "-----------------------------------------------//\n" +
                "1  CRUISE  Russia   Ekb    12    120    all            BUS\n" +
                "2  ENTRTM  Russia   Spb    7     100    ALL_INCLUSIVE  BUS\n" +
                "3  EXTREME Belarus  Brest  2     30     brcf           BUS\n" +
                "4  EXTREME Belarus  Minsk  999   0      NOT_INCLUDED   BUS";
        parser(text);
    }


    static void parser(String text) {//TODO add regEx to params or make it static field
        // id(0) TourType(1) country(2) city(3) days(4) cost(5) FoodMode(6) TransportMode(7)
        Pattern pattern = Pattern.compile("(\\d+)\\s+(\\w+)\\s+(\\w+)\\s+(\\w+)\\s+(\\d+)\\s+(\\d+\\.?\\d*)\\s+(\\w+_?\\w*)\\s+(\\w+_?\\w*)");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            Tour tour = tourConverter(matcher.group());
            if (tour != null) {
                System.out.println(tour.toString());
            }
        }
    }

    static Tour tourConverter(String line) {
        String[] params = line.split(" ");
        // id(0) TourType(1) country(2) city(3) days(4) cost(5) FoodMode(6) TransportMode(7)
        if (!(isFoodType(params[6]) && isTourType(params[1]) && isTransportType(params[7]))) {
            //TODO эксепшен кидай и логируй
            System.out.println("none:(");
            return null;
        }

        TourFactory factory = TourFactory.getInstance();
        Tour tour = factory.createTour(TourType.valueOf(params[1]));

        try {
            tour.setCountry(params[2].trim());
            tour.setCity(params[3].trim());
            tour.setDuration(Integer.parseInt(params[4]));
            tour.setCost(BigDecimal.valueOf(Double.parseDouble(params[5].trim())));
            tour.setFoodMode(FoodMode.valueOf(params[6]));
            tour.setTransportType(TransportType.valueOf(params[7]));
        } catch (Exception e) {
            //TODO кидать ексепшен? врядли. надо как-то просто скипать
            return null;
        }
        return tour;
    }
}
