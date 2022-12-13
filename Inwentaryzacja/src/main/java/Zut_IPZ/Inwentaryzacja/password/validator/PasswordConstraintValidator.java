package Zut_IPZ.Inwentaryzacja.password.validator;

import Zut_IPZ.Inwentaryzacja.password.ValidPassword;
import org.passay.*;
import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;

import static org.passay.EnglishCharacterData.*;

@Component
public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {
    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        PasswordValidator validator = new PasswordValidator(Arrays.asList(
                new CharacterRule(LowerCase, 1),
                new CharacterRule(UpperCase, 1),
                new CharacterRule(Digit, 1),
                new CharacterRule(Special, 1),
                new WhitespaceRule()));
        RuleResult result = validator.validate(new PasswordData(password));
        if (result.isValid()) {
            return true;
        }

        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext.buildConstraintViolationWithTemplate(String.valueOf(validator.getMessages(result)))
                .addConstraintViolation();

        return false;
    }

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
    }
}
