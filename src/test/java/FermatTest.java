import org.junit.jupiter.api.Test;
import rsa.Fermat;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FermatTest {

    private final Fermat fermat1 = new Fermat(new BigInteger("341"), new BigInteger("2"));
    private final Fermat fermat2 = new Fermat(new BigInteger("341"), new BigInteger("3"));
    private final Fermat fermat3 = new Fermat(new BigInteger("3"));
    private final Fermat fermat4 = new Fermat(new BigInteger("9"));

    @Test
    public void testValueR() {
        assertTrue(fermat1.isProbablyPrime());
        assertFalse(fermat2.isProbablyPrime());
        assertTrue(fermat3.isProbablyPrime());
        assertFalse(fermat4.isProbablyPrime());
    }
}
