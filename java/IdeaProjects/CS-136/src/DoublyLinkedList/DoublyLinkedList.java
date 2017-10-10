package DoublyLinkedList;

import java.util.*;

/**
 * Matthew Yarbrough
 * Adam Goins
 * CS-136L Lab 9 DoublyLinkedList.DoublyLinkedList
 *
 * The DoublyLinkedList.DoublyLinkedList class implements the functionality of a linked list where all access/modifications are done using
 * A custom DoublyLinkedList.DoublyLinkedListIterator object.
 *
 * @param <E>: Generic Datatype
 */
public class DoublyLinkedList < E > extends AbstractSequentialList < E > implements List < E > {

    // Fields
    private Node < E > start;
    private int modCount;

    /**
     * Zero-arg constructor, initializes the base values of this class.
     */
    public DoublyLinkedList(){
        start = null;
        modCount = 0;
    }

    /**
     * The Add method receives a single datatype to add to the list. This method uses an iterator to move to
     * The end of the list and add a new DoublyLinkedList.Node containing the data as the last node in the last.
     *
     * @param data: The data to place in the node that will be added to the list.
     *
     * @return: True, indicating it was added to the list.
     */
    public boolean add(E data) {

        // The starting node is null to start, so if we add an item to the list we set the starting node to that item.
        if(start == null){
            start = new Node(data);
        }

        // If we have a starting node, we can now use a list iterator to move to the correct position and add the new
        // Data to that position
        else{
            // Creates the iterator
            DoublyLinkedListIterator iterator = getIterator();

            // Moves the iterator to the last position
            iterator.moveToEnd();

            // Calls the add() method on the iterator to add the new node as the last node in the list.
            iterator.add(new Node(data));

        }

        // We modified the list, therefore we increment modcount by one.
        modCount++;
        return true;
    }

    /**
     * This add method receives an index that indicates where to add to the list, as well as the data to be added.
     * It uses in iterator to loop through to the proper index and adds the element to the list once it's at the desired index.
     *
     * @param index: The index that we add the data to
     * @param element: The data to be added
     */
    public void add(int index, E element) {

        // If we call this method before we have a starting DoublyLinkedList.Node, and we try adding to the 0th position, we set the starting node to that new node.
        if(start == null && index == 0) start = new Node(element);

        // Creates a new iterator
        DoublyLinkedListIterator iterator = getIterator();

        // Calls the add() method on the iterator to insert the element at the index.
        iterator.add(index, element);

        // We modified the list, therefore we increment modcount by one.
        modCount++;
    }

    /**
     * This method receives a collection of data rather than a single element, and then adds each item in that collection
     * To the list where each consecutive item points to the next item in the list. A.K.A, it links the list linearly
     * In the order the elements are in the list.
     *
     * @param collection: The collection of elements we wish to add to the list.
     *
     * @return true, indicating the collection was added
     */
    public boolean addAll(Collection<? extends E> collection){

        // For every element in the collection
        for(E item : collection){

            // We call the add method passing in that individual item.
            add(item);

        }
        return true;
    }

    /**
     * The get() method receives the index of the list we wish to access and returns the item stored at that index.
     * This method uses a list iterator to move to the specified position and returns the node data located there
     *
     * @param index: The index to access
     *
     * @return E: The data stored at the specified index
     */
    public E get(int index) {
        return (E) getIterator().get(index);
    }

    /**
     * The set() method receives an index indicating which index to access, and the data to set that node data to.
     * It then calls the replace() method because they do the same thing, this method is just overriden from the superclass.
     *
     * @param index: The index of the node we wish to override the data of.
     * @param data: The data to override to
     *
     * @return E: The data that was set
     */
    public E set(int index, E data) {
        replace(index, data);
        return data;
    }

    /**
     * The replace() method receives an index indicating which index to access, and the data to set that node data to.
     * It uses a list iterator to move to that specified index and sets the data of the node at that index to the
     * Data received as an argument.
     *
     * @param index: The index of the node we wish to override the data of.
     * @param data: The data to override to
     *
     * @return E: The data that was set
     */
    public void replace(int index, E data){
        getIterator().replace(index, data);
    }

    /**
     * The remove() method receives the index of the node we wish to remove from the list.
     * The iterator is moved to the that index and the remove() method is called on the iterator to remove that node.
     *
     * @param index: Index of the node to be removed.
     *
     * @return E: The data of the starting node. Because we have to return data to override this method.
     */
    public E remove(int index) {

        // We create a reference node that is our starting node.
        Node newStart = start;
        // If we are removing the starting node, we have to make our starting node the next node in the series.
        if(index == 0) {
            newStart = start.getLinkNext();
        }

        // We then call the remove() method on the iterator object.
        getIterator().remove(index);

        // We set our starting node to the new starting node (be it new or the same one)
        start = newStart;

        // We've modified our list, therefore we increment our modcount.
        modCount++;

        // Return our starting node data.
        return start.getData();
    }


    /**
     * This method returns a new ListIterator where it starts at our starting node.
     *
     * @return: ListIterator of our list
     */
    public ListIterator < E > listIterator() {
        return new DoublyLinkedListIterator<>(start);
    }

    /**
     * This method returns a new ListIterator pointing to the specified index received as an argument
     *
     * @param index: The index the iterator should point to when it is returned.
     *
     * @return: ListIterator of our list.
     */
    public ListIterator < E > listIterator(int index) {
        // The 2-arg constructor of the DoublyLinkedList.DoublyLinkedListIterator moves to the specified index implicitly
        return new DoublyLinkedListIterator(this.start, index);

    }

    /**
     * This is a helper method that just returns a DoublyLinkedList.DoublyLinkedListIterator so that we can call this method rather than
     * Calling the listIterator (which returns a listIterator, not a DoublyLinkedList.DoublyLinkedListIterator) because otherwise we'd have to
     * cast the return of listIterator() as a DoublyLinkedList.DoublyLinkedList everytime we call it, this circumvents that.
     *
     * @return: DoublyLinkedList.DoublyLinkedListIterator pointing to the start of our list.
     */
    private DoublyLinkedListIterator getIterator(){
        return (DoublyLinkedListIterator) iterator();
    }

    /**
     * Returns the size of the list by creating a listIterator and looping through all the nodes, coutning each loop and returning
     * That count, which is the size of the list.
     *
     * @return: Size of the list.
     */
    public int size() {
        return getIterator().getSize();
    }

    /**
     * Returns how many times we've modified this list.
     *
     * @return: Number of modifications done.
     */
    public int getModCount(){
        return modCount;
    }

    /**
     * The getFirst() method creates a listIterator object and calls the getFirst() method on it, returning the first node
     * In the list.
     *
     * @return: The starting node (first element)
     */
    public E getFirst(){
        return (E) getIterator().getFirst();
    }

    /**
     * the display() method creates a listIterator object and calls the display() method on it, looping through all nodes and displaying
     * The index and value of each node in the list.
     */
    public void display(){
        getIterator().display();
    }

    /**
     * Displays data about the list.
     */
    public void show(){
        System.out.println("Displaying list Data...\n");
        System.out.println("Size of list: " + size());
        System.out.println("Modifications: " + getModCount());
        System.out.println("Start:" + getIterator().getFirst());
        getIterator().show();
    }
}
