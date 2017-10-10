/**
 * Created by root on 4/24/17.
 */
public class Pow {

    public static void main(String[] args){
        System.out.println(pow(5, 3));
    }

    public static long pow(int number, int power){
        return power == 0 ? 1 : number * pow(number, power - 1);
    }

}
