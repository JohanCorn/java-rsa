package rsa;

import java.math.BigInteger;

public class Euclidean {

    private BigInteger lastX, lastY, result;

    public Euclidean(BigInteger a, BigInteger b) {
        if (a.compareTo(b) < 0) {
            BigInteger c = a;
            a = b;
            b = c;
        }

        BigInteger r, q, t;
        this.lastX = BigInteger.ONE;
        BigInteger x = BigInteger.ZERO;
        this.lastY = BigInteger.ZERO;
        BigInteger y = BigInteger.ONE;

        while (!b.equals(BigInteger.ZERO)) {
            result = b;
            r = a.mod(b);
            q = a.divide(b);
            a = b;
            b = r;

            t = x;
            x = lastX.subtract(q.multiply(x));
            lastX = t;

            t = y;
            y = lastY.subtract(q.multiply(y));
            lastY = t;
        }
    }

    public BigInteger getResult() {
        return result;
    }

    public Boolean isRelativelyPrime() {
        return getResult().equals(BigInteger.ONE);
    }

    public BigInteger getLastX() {
        return lastX;
    }

    public BigInteger getLastY() {
        return lastY;
    }
}