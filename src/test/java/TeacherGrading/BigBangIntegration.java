package TeacherGrading;

import Domain.Nota;
import Domain.Student;
import Domain.TemaLab;
import Exceptions.ValidatorException;
import Repository.XMLFileRepository.NotaXMLRepo;
import Repository.XMLFileRepository.StudentXMLRepo;
import Repository.XMLFileRepository.TemaLabXMLRepo;
import Validator.NotaValidator;
import Validator.StudentValidator;
import Validator.TemaLabValidator;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static junit.framework.TestCase.assertEquals;

public class BigBangIntegration {
    private TemaLabValidator temaLabValidator;
    private StudentValidator studentValidator;
    private NotaValidator notaValidator;

    private TemaLabXMLRepo temaLabXMLRepo;
    private StudentXMLRepo studentXMLRepo;
    private NotaXMLRepo notaXMLRepo;

    @Before
    public void setUp() {
        temaLabValidator = new TemaLabValidator();
        studentValidator = new StudentValidator();
        notaValidator = new NotaValidator();

        temaLabXMLRepo = new TemaLabXMLRepo(temaLabValidator, "TemaLabXML_test.xml");
        studentXMLRepo = new StudentXMLRepo(studentValidator, "StudentXML_test.xml");
        notaXMLRepo = new NotaXMLRepo(notaValidator, "NotaXML_test.xml");
    }

    @Test
    public void testAddAssignment() {
        int initialSize = temaLabXMLRepo.getSize();

        int id = 100;
        String descriere = "ceva";
        int termenLimita = 2;
        int saptamanaPredarii = 2;

        TemaLab temaLab = new TemaLab(id, descriere, termenLimita, saptamanaPredarii);
        try {
            temaLabXMLRepo.save(temaLab);
        } catch (ValidatorException e) {
            e.printStackTrace();
        }

        assertEquals(1, temaLabXMLRepo.getSize() - initialSize);
    }

    @Test
    public void testAddStudent() {
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

    @Test
    public void testAddGrade() {
        int initialSize = notaXMLRepo.getSize();

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

        Integer idNota = 1;
        String studentId = "11";
        Integer temaLabId = 1;
        Double valoareNota = 9.5;
        LocalDateTime localDateTime = LocalDateTime.now();
        Nota nota = new Nota(idNota, studentId, temaLabId, valoareNota, localDateTime);

        try {
            notaXMLRepo.save(nota);
        } catch (ValidatorException e) {
            e.printStackTrace();
        }

        assertEquals(1, notaXMLRepo.getSize() - initialSize);
    }

    @Test
    public void addingIntegrationTest() {
        // add tema
        int initialSizeTeme = temaLabXMLRepo.getSize();

        int idTema = 100;
        String descriere = "ceva";
        int termenLimita = 2;
        int saptamanaPredarii = 2;

        TemaLab temaLab = new TemaLab(idTema, descriere, termenLimita, saptamanaPredarii);
        try {
            temaLabXMLRepo.save(temaLab);
        } catch (ValidatorException e) {
            e.printStackTrace();
        }

        assertEquals(1, temaLabXMLRepo.getSize() - initialSizeTeme);

        // add student
        int initialSizeStudents = studentXMLRepo.getSize();

        String idStudent = "11";
        String nume = "Iulia";
        Integer grupa = 932;
        String email = "i@i.com";
        String prof = "profa";
        Student student = new Student(idStudent, nume, grupa, email, prof);

        try {
            studentXMLRepo.save(student);
        } catch (ValidatorException e) {
            e.printStackTrace();
        }

        assertEquals(1, studentXMLRepo.getSize() - initialSizeStudents);

        // add nota
        int initialSizeNote = notaXMLRepo.getSize();

        Integer idNota = 1;
        String studentId = "11";
        Integer temaLabId = 1;
        Double valoareNota = 9.5;
        LocalDateTime localDateTime = LocalDateTime.now();
        Nota nota = new Nota(idNota, studentId, temaLabId, valoareNota, localDateTime);

        try {
            notaXMLRepo.save(nota);
        } catch (ValidatorException e) {
            e.printStackTrace();
        }

        assertEquals(1, notaXMLRepo.getSize() - initialSizeNote);
    }
}
