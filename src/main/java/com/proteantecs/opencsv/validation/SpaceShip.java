package com.proteantecs.opencsv.validation;

import com.opencsv.bean.CsvBindByPosition;
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
    @CsvBindByPosition(position = 0)
    private String id;


    // Based on the requirements we can create different validators and reuse them for other fields
    @PreAssignmentValidator(validator = NameValidator.class, paramString ="")
    @CsvBindByPosition(position = 1)
    private String name;
    @CsvBindByPosition(position = 2,required = true)
    private String crew;
    @CsvBindByPosition(position = 3)
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
