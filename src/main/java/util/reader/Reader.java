package util.reader;

import exceptions.FileReadException;

public interface Reader {
    String read(String path) throws FileReadException;
}
