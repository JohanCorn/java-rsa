package rsa;

import java.math.BigInteger;

public class Chinese {

    private final BigInteger p, q, d;

    public Chinese(BigInteger p, BigInteger q, BigInteger d) {
        if (q.compareTo(p) < 0) {
            BigInteger t = p;
            p = q;
            q = t;
        }

        this.p = p;
        this.q = q;
        this.d = d;
    }

    public BigInteger decrypt(BigInteger c) {
        BigInteger c1 = c.pow(d.mod(p.subtract(BigInteger.ONE)).intValue()).mod(p);
        BigInteger c2 = c.pow(d.mod(q.subtract(BigInteger.ONE)).intValue()).mod(q);
        Euclidean euclidean = new Euclidean(p, q);
        BigInteger y1 = euclidean.getLastX(), y2 = euclidean.getLastY();
        return c1.multiply(q).multiply(y1).add(c2.multiply(p).multiply(y2)).mod(p.multiply(q));
    }
}
