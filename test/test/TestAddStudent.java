package test;

import Domain.Student;
import Exceptions.ValidatorException;
import Validator.StudentValidator;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class TestAddStudent {
    private StudentValidator studentValidator = new StudentValidator();

    @Test
    public void testValidStudent() {
        List<Student> studentList = new LinkedList<>();

        String id = "1";
        String nume = "Iulia";
        Integer grupa = 932;
        String email = "i@i.com";
        String prof = "profa";
        Student student = new Student(id, nume, grupa, email, prof);

        try {
            studentValidator.validate(student);
            studentList.add(student);
        } catch (ValidatorException e) {
            e.printStackTrace();
        }

        assertEquals(1, studentList.size());
    }

    @Test(expected = ValidatorException.class)
    public void testMissingId() throws ValidatorException {
        List<Student> studentList = new LinkedList<>();

        String id = "";
        String nume = "Iulia";
        Integer grupa = 932;
        String email = "a";
        String prof = "profa";
        Student student = new Student(id, nume, grupa, email, prof);

        studentValidator.validate(student);
        studentList.add(student);
    }
}
