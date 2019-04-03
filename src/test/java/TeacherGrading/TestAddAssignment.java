package TeacherGrading;

import Domain.TemaLab;
import Exceptions.ValidatorException;
import Repository.XMLFileRepository.TemaLabXMLRepo;
import Validator.TemaLabValidator;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestAddAssignment {
    private TemaLabValidator temaLabValidator;
    private TemaLabXMLRepo temaLabXMLRepo;

    @Before
    public void setUp() {
        temaLabValidator = new TemaLabValidator();
        temaLabXMLRepo = new TemaLabXMLRepo(temaLabValidator, "TemaLabXML_test.xml");
    }

    @Test
    public void testValidAssignment() {
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

    @Test(expected = IllegalArgumentException.class)
    public void testNullAssignment() throws ValidatorException {
        TemaLab temaLab = null;

        temaLabXMLRepo.save(temaLab);
    }

    @Test(expected = ValidatorException.class)
    public void testInvalidDeadline() throws ValidatorException {
        int id = 100;
        String descriere = "ceva";
        int termenLimita = 0;
        int saptamanaPredarii = 2;

        TemaLab temaLab = new TemaLab(id, descriere, termenLimita, saptamanaPredarii);
        temaLabXMLRepo.save(temaLab);
    }
}
