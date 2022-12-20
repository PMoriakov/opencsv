package com.proteantecs.opencsv.validation;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.validators.PreAssignmentValidator;
import com.proteantecs.opencsv.RegexExpressionValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpaceShip {

    //At current example we use ReGex based validation
    @PreAssignmentValidator(validator = RegexExpressionValidator.class, paramString = "[0-9]")
    @CsvBindByName(column = "id", required = true)
    private String id;


    // Based on the requirements we can create different validators and reuse them for other fields
    @PreAssignmentValidator(validator = NameValidator.class, paramString ="")
    @CsvBindByName(column = "name", required = true)
    private String name;
    @CsvBindByName(column = "crew", required = true)
    private String crew;

    @CsvBindByName(column = "lineNumber",required = true)
    private int lineNumber;

    @Override
    public String toString() {
        return "SpaceShip{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", crew='" + crew + '\'' +
                ", lineNumber=" + lineNumber +
                '}';
    }
}
