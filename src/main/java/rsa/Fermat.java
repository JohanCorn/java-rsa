package rsa;

import java.math.BigInteger;

public class Fermat {

    private boolean result;

    public Fermat(BigInteger n, BigInteger a) {
        result = new Quick(a, n.subtract(BigInteger.ONE), n).getResult().mod(n).equals(BigInteger.ONE.mod(n));
    }

    public Fermat(BigInteger n) {
        BigInteger a = BigInteger.TWO;
        for (int i = 0; i < 10; i++) {
            if (new Euclidean(a, n).isRelativelyPrime()) {
                result = new Quick(a, n.subtract(BigInteger.ONE), n).getResult().mod(n).equals(BigInteger.ONE.mod(n));
                return;
            } else
                a = a.add(BigInteger.ONE);
        }
    }

    public boolean isProbablyPrime() {
        return result;
    }
}
