/**
 * Created by Adam on 1/29/2017.
 */
public class Goins_Adam_HW1Question3 {

    public static void main(String[] args){


        System.out.println("It takes " + getYearsToDepleteAccount(10000) + " year(s) for the account to deplete.");
    }

    public static double getYearsToDepleteAccount(double accountBalance){

        double monthlyRate = .005;
        int monthCounter = 0;
        while(accountBalance > 0){
            accountBalance = accountBalance + (accountBalance * monthlyRate);

            accountBalance -= 500;
            monthCounter++;
        }

        double yearsNeeded = (double) monthCounter / 12;

        return yearsNeeded;


    }


}
