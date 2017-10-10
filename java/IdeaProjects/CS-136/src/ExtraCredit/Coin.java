package ExtraCredit;

/**
 * Created by Adam Goins on 3/10/17.
 *
 * Extra Credit Homework
 * 2017.03.12
 *
 * The Coin class implements the Comparable interface and is designed to represent a Coin.
 * Coins have two fields, a numeric value and a name. The comparable interface allows them to be compared with other coins.
 */
public class Coin implements Comparable {

    /**
     * The value and name of the coin are the only fields of this class
     */
    private double value;
    private String name;

    /**
     * Two-Argument constructor, receives the value of the coin and the name of the coin.
     *
     * @param aValue: The value this instance of a coin holds.
     * @param aName: The name of this kind of coin
     */
    public Coin(double aValue, String aName){
        // Sets instance variables to values received.
        this.value = aValue;
        this.name = aName;
    }

    /**
     * Returns the value of the coin.
     * @return double: The value of the coin.
     */
    public double getValue(){
        return value;
    }

    /**
     * Returns the name of the coin.
     * @return String: The name of the coin.
     */
    public String getName(){
        return name;
    }

    /**
     * The toString() method is being overridden by the Object class to display the attributes of the Coin object in
     * A format that I deem appropriate.
     */
    @Override
    public String toString(){
        return "Name: " + name + " Value: " + value;
    }

    /**
     * The compareTo() method is being overridden by the Comparable interface.
     * It receives an Object and casts it as a Coin object to do the comparison.
     * The value of this instance of coin is then compared to the second coin and if the second coin is bigger, a 0 is returned.
     * If this coin is larger than the coin being compared, a 1 is returned instead.
     * @param o: The object to compare against.
     * @return int: 1 if this coin is larger than the other coin, otherwise a 0.
     */
    @Override
    public int compareTo(Object o) {
        return this.getValue() > ((Coin) o).getValue() ? 1 : 0;
    }
}
