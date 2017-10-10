



















/**
 * Created by Adam Goins on 9/5/17.
 * CS-249 Assignment 1: GenericArrayClass
 *
 * @author Adam Goins
 *
 * The GenericArrayClass will act as a modified Array to demonstrate understanding of the datastructure
 */
public class GenericArrayClass<GenericData>
{

    private int arrayCapacity;
    private int arraySize;
    private final static int DEFAULT_CAPACITY = 10;
    static final int FAILED_ACCESS = -999999;
    private Object[] localArray;


    /**
     * Default Constructor, initializes array to default capacity (10)
     */
    public GenericArrayClass() {
        this.arrayCapacity = DEFAULT_CAPACITY;
        this.arraySize = 0;
        this.localArray = new Object[arrayCapacity];
    }

    /**
     * Copy constructor, initializes array to size and capacity of copied array,
     * then copies only elements up to the given size
     *
     * @param copied The GenericArrayClass that will be copied
     */
    public GenericArrayClass(GenericArrayClass copied)
    {
        this.arraySize = copied.getCurrentSize();
        this.arrayCapacity = copied.getCurrentCapacity();
        this.localArray = new Object[arrayCapacity];

        int indexIterator;

        for (indexIterator = 0; indexIterator < arraySize; indexIterator++)
        {
            try
            {
                localArray[indexIterator] = copied.accessItemAt(indexIterator);
            }
            catch (Exception caughtException)
            {
                caughtException.printStackTrace();
            }
        }
    }

    /**
     * Initializing constructor, initializes array to specified capacity.
     *
     * @param arrayCapacity The capacity of the array
     */
    public GenericArrayClass(int arrayCapacity)
    {

        if (arrayCapacity < 0)
        {
            return;
        }

        this.arrayCapacity = arrayCapacity;
        this.arraySize = 0;
        this.localArray = new Object[arrayCapacity];
    }


    /**
     * <p>
     *     The Bubble Sort loops through the array and compares the element at the current index with the element to
     * the right. If the element to the right is smaller than the current element then we swap the two.
     * </p>
     */
    public void runBubbleSort()
    {
        int outerLoopStart;
        int innerLoopStart;

        StudentClass student;
        StudentClass otherStudent;

        GenericData temp;

        for (outerLoopStart = getCurrentSize() - 1; outerLoopStart > 0; outerLoopStart--)
        {
            for (innerLoopStart = 0; innerLoopStart < outerLoopStart; innerLoopStart++)
            {
                student = (StudentClass) accessItemAt(innerLoopStart);
                otherStudent = (StudentClass) accessItemAt(innerLoopStart + 1);

                if (student.compareTo(otherStudent) == 1)
                {
                    temp = accessItemAt(innerLoopStart);
                    this.localArray[innerLoopStart] = this.localArray[innerLoopStart + 1];
                    this.localArray[innerLoopStart + 1] = temp;
                }
            }
        }
    }

    /**
     * <p>
     *     The Insertion sort starts at the beginning of an array and compares every item with every item to the left
     *     until the value to the left is less than the current value.
     * </p>
     */
    public void runInsertionSort()
    {
        int indexIterator;
        int currentPosition;

        for (indexIterator = 0; indexIterator < getCurrentSize(); indexIterator++)
        {

            currentPosition = indexIterator;

            while (currentPosition > 0 &&
                    (( (StudentClass) accessItemAt(currentPosition) ).compareTo(
                       (StudentClass) accessItemAt(currentPosition - 1)) ) == -1)
            {
                this.localArray[currentPosition] = this.localArray[currentPosition - 1];
                currentPosition = currentPosition - 1;
            }
            this.localArray[currentPosition] = accessItemAt(indexIterator);
        }
    }


    /**
     * <p>
     *     The selection sort looks at the current item in an array and assumes it's the minimum item.
     *     It then loops through every element in the array and checks it against the min element. If a new minimum
     *     Is encountered, it is recorded. Once the index of the minimum element is found, it swaps the
     *     Min index with the item at the current iteration.
     * </p>
     */
    public void runSelectionSort()
    {
        int indexIterator;
        int exitCondition = getCurrentSize() - 1;
        int minIndex;
        int innerIndexIterator;

        StudentClass currentStudent;
        StudentClass otherStudent;

        GenericData temp;

        for (indexIterator = 0; indexIterator < exitCondition; indexIterator++)
        {
            minIndex = indexIterator;

            for (innerIndexIterator = indexIterator; innerIndexIterator < exitCondition; indexIterator++)
            {
                currentStudent = (StudentClass) accessItemAt(innerIndexIterator);
                otherStudent = (StudentClass) accessItemAt(minIndex);
                if (currentStudent.compareTo(otherStudent) == -1)
                {
                    minIndex = innerIndexIterator;
                }
            }
            temp = accessItemAt(minIndex);
            this.localArray[minIndex] = this.localArray[indexIterator];
            this.localArray[indexIterator] = temp;
        }
    }


