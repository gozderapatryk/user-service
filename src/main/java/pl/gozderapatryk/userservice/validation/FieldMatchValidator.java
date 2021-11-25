package pl.gozderapatryk.userservice.validation;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

    private String firstField;
    private String secondField;
    private String message;

    @Override
    public void initialize(FieldMatch constraintAnnotation) {
        this.firstField = constraintAnnotation.firstField();
        this.secondField = constraintAnnotation.secondField();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Object firstFieldValue = new BeanWrapperImpl(value)
                .getPropertyValue(firstField);
        Object secondFieldValue = new BeanWrapperImpl(value)
                .getPropertyValue(secondField);

        context.buildConstraintViolationWithTemplate(message)
                .addPropertyNode(firstField)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();

        if (firstFieldValue != null) {
            return firstFieldValue.equals(secondFieldValue);
        } else {
            return secondFieldValue == null;
        }
    }
}
