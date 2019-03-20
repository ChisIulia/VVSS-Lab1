import Domain.Student;
import Exceptions.ValidatorException;
import Validator.StudentValidator;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class AddingTests {
    private StudentValidator studentValidator = new StudentValidator();

    @Test
    public void addStudentTest() {
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

    @Test
    public void addStudentTest2() {
        List<Student> studentList = new LinkedList<>();

        String id = "1";
        String nume = "Iulia";
        Integer grupa = 932;
        String email = "a";
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
}
