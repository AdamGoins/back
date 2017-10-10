/**
 * Created by root on 4/24/17.
 */
public class Fib {

    public static void main(String[] args){
        System.out.println(fib(10));
    }

    public static int fib(int n){
        return n <= 2 ? 1 : fib(n - 1) + fib(n - 2);
    }

}
