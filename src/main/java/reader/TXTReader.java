package reader;

import exception.FileReadException;

import java.io.*;

public class TXTReader implements reader.Reader {
    private static class Holder {
        private static final reader.Reader instance = new TXTReader();
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
            throw new FileReadException("File not found.");
        } catch (IOException e) {
            throw new FileReadException(e.getMessage());
        }
        return text.toString().trim();
    }
}
