package DoublyLinkedList;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Matthew Yarbrough
 * Adam Goins
 * CS-136L Lab 9 DoublyLinkedList.DoublyLinkedList
 *
 * The DoublyLinkedList.DoublyLinkedListIterator class implements a ListIterator and is used to traverse the DoublyLinkedList.DoublyLinkedList object
 * That this lab is designed around.
 *
 * @param <E>: Generic Datatype
 */
class DoublyLinkedListIterator < E > implements ListIterator {

    // Fields
    private int nextIndex;
    private Node nextNode;
    private Node previousNode;

    /**
     * The single arg constructor receives a node that is the starting node that will be used to traverse up and down
     * The node hierarchy.
     *
     * @param n: The starting node used to traverse up and down the node hierarchy
     *
     */
    public DoublyLinkedListIterator(Node n){
        // Initializes values
        this.nextNode = n;
        this.previousNode = n.hasPrev() ? n.getLinkPrev() : null;
        this.nextIndex = 0;
    }

    /**
     * The two arg constructor receives a node that is the starting node that will be used to traverse up and down
     * The node hierarchy, as well as the index that we want to traverse to
     *
     * @param node: The starting node used to traverse up and down the node hierarchy
     * @param index: The index to traverse to
     *
     */
    public DoublyLinkedListIterator(Node node, int index) {
        this.nextNode = node;
        this.previousNode = node.hasPrev() ? node.getLinkPrev() : null;
        moveTo(index);
    }

    /**
     * Adds an element before the iterator position
     * and moves the iterator past the inserted element.
     *
     * @param element the element to add
     */
    public void add(Object element) {

        // Creates a new node out of the element we want to add
        Node node = (Node) element;

        // If the nextNode is null, we make the next node the new node to be added
        if(this.nextNode == null) {
            this.nextNode = node;
        }

        // Otherwise we add the node to the current position
        else {

            // If there is a next node, we must set its previous node to the node being added
            if (hasNext()) {

                // Links the next node and the new node to each other
                Node next = this.nextNode.getLinkNext();
                next.setLinkPrev(node);

                node.setLinkNext(next);
                node.setLinkPrev(this.nextNode);
                this.nextNode.setLinkNext(node);
            }

            // Links the previous node to this node
            else{
                node.setLinkPrev(this.nextNode);
                this.nextNode.setLinkNext(node);
            }


            // Moves the iterator to the next position after adding.
            next();
        }
    }

    /**
     * Adds an element at the specified index. It points the iterator to that index - 1  because we add before that index
     *
     * @param index: The index to move the pointer to
     * @param element: The element to add
     */
    public void add(int index, E element){
        // Moves the iterator to the specified index - 1 because we want to add before that index
        // If the index is 0, it remains as 0
        moveTo(index > 0 ? index - 1 : 0);

        // Adds the new node to the proper index
        add(new Node(element));

    }

    /**
     * the get() method receives the index of the node you wish to grab the data of, loops to that index, and returns
     * The data of the node located at that position.
     *
     * @param index: The index of the node to access
     *
     * @return E: The data stored in the node
     */
    public E get(int index){
        // Creates the placeholder node. We don't want to mutate where we're at, only access a node at the specified location
        Node node = this.nextNode;

        // Loops down to the desired index if we're currently pointing at an index above the desired index.
        while(index < this.nextIndex){
            node = node.getLinkPrev();
            index++;
        }

        // Loops up to the desired index if we're currently pointing at an index before the desired index.
        while(index > this.nextIndex){
            node = node.getLinkNext();
            index--;
        }

        // Returns the data of the node at that index
        return (E) node.getData();
    }

    /**
     * The next() method moves up the node hierarchy and returns the node at the next position. If next is called when
     * There is no next node, this method throws the NoSuchElementException consistent with problem constraints.
     *
     * @return E: The data stored in the node at the next position
     */
    public E next() {


        // If there is no next node, we throw the NoSuchElementException
        if (nextNode == null) throw new NoSuchElementException();

        // Otherwise, this is the next node.
        Node node = this.nextNode;


        // If there is a next node, we move up the hierarchy and increment our index counter.

        this.nextNode = this.nextNode.hasNext() ? this.nextNode.getLinkNext() : null;
        this.previousNode = node;
        nextIndex++;

        // Returns the node.
        return (E) node.getData();
    }

    /**
     * The previous() method moves down the node hierarchy and returns the node at the previous position. If previous is called when
     * There is no previous node, this method throws the NoSuchElementException consistent with problem constraints.
     *
     * @return E: The data stored in the node at the previous position
     */
    public E previous() {

        // If there is no next node, we throw the NoSuchElementException
        if(previousNode == null) throw new NoSuchElementException();

        // Otherwise, we get the previous node
        Node node = previousNode;

        // If there is a previous node, we move down the heirarchy and decrement our nextIndex

        this.nextNode = previousNode;
        this.previousNode = nextNode.hasPrev() ? nextNode.getLinkPrev() : null;
        nextIndex--;

        // Returns the node
        return (E) node.getData();
    }

    /**
     * Removes the last traversed element. This method may
     * only be called after a call to the next() method.
     * If the nextIndex is > 0, we decrement it by one because we've removed an element from the list.
     */
    public void remove() {
        this.previousNode.delete();
        if(this.nextIndex > 0){
            this.nextIndex--;
        }
    }

