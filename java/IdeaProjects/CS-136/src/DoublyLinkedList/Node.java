package DoublyLinkedList;

/**
 * Matthew Yarbrough
 * Adam Goins
 * CS-136L Lab 9 DoublyLinkedList.DoublyLinkedList
 *
 *
 *
 * The DoublyLinkedList.Node class is a generic class that stores the generic datatype E so that we can store data inside of nodes
 * And link nodes to one another to create a doubly linked list.
 *
 * @param <E>: Generic Datatype
 */
class Node < E > {

    // Fields
    public Node next;
    public Node prev;
    public E data;

    /**
     * The single arg constructor of the DoublyLinkedList.Node class receives data and stores the data in this node. The next and prev node
     * Are pointing to null because there isn't a next or previous node linked to this node yet.
     * @param data
     */
    public Node(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    /**
     * Receives a node object and links it as the next node with respect to this node.
     *
     * @param n: The next node after this one in the list.
     */
    public void setLinkNext(Node n) {
        next = n;
    }

    /**
     * Receives a node object and links it as the previous node with respect to this node.
     *
     * @param p: The next node after this one in the list.
     */
    public void setLinkPrev(Node p) {
        prev = p;
    }


    /**
     * Returns the next node associated with this node.
     *
     * @return: The node after this node.
     */
    public Node getLinkNext() {
        return next;
    }

    /**
     * Returns the previous node associated with this node.
     *
     * @return: The node before this node.
     */
    public Node getLinkPrev() {
        return prev;
    }

    /**
     * Sets the data of this node to the data received as an argument.
     *
     * @param d: The data to set this node data to.
     */
    public void setData(E d) {
        data = d;
    }

    /**
     * Returns the data stored in this node.
     *
     * @return: The data stored in this node.
     */
    public E getData() {
        return data;
    }

    /**
     * The delete() method links the next and previous nodes to eachother rather than this node as an intermediary,
     * Then points this nodes' next and previous to null so that there's nothing pointing to this node and the
     * Garbage collector will clean up the memory associated with this node. (deleting it).
     *
     * @return: The next node if there is a next, the previous node if there isn't a next, null if there is neither.
     */
    public Node delete(){
        // Placeholder node
        Node node = null;

        // If there is a previous node we link it to the next node
        if(hasPrev()){
            node = prev;
            // Points the previous node to the next node if there is a next, otherwise null
            node.setLinkNext(hasNext() ? next : null);
        }

        // If there is a next node we link it to the previous node
        if(hasNext()){
            node = next;
            // Points the next node to the previous node if there is a previous, otherwise null
            node.setLinkPrev(hasPrev() ? prev : null);
        }



        // Sets all fields to point to null so that it's ready to be collected by the garbage collector.
        setLinkNext(null);
        setLinkPrev(null);
        setData(null);
        return node;
    }

    /**
     * The hasPrev() method returns true if this node has a link previous, false otherwise.
     *
     * @return true if there is a previous node, false otherwise
     */
    public boolean hasPrev(){
        return getLinkPrev() != null;
    }

    /**
     * The hasNext() method returns true if this node has a link next, false otherwise.
     *
     * @return true if there is a next node, false otherwise.
     */
    public boolean hasNext(){
        return getLinkNext() != null;
    }
}

