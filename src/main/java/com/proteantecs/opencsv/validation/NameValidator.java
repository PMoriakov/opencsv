package com.proteantecs.opencsv.validation;

import com.opencsv.bean.BeanField;
import com.opencsv.bean.validators.StringValidator;
import com.opencsv.exceptions.CsvValidationException;

/**
 * Validator which checks that the given name doesn't contain 'Y' character
 *
 * @author Pavel Moriakov
 * @since 18/12/2022
 */
public class NameValidator implements StringValidator {
    @Override
    public boolean isValid(String value) {

        if (value == null) {
            return false;
        } else return !value.toLowerCase().contains("y");
    }

    @Override
    public void validate(String value, BeanField field) throws CsvValidationException {
        if(!isValid(value)){
            throw new CsvValidationException("Ship has invalid name: " + value);
        }
    }

    @Override
    public void setParameterString(String value) {

    }
}
