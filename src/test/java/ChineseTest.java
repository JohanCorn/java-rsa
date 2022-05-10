import org.junit.jupiter.api.Test;
import rsa.Chinese;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChineseTest {

    private final Chinese chinese1 = new Chinese(new BigInteger("7"), new BigInteger("13"), new BigInteger("17"));
    private final Chinese chinese2 = new Chinese(new BigInteger("7"), new BigInteger("13"), new BigInteger("19"));
    private final Chinese chinese3 = new Chinese(new BigInteger("7"), new BigInteger("13"), new BigInteger("47"));

    @Test
    public void testDecrypt() {
        assertEquals(new BigInteger("10"), chinese1.decrypt(new BigInteger("82")));
        assertEquals(new BigInteger("20"), chinese2.decrypt(new BigInteger("6")));
        assertEquals(new BigInteger("15"), chinese3.decrypt(new BigInteger("85")));
    }
}
