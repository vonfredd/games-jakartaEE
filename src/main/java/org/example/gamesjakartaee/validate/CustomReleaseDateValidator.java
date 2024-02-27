package org.example.gamesjakartaee.validate;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.Year;

public class CustomReleaseDateValidator implements ConstraintValidator<CustomReleaseDate, Integer> {

    @Override
    public void initialize(CustomReleaseDate constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value >= 0 && value <= Year.now().getValue();
    }
}
