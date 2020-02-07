package validation;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class TourValidatorTest {

    @Test
    public void checkDurationNegativeFalse() {
        int input = -1;
        boolean expected = false;
        boolean actual = TourValidator.checkDuration(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkDurationPositiveTest() {
        int input = 1;
        boolean expected = true;
        boolean actual = TourValidator.checkDuration(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkRegionValidTest() {
        String input1 = "Belarus";
        String input2 = "Minsk";
        boolean expected = true;
        boolean actual = TourValidator.checkRegion(input1, input2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkRegionEmptyParamTest() {
        String input1 = "";
        String input2 = "Minsk";
        boolean expected = false;
        boolean actual = TourValidator.checkRegion(input1, input2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkRegionNullParamTest() {
        String input1 = null;
        String input2 = "Minsk";
        boolean expected = false;
        boolean actual = TourValidator.checkRegion(input1, input2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isValidPositiveCost() {
        BigDecimal input = new BigDecimal(2);
        boolean expected = true;
        boolean actual = TourValidator.isValidCost(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isValidCostNegativeTest() {
        BigDecimal input = new BigDecimal(-2);
        boolean expected = false;
        boolean actual = TourValidator.isValidCost(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isValidCostNullTest() {
        BigDecimal input = null;
        boolean expected = false;
        boolean actual = TourValidator.isValidCost(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isTourTypeValidTest() {
        String input = "CRUISE";
        boolean expected = true;
        boolean actual = TourValidator.isTourType(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isTourTypeInvalidTest() {
        String input = "cruise";
        boolean expected = false;
        boolean actual = TourValidator.isTourType(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isFeedTypeValidTest() {
        String input = "NOT_INCLUDED";
        boolean expected = true;
        boolean actual = TourValidator.isFeedType(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isFeedTypeInvalidTest() {
        String input = "not included";
        boolean expected = false;
        boolean actual = TourValidator.isFeedType(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isTransportTypeValidTest() {
        String input = "BUS";
        boolean expected = true;
        boolean actual = TourValidator.isTransportType(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isTransportTypeInvalidTest() {
        String input = "bus";
        boolean expected = false;
        boolean actual = TourValidator.isTransportType(input);
        Assert.assertEquals(expected, actual);
    }
}