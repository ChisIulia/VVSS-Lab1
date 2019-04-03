//package TeacherGrading;
//
//import Domain.TemaLab;
//import Exceptions.ValidatorException;
//import Repository.XMLFileRepository.StudentXMLRepo;
//import Repository.XMLFileRepository.TemaLabXMLRepo;
//import Validator.StudentValidator;
//import Validator.TemaLabValidator;
//import org.junit.Before;
//import org.junit.Test;
//
//import static junit.framework.TestCase.assertEquals;
//
//public class TestAddAssignment {
//    private TemaLabValidator temaLabValidator;
//    private TemaLabXMLRepo studentXMLRepo;
//
//    @Before
//    public void setUp() {
//        temaLabValidator = new StudentValidator();
//        studentXMLRepo = new StudentXMLRepo(temaLabValidator, "StudentiXML_test.xml");
//    }
//
//    @Test
//    public void testNullAssignment() {
//        TemaLab temaLab = null;
//
//        try {
//
//        } catch (ValidatorException e) {
//            e.printStackTrace();
//        }
//
//        assertEquals(1, studentXMLRepo.getSize() - initialSize);
//    }
//}
