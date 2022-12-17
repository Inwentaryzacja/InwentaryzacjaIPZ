package Zut_IPZ.Inwentaryzacja.password.validator;

import Zut_IPZ.Inwentaryzacja.password.PasswordDTO;
import Zut_IPZ.Inwentaryzacja.password.PasswordMatches;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, PasswordDTO> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(PasswordDTO passwordDTO, ConstraintValidatorContext context){
        return passwordDTO.getPassword().equals(passwordDTO.getPasswordConfirmation());
    }
}
