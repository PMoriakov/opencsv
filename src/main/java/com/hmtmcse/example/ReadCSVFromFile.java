package com.hmtmcse.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSVFromFile {


    public static void main(String[] args) {
        CSVReader csvReader = null;
        try {
            csvReader = new CSVReader(new FileReader("country.csv"));
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                System.out.println("Country id= " + line[0] + ", code= " + line[1] + " , name=" + line[2]);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

    }

}