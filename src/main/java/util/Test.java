package util;

import entity.Tour;
import exceptions.FileReadException;
import util.parser.Parser;
import util.parser.TourParser;
import util.reader.Reader;
import util.reader.TXTReader;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Reader reader = TXTReader.getInstance();
        Parser parser = TourParser.getInstance();

        Set<Tour> tours = null;
        try {
            tours = parser.parse(reader.read("src/main/resources/Tours list.txt"));
        } catch (FileReadException e) {
            System.out.println("всё плохо");
        }

        Iterator<Tour> tourIterator = tours.iterator();

        while(tourIterator.hasNext()){
            System.out.println(tourIterator.next());
        }
    }

}
