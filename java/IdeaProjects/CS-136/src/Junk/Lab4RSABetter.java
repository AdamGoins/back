package Junk;

import java.math.BigInteger;
import java.util.Random;

public class Lab4RSABetter{


    private BigInteger n;
    private BigInteger e;
    private BigInteger d;

  public BigInteger lcm(BigInteger num1, BigInteger num2){

    // the lcm equation
    return num1.multiply(num2.divide(num1.gcd(num2)));

  }

  public void generateKeys(){


      // The commented code below is our test numbers for 61 and 53
      //BigInteger p = new BigInteger("61");
      //BigInteger q = new BigInteger("53");

      // Generates a BigIntger with size of 2^256
      BigInteger p = new BigInteger(256, new Random());

      // Makes that BigInteger object prime and checks that it is prime
      while (p.isProbablePrime(1) == false){

        p = p.nextProbablePrime();

      }

      // same as above
      BigInteger q = new BigInteger(256, new Random());
      while (q.isProbablePrime(1) == false){

        q = q.nextProbablePrime();

      }

      // Multiply the two together
      BigInteger n = p.multiply(q);

      // Do the lcm with p-1 and q-1
      BigInteger t = lcm(p.subtract(BigInteger.ONE), q.subtract(BigInteger.ONE));


      // e is some BigInteger object
      BigInteger e = new BigInteger("17");

      // This do-while loop ensures e is coprime to the totient "t"
      while(t.remainder(e) == BigInteger.ZERO) {
        do {

          e = e.nextProbablePrime();

        }while (e.isProbablePrime(100) == false);
      }

      BigInteger d = e.modInverse(t);

      this.n = n;
      this.e = e;
      this.d = d;

      // prints all the values
      System.out.println("The value of p is: " + p);
      System.out.println("The value of q is: " + q);
      System.out.println("The value of n is: " + n);
      System.out.println("The value of e is: " + e);
      System.out.println("The value of d is: " + d);
    }

    public static void main(String[] args){

        Lab4RSABetter lab = new Lab4RSABetter();
        // generates keys
        lab.generateKeys();

        // chooses the number to encrypt and decrypt
        BigInteger number = new BigInteger("65");
        System.out.println("The value of the number is: " + number);

        // encrypts, decrypts, and the prints both values
        BigInteger encrypted = lab.encrypt(number);
        BigInteger decrypted = lab.decrypt(encrypted);
        System.out.println("The number encrypted is: " + encrypted);
        System.out.println("The number decrypted is: " + decrypted);

    }


public BigInteger decrypt(BigInteger m){

    return m.modPow(this.d, this.n);

}
public BigInteger encrypt(BigInteger m){

    return m.modPow(this.e, this.n);

}

}
