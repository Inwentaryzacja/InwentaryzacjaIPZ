package Zut_IPZ.Inwentaryzacja.password.validator;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PasswordConstraintValidatorTest {
    @InjectMocks
    private PasswordConstraintValidator passwordConstraintValidator;

    @Mock
    private ConstraintValidatorContext constraintValidatorContext;


    @Test
    void isValid_whenCorrectInput() {
        String password = "Javka<3*";
        boolean valid = passwordConstraintValidator.isValid(password, constraintValidatorContext);
        assertTrue(valid);

        verify(constraintValidatorContext, never()).disableDefaultConstraintViolation();
        verify(constraintValidatorContext, never()).buildConstraintViolationWithTemplate(any());
    }
    @Test
    void isValid_whenIncorrectInput() {
        String password = "SB";
        //when
        ConstraintValidatorContext.ConstraintViolationBuilder builderMock = mock(ConstraintValidatorContext.ConstraintViolationBuilder.class);

        doReturn(builderMock).when(constraintValidatorContext).buildConstraintViolationWithTemplate(any());

        boolean valid = passwordConstraintValidator.isValid(password, constraintValidatorContext);
        assertFalse(valid);
        verify(constraintValidatorContext, times(1)).disableDefaultConstraintViolation();
        verify(constraintValidatorContext, times(1)).buildConstraintViolationWithTemplate(any());
        verify(builderMock, times(1)).addConstraintViolation();

    }


    @Test
    void initialize() {
    }
}