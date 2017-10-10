/**
 * Created by root on 9/18/17.
 */
public class Helper {

    boolean swapARow(int[] data, int size)
    {
        return swapARowHelper(data, size, 0, false);
    }


    boolean swapARowHelper(int[] data, int size, int index, boolean swapped)
    {
        if (swapped)
        {
           return true;
        }
        if (index < size - 1)
        {
            int currentValue = data[index];
            int nextValue = data[index + 1];
            if (currentValue > nextValue)
            {
                int temp = currentValue;
                data[index] = data[index + 1];
                data[index + 1] = temp;
                swapped = true;
            }
            return swapARowHelper(data, size, index + 1, swapped);
        }
        return false;
    }

    private void bubbleSort(int[] data, int size)
    {
        boolean swapped = true;
        while ( swapped )
        {
            swapped = swapARow(data, size);
        }
    }

    public static void main(String[] args)
    {
        int[] myArray = {1, 2, 5, 2, 7, 0, 3, 21251,12351235, 123512351};

        Helper helper = new Helper();
        helper.bubbleSort(myArray, myArray.length);

     //   helper.printArray(myArray);
    }

    private void printArray(int[] data)
    {
        for (int i = 0; i < data.length; i++)
        {
            System.out.print(data[i] + ",\t");
        }
    }
}
