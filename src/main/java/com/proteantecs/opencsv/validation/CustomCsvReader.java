package com.proteantecs.opencsv.validation;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.commons.lang3.ArrayUtils;

import java.io.IOException;
import java.io.Reader;
import java.util.concurrent.atomic.AtomicInteger;


/*
*
* For adding availability to add line number to CSV Java model
* we need to extend CSVReader and override the readNext method
*
* */

public class CustomCsvReader extends CSVReader {

    private AtomicInteger count = new AtomicInteger(0);

    private final static String LINE_NUMBER_HEADER = "lineNumber" ;

    /**
     * Constructs CSVReader using defaults for all parameters.
     *
     * @param reader The reader to an underlying CSV source.
     */
    public CustomCsvReader(Reader reader) {
        super(reader);
    }

    //readNextSilently method invoked only once when openCsv read first line(headers)
    //in that case we can add new header using AtomicInteger counter
    @Override
    public String[] readNextSilently() throws IOException {

        String[] next = super.readNextSilently();
        // Add line number as a new header
        if(count.get() == 0 && next != null && next.length != 0 ){
            count.getAndIncrement();
            return ArrayUtils.add(next, LINE_NUMBER_HEADER);
        }else return next;
    }

    @Override
    public String[] readNext() throws IOException, CsvValidationException {
        String[] next = super.readNext();

        if(next != null && next.length != 0){
            return ArrayUtils.add(next, String.valueOf(super.getLinesRead()));
        }else return next;

    }
}
