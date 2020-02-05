package util.reader;

import entity.Tour;
import exceptions.FileReadException;
import util.ConsoleHelper;

import java.io.*;
import java.util.List;

public class TXTReader implements Reader {
    private static final String DEFAULT_PATH = "src\\main\\resources\\Tours list.txt";
    @Override
    public String read() throws FileReadException {
        StringBuffer text = new StringBuffer();

        ConsoleHelper.writeMessage("Specify full path of file");
        //TODO check exist()? read: path = some default path
        String path;
        try {
            path = ConsoleHelper.readLine();
        } catch (IOException e) {
            throw new FileReadException("some msg");
            //TODO log, msg
        }

        File file = new File(path);
        if (!file.exists()) {
            path = DEFAULT_PATH;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }
        } catch (IOException e) {
            //TODO log
            throw new FileReadException("some msg");
        }
        return text.toString().trim();
    }
}
