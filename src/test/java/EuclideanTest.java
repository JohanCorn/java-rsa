import org.junit.jupiter.api.Test;
import rsa.Euclidean;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

public class EuclideanTest {

    private final Euclidean euclidean1 = new Euclidean(new BigInteger("112"), new BigInteger("63"));
    private final Euclidean euclidean2 = new Euclidean(new BigInteger("280"), new BigInteger("3"));

    @Test
    void testGetGCD() {
        assertEquals(new BigInteger("7"), euclidean1.getResult());
        assertEquals(new BigInteger("1"), euclidean2.getResult());
    }

    @Test
    void testIsRelativelyPrime() {
        assertFalse(euclidean1.isRelativelyPrime());
        assertTrue(euclidean2.isRelativelyPrime());
    }

    @Test
    void testLastX() {
        assertEquals(new BigInteger("4"), euclidean1.getLastX());
        assertEquals(new BigInteger("1"), euclidean2.getLastX());
    }

    @Test
    void testLastY() {
        assertEquals(new BigInteger("-7"), euclidean1.getLastY());
        assertEquals(new BigInteger("-93"), euclidean2.getLastY());
    }
}
