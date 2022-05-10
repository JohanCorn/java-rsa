package rsa;

import java.math.BigInteger;

public class Miller {

    private final boolean result;

    public Miller(BigInteger n, BigInteger a) {
        BigInteger t = n.subtract(BigInteger.ONE);
        int s = 0;

        while (t.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            t = t.divide(BigInteger.TWO);
            s++;
        }

        BigInteger d = n.subtract(BigInteger.ONE).divide(BigInteger.TWO.pow(s));
        boolean[] r = new boolean[2];

        if (new Quick(a, d, n).getResult().mod(n).equals(BigInteger.ONE)) {
            r[0] = true;
        }

        for (int i = 0; i < s; i++) {
            BigInteger y = new Quick(a, d.multiply(BigInteger.TWO.pow(i)), n).getResult();
            if (y.mod(n).equals(n.subtract(BigInteger.ONE))) {
                r[1] = true;
                break;
            }
        }

        this.result = r[0] || r[1];
    }

    public boolean isProbablyPrime() {
        return result;
    }
}
