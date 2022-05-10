import org.junit.jupiter.api.Test;
import rsa.Quick;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickTest {

    private final Quick quick1 = new Quick(new BigInteger("6"), new BigInteger("73"), new BigInteger("100"));
    private final Quick quick2 = new Quick(new BigInteger("129"), new BigInteger("97"), new BigInteger("171"));

    @Test
    public void testResult() {
        assertEquals(new BigInteger(String.valueOf(96 * 16 * 6)), quick1.getResult());
        assertEquals(new BigInteger(String.valueOf(99 * 36 * 129)), quick2.getResult());
    }
}
