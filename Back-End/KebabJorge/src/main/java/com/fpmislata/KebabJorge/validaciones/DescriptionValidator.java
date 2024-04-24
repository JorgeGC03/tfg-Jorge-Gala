package com.fpmislata.KebabJorge.validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DescriptionValidator implements ConstraintValidator<ValidDescription, String> {
    @Override
    public void initialize(ValidDescription constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String descripcion, ConstraintValidatorContext constraintValidatorContext) {
        return descripcion != null && descripcion.length() > 20 && descripcion.length() < 100;
    }
}
