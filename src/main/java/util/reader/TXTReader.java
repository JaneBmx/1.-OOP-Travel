package util.reader;

import entity.Tour;
import exceptions.FileReadException;
import util.ConsoleHelper;
import util.parser.TourParser;

import java.io.*;

public class TXTReader implements Reader {
    private static final String DEFAULT_PATH = "src\\main\\resources\\Tours list.txt";

    private TourParser parser;

    private static class Holder {
        private static final Reader instance = new TXTReader();
    }

    public static Reader getInstance() {
        return Holder.instance;
    }

    @Override
    public String read() throws FileReadException {

        StringBuilder text = new StringBuilder();

        ConsoleHelper.writeMessage("Specify full path of file: ");
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
        //is it right way to skip exc?

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
