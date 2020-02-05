package util.reader;

import entity.Tour;
import exceptions.FileReadException;
import util.ConsoleHelper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class TXTReader implements Reader {

    @Override
    public String read() throws FileReadException {
        StringBuffer text = new StringBuffer();
        ConsoleHelper.writeMessage("Specify full path of file");
        //TODO check exist()? read: path = some default path
        try{
            String path = ConsoleHelper.readLine();
            try(BufferedReader reader = new BufferedReader(new FileReader(path))){
                String line;
                while((line = reader.readLine())!=null){
                    text.append(line).append("\n");
                }
            }
        } catch (IOException e){
            //TODO log
            throw new FileReadException("some msg");
        }
        return text.toString().trim();
    }
}
