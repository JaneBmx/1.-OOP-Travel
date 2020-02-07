package util.reader;

import exception.FileReadException;

public interface Reader {
    String read(String path) throws FileReadException;
}
