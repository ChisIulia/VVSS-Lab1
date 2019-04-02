package TeacherGrading;

import Domain.Student;
import Exceptions.ValidatorException;
import Repository.XMLFileRepository.StudentXMLRepo;
import Validator.StudentValidator;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestAddStudent {
    private StudentValidator studentValidator;
    private StudentXMLRepo studentXMLRepo;

    @Before
    public void setUp() {
        studentValidator = new StudentValidator();
        studentXMLRepo = new StudentXMLRepo(studentValidator, "StudentiXML_test.xml");
    }

    @Test
    public void testValidStudent() {
        int initialSize = studentXMLRepo.getSize();

        String id = "11";
        String nume = "Iulia";
        Integer grupa = 932;
        String email = "i@i.com";
        String prof = "profa";
        Student student = new Student(id, nume, grupa, email, prof);

        try {
            studentXMLRepo.save(student);
        } catch (ValidatorException e) {
            e.printStackTrace();
        }

        assertEquals(1, studentXMLRepo.getSize() - initialSize);
    }

    @Test(expected = ValidatorException.class)
    public void testMissingId() throws ValidatorException {
        String id = "";
        String nume = "Iulia";
        Integer grupa = 932;
        String email = "a@a.com";
        String prof = "profa";
        Student student = new Student(id, nume, grupa, email, prof);

        studentXMLRepo.save(student);
    }

    @Test(expected = ValidatorException.class)
    public void testOuterValueId() throws ValidatorException {
        String id = "10000";
        String nume = "Iulia";
        Integer grupa = 932;
        String email = "a@a.com";
        String prof = "profa";
        Student student = new Student(id, nume, grupa, email, prof);

        studentXMLRepo.save(student);
    }

    @Test(expected = ValidatorException.class)
    public void testInvalidName() throws ValidatorException {
        String id = "11";
        String nume = "Iulia12";
        Integer grupa = 9999;
        String email = "a@a.com";
        String prof = "profa";
        Student student = new Student(id, nume, grupa, email, prof);

        studentXMLRepo.save(student);
    }

    @Test(expected = ValidatorException.class)
    public void testInvalidGroup() throws ValidatorException {
        String id = "11";
        String nume = "Iulia";
        Integer grupa = -932;
        String email = "a@a.com";
        String prof = "profa";
        Student student = new Student(id, nume, grupa, email, prof);

        studentXMLRepo.save(student);
    }

    @Test()
    public void testBigValueGroup() throws ValidatorException {
        String id = "11";
        String nume = "Iulia";
        Integer grupa = 9999;
        String email = "a@a.com";
        String prof = "profa";
        Student student = new Student(id, nume, grupa, email, prof);

        studentXMLRepo.save(student);
    }

    @Test(expected = ValidatorException.class)
    public void testInvalidEmailAddress() throws ValidatorException {
        String id = "11";
        String nume = "Iulia";
        Integer grupa = 932;
        String email = "a";
        String prof = "profa";
        Student student = new Student(id, nume, grupa, email, prof);

        studentXMLRepo.save(student);
    }
}
