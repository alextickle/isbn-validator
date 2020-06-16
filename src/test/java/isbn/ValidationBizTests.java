package isbn;

import org.junit.Test;
import org.junit.Before;
import isbn.biz.ValidationBiz;
import isbn.protocol.IsbnNumber;

import static org.junit.Assert.*;

public class ValidationBizTests {

    private ValidationBiz validationBiz;

    @Before
    public void init() {
        validationBiz = new ValidationBiz();
    }

    @Test
    public void testValidateSingleIsbn10Digits() {

        IsbnNumber isbnNumber = new IsbnNumber();
        isbnNumber.setNumber("124342");
        isbnNumber.setType(10);
        assertFalse(validationBiz.validateSingleIsbn(isbnNumber));
        isbnNumber.setNumber("0198526636");
        assertTrue(validationBiz.validateSingleIsbn(isbnNumber));
    }

    @Test
    public void testValidateSingleIsbn13Digits() {
        IsbnNumber isbnNumber = new IsbnNumber();
        isbnNumber.setNumber("124342");
        isbnNumber.setType(13);
        assertFalse(validationBiz.validateSingleIsbn(isbnNumber));
        isbnNumber.setNumber("9781861978769");
        assertTrue(validationBiz.validateSingleIsbn(isbnNumber));
    }

}
