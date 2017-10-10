/**
 * Created by Adam on 1/29/2017.
 */
import java.lang.Math;

public class Goins_Adam_HW1Question2 {

    public static void main(String[] args){

        System.out.println("After first year, balance is: $" + Math.round(getNewAccountBalance(1000, 1)));
        System.out.println("After second year, balance is: $" + Math.round(getNewAccountBalance(1000, 2)));
        System.out.println("After third year, balance is: $" + Math.round(getNewAccountBalance(1000, 3)));


    }

    public static double getNewAccountBalance(double accountBalance, int yearsInvested){
        double interestRate = .05;

        while(yearsInvested > 0){

            accountBalance = accountBalance + (accountBalance * interestRate);
            yearsInvested--;
        }

        return accountBalance;

    }

}
