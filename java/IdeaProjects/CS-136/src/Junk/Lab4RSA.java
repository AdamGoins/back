package Junk;

import java.math.BigInteger;

public class Lab4RSA{

    private BigInteger n;
    private BigInteger e;
    private BigInteger d;

  public BigInteger lcm(int num1, int num2){

    int base1 = num1;
    int base2 = num2;
    do{
        if(num1 > num2){

            num2 += base2;
        }

        else{

            num1 += base1;
        }
    }
    while(num1 != num2);
    return new BigInteger(Integer.toString(num1));

  }

  public void generateKeys(){


      // The commented code below is our test numbers for 61 and 53
      BigInteger p = new BigInteger("61");
      BigInteger q = new BigInteger("53");

      // Generates a BigIntger with size of 2^256
      // BigInteger p = new BigInteger(256, new Random());

      // Makes that BigInteger object prime
      // p = p.nextProbablePrime();

      // same as above
      // BigInteger q = new BigInteger(256, new Random());
      // q = q.nextProbablePrime();

      // Multiply the two together
      BigInteger n = p.multiply(q);

      // Do the lcm kinda stuff
      BigInteger t = lcm(p.intValue() - 1, q.intValue() - 1);


      // E is some BigInteger object
      BigInteger e = new BigInteger("17");
      //BigInteger e = new BigInteger(256, new Random());

      // This do-while loop ensures e is coprime to the totient "t"
      do {
          e = e.nextProbablePrime();//256, new Random());
      }

      while(t.intValue() % e.intValue() == 0);

      BigInteger d = e.modInverse(t);

      this.n = n;
      this.e = e;
      this.d = d;

    }

    public static void main(String[] args){

        Lab4RSA lab = new Lab4RSA();
        lab.generateKeys();

        BigInteger number = new BigInteger("65");

        BigInteger encrypted = lab.encrypt(number);
        BigInteger decrypted = lab.decrypt(encrypted);
        System.out.println(encrypted);
        System.out.println(decrypted);

    }


public BigInteger decrypt(BigInteger m){

    return m.pow(this.d.intValue()).mod(this.n);

}
public BigInteger encrypt(BigInteger m){

    System.out.println(m.pow(this.e.intValue()));
    return m.pow(this.e.intValue()).mod(this.n);

}

}
