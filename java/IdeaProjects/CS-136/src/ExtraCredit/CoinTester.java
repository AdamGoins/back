package ExtraCredit;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Adam Goins on 3/12/17.
 * Extra Credit Homework, CoinTester
 *
 * The CoinTester class is created to generate an array of Coin objects and identify the index of the highest value coin
 */
public class CoinTester {

    /**
     * Random number generator
     */
    private Random random;


    /**
     * The main method
     * @param args: Command line arguments.
     */
    public static void main(String[] args){

        // We create a new instance of the CoinTester class to use the functionality of what it does.
        CoinTester tester = new CoinTester();

        // Creating a Coin array of size 5
        Coin[] coins = new Coin[5];

        // Creating 5 random coins to test with
        for(int i = 0; i < coins.length; i++){
            coins[i] = tester.getRandomCoin();
        }

        // These print statements just produce output..
        System.out.println("The Array is: " + Arrays.toString(coins));

        // Gets the highestIndex from the getHighestCoinIndex() method.
        int highestIndex = tester.getHighestCoinIndex(coins);
        System.out.println("\nThe index of the highest coin is: " + highestIndex);
        System.out.println("Index " + highestIndex + " is: " + coins[highestIndex]);
    }

    // Zero-arg Constructor
    public CoinTester(){
        // Instantiate new Random() object for random number generation.
        random = new Random();
    }

    /**
     * The getRandomCoin() method creates a new coin object by generating a random number 1-5 and assigning a coin
     * Value based on that number.
     *
     * @return Coin: The coin object created.
     */
    private Coin getRandomCoin(){
        Coin coin = null;

        // 5 different possible types of coins, so we grab a random number 1-5
        int random = getRandom(0, 5);

        // Switch statement to assign the coin value based on the random number
        switch(random) {
            case 0:
                coin = new Coin(1, "Penny");
                break;

            case 1:
                coin = new Coin(5, "Nickel");
                break;

            case 2:
                coin = new Coin(10, "Dime");
                break;

            case 3:
                coin = new Coin(25, "Quarter");
                break;

            case 4:
                coin = new Coin(50, "Half-Dollar");
                break;

            case 5:
                coin = new Coin(100, "Dollar");
                break;
        }
        return coin;
    }

    /**
     * The getRandom() method generates a random number within the bounds of the min/max values received in
     * The method parameters
     *
     * @param min: Min value the number should be
     * @param max: Max value the number should be (inclusive)
     * @return The randomly generated value that's within the range of the min/max arguments.
     */
    private int getRandom(int min, int max){

        // This is how we get the random number in bounds of min/max
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * The getHighestCoinIndex() method receives an array of Coin objects and uses their comparable interface
     * To determine which index in the array contains the coin of the highest value.
     *
     * @param coins: An array of Coin objects to be sorted through
     * @return int: The index of the highest coin value in the array
     */
    private int getHighestCoinIndex(Coin[] coins){
        // Index is 0 by default, this will be overridden when a coin of greater value is encountered.
        int index = 0;

        // Creates a new blank coin of value zero to begin comparing against.
        Coin coin = new Coin(0, "");

        // Loops through each coin and checks its value vs the value of the largest coin encountered (variable coin)
        // When a coin of greater value is encountered, it becomes the coin to compare against.
        // Whatever variable "i" is when a new largest coin is encountered is then assigned the the "index" variable to be returned
        // By this method.
        for(int i = 0; i < coins.length; i++){
            // Coin.compareTo() compares the value of the other coin to itself, and returns 1 if the other coin has a larger value.
            if(coins[i].compareTo(coin) == 1){

                // Assigns the index to the current value of "i", because this is the index of the current highest coin.
                index = i;

                // Sets the current highest coin to this coin to compare the other ones against.
                coin = coins[i];
            }
        }
        return index;
    }

}
