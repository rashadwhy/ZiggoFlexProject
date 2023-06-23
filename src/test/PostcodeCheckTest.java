import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PostcodeCheckTest {

    @Test
    public void testIsGeldig_ValidPostcode() {
        String validPostcode = "2152 EP";
        assertTrue(PostcodeCheck.isGeldig(validPostcode));
    }

    @Test
    public void testIsGeldig_InvalidPostcode_Format() {
        String invalidPostcode = "EP 2152";
        assertFalse(PostcodeCheck.isGeldig(invalidPostcode));
    }

    @Test
    public void testIsGeldig_InvalidPostcode_Range() {
        String invalidPostcode = "9999 YZ";
        assertFalse(PostcodeCheck.isGeldig(invalidPostcode));
    }
}
