package util.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import exceptions.FileReadException;

import java.io.*;

public class TXTReader implements Reader {
    private static final Logger LOGGER = LogManager.getLogger(TXTReader.class);

    private static class Holder {
        private static final Reader instance = new TXTReader();
    }

    public static Reader getInstance() {
        return Holder.instance;
    }

    @Override
    public String read(String path) throws FileReadException {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            LOGGER.error(e);
            throw new FileReadException("File not found.");
        } catch (IOException e) {
            LOGGER.error(e);
            throw new FileReadException(e.getMessage());
        }
        return text.toString().trim();
    }
}
