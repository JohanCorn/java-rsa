package rsa;

import java.math.BigInteger;

public class Quick {

    private BigInteger result = BigInteger.ONE;

    public Quick(BigInteger b, BigInteger e, BigInteger m) {
        int i = 0;
        while (!e.equals(BigInteger.ZERO)) {
            if (e.mod(BigInteger.TWO).equals(BigInteger.ONE)) {
                result = result.multiply(b.pow((int) Math.pow(2, i)).mod(m));
            }
            e = e.divide(BigInteger.TWO);
            i++;
        }
    }

    public BigInteger getResult() {
        return result;
    }
}
