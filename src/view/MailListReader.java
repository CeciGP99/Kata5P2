package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Mail;

public class MailListReader {
    
    public List<Mail> read(String fileName){
        List<Mail> list = new ArrayList<>();
        
        try { 
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
            while (true){
                String line = bufferedReader.readLine();
                if (line == null) break; 
                if(line.contains("@")){
                    list.add(new Mail(line));
                }
            }
        }catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException, FileCurrencyLoader::loadAllCurrencies() "+ex.getMessage());
        } catch (IOException ex) {
            System.out.println("IOException, FileCurrencyLoader::loadAllCurrencies() "+ex.getMessage());
        }
        return list;
    }
}
