package Junk;

import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Created by root on 2/20/17.
 */
public class StallHandler2 {

    int[] stalls;
    int numStalls;
    int temp;

    public StallHandler2(int numStalls) {
        this.stalls = new int[numStalls];
        this.numStalls = numStalls;
        this.temp = 0;
        Arrays.fill(this.stalls, 0);

    }


    public static void main(String[] args) {


    }

    public int[] fillNextAvailableStall(int[] myArray) {

        int[] firstHalf = new int[myArray.length / 2];
        int[] secondHalf = new int[(myArray.length) + 1];
        if (temp == 0) {
            this.stalls = new int[numStalls];
        }


        int total1 = 0;
        int total2 = 0;

        for (int num : firstHalf) {
            total1 += num;
        }
        for (int num : secondHalf) {
            total2 += num;
        }

        if (total1 > total2) {
            int length = secondHalf.length;
            int value = secondHalf[length / 2];

            if (value == 0) {
                secondHalf[length / 2] = 1;
                return secondHalf;
            }

            switch (length) {

                case 1:

                    break;

                case 2:

                    break;

                default:

                    break;

            }
        }

        //arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
        return new int[]{1};
    }

}
