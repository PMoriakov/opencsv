package com.proteantecs.opencsv.validation;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 * @author Pavel Moriakov
 * @since 15/12/2022
 */
public class CustomReaderPOC {


    public static void main(String[] args) throws FileNotFoundException {

        HeaderColumnNameMappingStrategy<SpaceShip> beanStrategy = new HeaderColumnNameMappingStrategy<>();
        beanStrategy.setType(SpaceShip.class);

        CsvToBean<SpaceShip> beans= new CsvToBeanBuilder<SpaceShip>(new CustomCsvReader(new FileReader("spaceships.csv")))
                .withType(SpaceShip.class)
                .withMappingStrategy(beanStrategy)
                .withIgnoreQuotations(true)
                .withThrowExceptions(false)
                .build();

        List<SpaceShip> ships = beans.parse();

        beans.getCapturedExceptions().stream().forEach((exception) -> {
            System.out.println(exception.getMessage());
        });
        ships.forEach(System.out::println);
    }
}
