package rsa;

import java.math.BigInteger;

public class RSA {

    private final BigInteger n, f;
    private BigInteger e, d;

    public RSA(BigInteger p, BigInteger q, BigInteger e) {
        this.n = p.multiply(q);
        this.f = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        this.e = e;
        Euclidean euclidean = new Euclidean(f, this.e);
        this.d = euclidean.getLastY();
        if (this.d.compareTo(BigInteger.ZERO) < 0)
            this.d = d.add(f);
    }

    public RSA(BigInteger p, BigInteger q) {
        this.n = p.multiply(q);
        this.f = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        this.e = BigInteger.TWO;
        this.d = BigInteger.ONE;

        Euclidean euclidean;
        while (this.e.compareTo(f) < 0) {
            euclidean = new Euclidean(f, this.e);
            if (euclidean.isRelativelyPrime()) {
                this.d = euclidean.getLastY();
                break;
            } else {
                this.e = this.e.add(BigInteger.ONE);
            }
        }

        if (this.d.compareTo(BigInteger.ZERO) < 0) {
            this.d = d.add(f);
        }
    }

    public BigInteger getN() {
        return n;
    }

    public BigInteger getF() {
        return f;
    }

    public BigInteger getD() {
        return d;
    }

    public BigInteger encrypt(BigInteger m) {
        return m.pow(e.intValue()).mod(n);
    }

    public BigInteger decrypt(BigInteger c) {
        return c.pow(d.intValue()).mod(n);
    }
}
