package Zut_IPZ.Inwentaryzacja.error.exception;

public class RoleWithGivenNameDoesNotExist extends RuntimeException {
    public RoleWithGivenNameDoesNotExist(final String message) {
        super(message);
    }

}