    /**
     * The remove(int index) method receives the index of the node we wish to remove.
     * It then moves its pointer to that specified index and deletes the node located there.
     *
     * @param index: The index of the desired node to remove
     *
     * @return: The next node after deletion
     */
    public Node remove(int index){

        // Moves to the desired location without actually mutating where this iterators pointer is pointing to
        Node node = this.nextNode;
        while(index < this.nextIndex){
            node = node.getLinkPrev();
            index++;
        }
        while(index > this.nextIndex){
            node = node.getLinkNext();
            index--;
        }

        node.delete();

        if(this.nextIndex > 0){
            this.nextIndex--;
        }

        return node;
    }

    /**
     * Tests if there is an element after the iterator position.
     *
     * @return true if there is an element after the iterator position
     */
    public boolean hasNext() {
        return nextNode != null && nextNode.hasNext();
    }

    /**
     * Tests if there is an element before the iterator position.
     *
     * @return true if there is an element before the iterator position
     */
    public boolean hasPrevious() {
        return previousNode != null;// && nextNode.hasPrev();
    }

    /**
     * Checks if the starting node is equal to the next node the pointer is pointing to. If it is, we're at the beginning
     *
     * @return true if we're at the starting position
     */
    public boolean atStart(){
        return get(0) == nextNode;
    }

    /**
     * Returns true if there is no next node to be pointed to, indicating we're pointing at the last node.
     *
     * @return true if the next node doesn't have a node after it.
     */
    public boolean atEnd(){
        return !hasNext();
    }

    /**
     * Returns the data stored in the first node.
     *
     * @return The first node
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * This method returns the index of the previous node, which is the nextIndex - 1 because we point between nodes.
     *
     * @return The index of the previous element
     */
    public int previousIndex() {
        return nextIndex - 1;
    }

    /**
     * This method returns the index of the next node.
     *
     * @return The index of the next node
     */
    public int nextIndex() {
        return nextIndex;
    }

    /**
     * Returns the index of the next node
     *
     * @return The index of the next node
     */
    public int getIndex(){
        return nextIndex;
    }

    /**
     * The set() method sets the last traversed element to a different value. Overriding the data previously stored in that node.
     *
     * @param data the data to override in the node.
     */
    public void set(Object data) {
        this.previousNode.setData(data);
    }

    /**
     * The replace() method does the same thing as the set() method. Created to satisfy problem constraints.
     *
     * @param data the data to override in the node.
     */
    public void replace(Object data){
        set(data);
    }

    /**
     * Overrides the data of a node at a specified index.
     *
     * @param index: The index of the node to override the data of
     * @param data: The data to override in the node.
     */
    public void replace(int index, Object data){

        // Creates a placeholder node and traverses through that as to not mutate the actual pointer of this iterator
        Node node = this.nextNode;

        while(index < this.nextIndex){
            node = node.getLinkPrev();
            index++;
        }
        while(index > this.nextIndex){
            node = node.getLinkNext();
            index--;
        }

        node.setData(data);
    }

    /**
     * This method moves the pointer to the last node.
     */
    public void moveToEnd(){
        while(hasNext()){
            next();
        }
    }

    /**
     * The getSize() method iterates through all the nodes starting at the first node and counts how many iterations took place.
     * This number is how many nodes there are, therefore the size of the list.
     *
     * @return The size of the list
     */
    public int getSize(){
        int size = 1;
        while(hasNext()){
            next();
            size++;
        }
        return size;
    }

    /**
     * The moveTo() method recieves and index and moves the pointer to that index by calling next() on this iterator object.
     *
     * @param index: The index to move the pointer to
     */
    public void moveTo(int index){
        for(int i = 0; i < index; i++){
            next();
        }
    }

    /**
     * The display() method iterates through all of the nodes and displays the node data and corresponding index
     * Associated with that node.
     */
    public void display(){
        int index = 0;
        Node node = nextNode;
        DoublyLinkedListIterator it = new DoublyLinkedListIterator(node);
        System.out.println("\nDisplaying list");

        while(it.hasPrevious()){
            it.previous();
        }

        while(it.hasNext()){
            System.out.println("DoublyLinkedList.Node " + index + ": " + it.next());
            index++;
        }

        System.out.println("DoublyLinkedList.Node " + index + ": " + it.next());

    }

    /**
     * This method displays a bunch of details about the list.
     */
    public void show(){
        int index = this.nextIndex;
        Node node = this.nextNode;
        System.out.println("\nWalking up the list using node.next()");

        while(index > 0){
            node = node.getLinkPrev();
            index--;
        }

        while(node.hasNext()){
            System.out.println("DoublyLinkedList.Node " + index + ": " + node.getData());
            node = node.getLinkNext();
            index++;
        }

        System.out.println("DoublyLinkedList.Node " + index + ": " + node.getData());

        System.out.println("\nWalking down the list using node.prev()");

        while(node.hasPrev()){
            System.out.println("DoublyLinkedList.Node " + index + ": " + node.getData());
            node = node.getLinkPrev();
            index--;
        }
        System.out.println("DoublyLinkedList.Node " + index + ": " + node.getData());
    }
}