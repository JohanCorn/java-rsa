import rsa.Chinese;
import rsa.Fermat;
import rsa.RSA;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        BigInteger first;
        do {
            System.out.println("Enter the 1ST Prime:");
            first = input.nextBigInteger();
        } while (!new Fermat(first).isProbablyPrime());

        BigInteger second;
        do {
            System.out.println("Enter the 2ND Prime:");
            second = input.nextBigInteger();
        } while (!new Fermat(second).isProbablyPrime());

        BigInteger randomNumber;
        RSA rsa = new RSA(first, second);
        do {
            randomNumber = new BigInteger(rsa.getN().subtract(BigInteger.ONE).bitLength(), random).add(BigInteger.ONE);
        } while (randomNumber.compareTo(rsa.getN()) >= 0);

        BigInteger encrypted = rsa.encrypt(randomNumber);
        BigInteger decrypted = rsa.decrypt(encrypted);
        System.out.printf("Random: %d\n", randomNumber);
        System.out.printf("Encrypted: %d\n", encrypted);
        System.out.printf("Decrypted: %d\n", decrypted);

        Chinese chinese = new Chinese(first, second, rsa.getD());
        BigInteger chineseDecrypted = chinese.decrypt(encrypted);
        System.out.printf("Chinese Decrypted: %d\n", chineseDecrypted);
    }
}
