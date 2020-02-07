package util.parser;

import entity.Cruise;
import entity.FeedType;
import entity.Tour;
import entity.TransportType;
import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Set;



public class TourParserTest {

    @Test
    public void parse() {
        String input = "1  CRUISE  Russia   Ekb    12    120    NOT_INCLUDED  BUS";
        Tour expected = new Cruise();
        expected.setTransportType(entity.TransportType.BUS);
        expected.setCost(new BigDecimal(12));
        expected.setCountry("Russia");
        expected.setCity("Ekb");
        expected.setDuration(12);
        expected.setFeedType(FeedType.NOT_INCLUDED);
        expected.setTransportType(TransportType.BUS);

        Set<Tour> test = TourParser.getInstance().parse(input);
        Iterator<Tour> it =test.iterator();
        Tour actual = it.next();
        Assert.assertEquals(expected,actual);
    }
}