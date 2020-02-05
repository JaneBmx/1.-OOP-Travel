package util.reader;

import entity.Tour;
import exceptions.FileReadException;

import java.util.List;

public interface Reader {
    String read() throws FileReadException;

}
