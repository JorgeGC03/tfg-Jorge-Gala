package com.fpmislata.KebabJorge.validaciones;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NameValidator.class)
public @interface ValidDescription {
    String message() default "La descripcion debe tener más de veinte caracteres y menos de cien";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}