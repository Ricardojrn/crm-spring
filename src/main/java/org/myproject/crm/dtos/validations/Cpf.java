package org.myproject.crm.dtos.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CpfValidations.class)
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Cpf {
    String message() default "cpf inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
