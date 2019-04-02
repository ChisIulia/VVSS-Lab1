package Validator;

import Domain.Student;
import Exceptions.ValidatorException;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentValidator implements IValidator<Student> {
    public final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public void validate(Student s) throws ValidatorException {
        if (s.getId().equals("")) {
            throw new ValidatorException("Id invalid, empty\n");
        }
        if (!s.getId().matches("[+-]?[0-9]*[.]?[0-9][0-9]*")) {
            throw new ValidatorException("Id: invalid number\n");
        }
        if (!s.getId().matches("[0-9][0-9]*")) {
            throw new ValidatorException("Id: not a natural number\n");
        }
        if (Integer.parseInt(s.getId()) > 9999 || Integer.parseInt(s.getId()) < 10) {
            throw new ValidatorException("Id: invalid boundaries\n");
        }
        if (s.getNume().equals("") || s.getNume() == null) {
            throw new ValidatorException("Name: should not be empty\n");
        }
        if (!s.getNume().matches("^[\\p{L} .'-]+$")) {
            throw new ValidatorException("Name: invalid\n");
        }
        if (s.getIndrumator().equals("") || s.getIndrumator() == null) {
            throw new ValidatorException("Teacher: should not be empty\n");
        }
        if (!s.getIndrumator().matches("^[\\p{L} .'-]+$")) {
            throw new ValidatorException("Teacher: invalid\n");
        }
        if (s.getGrupa() <= 0) {
            throw new ValidatorException("Group: invalid number\n");
        }
        if (s.getEmail().equals("") || s.getEmail() == null) {
            throw new ValidatorException("Email: empty\n");
        }

        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(Objects.requireNonNull(s.getEmail()));
        if (!matcher.find()) {
            throw new ValidatorException("Email invalid");
        }
    }
}