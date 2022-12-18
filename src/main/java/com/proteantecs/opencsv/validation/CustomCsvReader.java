package com.proteantecs.opencsv.validation;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.commons.lang3.ArrayUtils;

import java.io.IOException;
import java.io.Reader;


/*
*
* For adding availability to add line number to CSV Java model
* we need to extend CSVReader and override the readNext method
*
* */

public class CustomCsvReader extends CSVReader {
    /**
     * Constructs CSVReader using defaults for all parameters.
     *
     * @param reader The reader to an underlying CSV source.
     */
    public CustomCsvReader(Reader reader) {
        super(reader);
    }



    @Override
    public String[] readNext() throws IOException, CsvValidationException {
        String[] next = super.readNext();

        if(next != null && next.length != 0){
            return ArrayUtils.add(next, String.valueOf(super.getLinesRead()));
        }else return next;

    }
}
