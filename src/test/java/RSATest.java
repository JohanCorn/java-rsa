import org.junit.jupiter.api.Test;
import rsa.RSA;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RSATest {

    private final RSA rsa1 = new RSA(new BigInteger("3"), new BigInteger("11"), new BigInteger("7"));
    private final RSA rsa2 = new RSA(new BigInteger("463"), new BigInteger("547"), new BigInteger("47"));

    @Test
    public void testValueN() {
        assertEquals(new BigInteger("33"), rsa1.getN());
        assertEquals(new BigInteger("253261"), rsa2.getN());
    }

    @Test
    public void testValueF() {
        assertEquals(new BigInteger("20"), rsa1.getF());
        assertEquals(new BigInteger("252252"), rsa2.getF());
    }

    @Test
    public void testValueD() {
        assertEquals(new BigInteger("3"), rsa1.getD()); // A 2018-as mf-ben 23. Az is jó.
        assertEquals(new BigInteger("166379"), rsa2.getD());
    }

    @Test
    public void testEncrypt() {
        assertEquals(new BigInteger("29"), rsa1.encrypt(new BigInteger("2")));
    }

    @Test
    public void testDecrypt() {
        assertEquals(new BigInteger("2"), rsa1.decrypt(new BigInteger("29")));
    }

    @Test
    public void testEncryptAndDecrypt() {
        assertEquals(new BigInteger("2"), rsa1.decrypt(rsa1.encrypt(new BigInteger("2"))));
        assertEquals(new BigInteger("20"), rsa2.decrypt(rsa2.encrypt(new BigInteger("20"))));
    }
}
