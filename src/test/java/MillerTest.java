import org.junit.jupiter.api.Test;
import rsa.Miller;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MillerTest {

    private final Miller miller1 = new Miller(new BigInteger("561"), new BigInteger("2"));
    private final Miller miller2 = new Miller(new BigInteger("561"), new BigInteger("13"));
    private final Miller miller3 = new Miller(new BigInteger("197"), new BigInteger("7"));
    private final Miller miller4 = new Miller(new BigInteger("197"), new BigInteger("12"));
    private final Miller miller5 = new Miller(new BigInteger("243"), new BigInteger("11"));
    private final Miller miller6 = new Miller(new BigInteger("243"), new BigInteger("15"));

    @Test
    public void testValueR() {
        assertFalse(miller1.isProbablyPrime());
        assertFalse(miller2.isProbablyPrime());
        assertTrue(miller3.isProbablyPrime());
        assertTrue(miller4.isProbablyPrime());
        assertFalse(miller5.isProbablyPrime());
        assertFalse(miller6.isProbablyPrime());
    }
}
