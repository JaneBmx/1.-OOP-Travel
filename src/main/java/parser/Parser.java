package parser;

import entity.Tour;

import java.util.Set;

public interface Parser {
    Set<Tour> parse(String text);
}