    /**
     * Accesses item in array at specified index if index within array size bounds
     *
     * @param accessIndex The index to access the GenericArrayClass at
     * @return The item at the specified index
     */
    GenericData accessItemAt(int accessIndex)
    {
        int indexBounds = getCurrentSize();

        if (accessIndex >= 0 && accessIndex < indexBounds)
        {
            return (GenericData) localArray[accessIndex];
        }
        return  null;
    }

    /**
     * Appends item to end of array, if array is not full, e.g., no more values can be added
     *
     * @param newValue The value to be appended to the GenericArrayClass
     * @return True or false if the newValue was successfully added to the GenericArrayClass or not.
     */
    boolean appendItem(GenericData newValue)
    {
        int currentSize = getCurrentSize();
        int currentCapacity = getCurrentCapacity();

        if (currentSize == currentCapacity)
        {
            return false;
        }
        else
        {
            localArray[currentSize] = newValue;
            this.arraySize++;
            return true;
        }
    }

    /**
     * Clears array of all valid values by setting array size to zero, values remain in array but are not accessible
     */
    void clear()
    {
        this.arraySize = 0;
    }

    /**
     * Description: Gets current capacity of array
     *
     * @return The capacity of the GenericArrayClass
     */
    int getCurrentCapacity()
    {
        return this.arrayCapacity;
    }

    /**
     * Description: Gets current size of array
     *
     * @return The current size of the array.
     */
    int getCurrentSize()
    {
        return this.arraySize;
    }


    /**
     * Description: Inserts item to array at specified index if array is not full, e.g., no more values can be added
     *
     * @param insertIndex The index to insert the value at
     * @param newValue    The value to insert into the GenericArrayClass
     *
     * @return True or false if the item was successfully inserted or not
     */
    boolean insertItemAt(int insertIndex, GenericData newValue)
    {
        int indexLowerBound = 0;
        int indexUpperBound = getCurrentCapacity() - 1;
        if (isFull() || insertIndex < indexLowerBound || insertIndex > indexUpperBound)
        {
            return false;
        }

        int indexIterator;
        int indexShift = 2;
        int startIndex = getCurrentCapacity() - indexShift;
        for (indexIterator = startIndex; indexIterator >= insertIndex; indexIterator--)
        {
            localArray[indexIterator + 1] = localArray[indexIterator];
        }
        localArray[insertIndex] = newValue;
        this.arraySize++;

        return true;
    }


    /**
     * Tests for size of array equal to zero, no valid values stored in array
     *
     * @return Returns true or false if the GenericArrayClass is empty or not
     */
    boolean isEmpty()
    {
        return getCurrentSize() == 0;
    }

    /**
     * Tests for size of array equal to capacity, no more values can be added
     *
     * @return True of false if the GenericArrayClass is full or not
     */
    boolean isFull()
    {
        return getCurrentSize() == getCurrentCapacity();
    }

    /**
     * Description: Removes item from array at specified index if index within array size bounds
     *
     * @param removeIndex The index to remove the item at
     *
     * @return The value of the array at that index
     */
    GenericData removeItemAt(int removeIndex)
    {
        if (removeIndex < 0 || removeIndex >= getCurrentSize())
        {
            return null;
        }
        else
        {
            GenericData valueToRemove = accessItemAt(removeIndex);
            int indexIterator;
            int exitCondition = getCurrentCapacity() - 1;

            int nextIndex;
            for (indexIterator = removeIndex; indexIterator < exitCondition; indexIterator++)
            {
                nextIndex = indexIterator + 1;
                localArray[indexIterator] = localArray[nextIndex];
            }
            this.arraySize--;
            return valueToRemove;
        }
    }

    /**
     * Description: Resets array capacity, copies current size and current size number of elements
     *
     * @param newCapacity The new capacity that the GenericArrayClass should be
     *
     * @return True of False if the capacity was a valid capacity or not.
     */
    boolean resize(int newCapacity)
    {
        if (newCapacity <= getCurrentSize())
        {
            return false;
        }
        else
        {
            this.arrayCapacity = newCapacity;

            GenericArrayClass tempArray = new GenericArrayClass(this);
            this.localArray = new Object[getCurrentCapacity()];

            int indexIterator;
            int exitCondition = getCurrentSize();

            for (indexIterator = 0; indexIterator < exitCondition; indexIterator++)
            {
                localArray[indexIterator] = tempArray.accessItemAt(indexIterator);
            }
            return true;
        }
    }

    /**
     * Displays the contents of the array as a string
     *
     * @return A string representation of the data contained in the GenericArrayClass
     */
    @Override
    public String toString()
    {
        if (getCurrentSize() == 0)
        {
            return "";
        }

        String returnString = "\t";
        int indexIterator;
        int exitCondition = getCurrentSize() - 1;

        for (indexIterator = 0; indexIterator < exitCondition; indexIterator++)
        {
            GenericData arrayItem = accessItemAt(indexIterator);
            returnString += arrayItem + ",\t";
        }
        GenericData lastItem = accessItemAt(exitCondition);
        returnString += lastItem;

        return returnString;
    }
}