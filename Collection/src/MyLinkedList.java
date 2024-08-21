/**
 * A class that implements a dynamic array similar to `LinkedList` in Java.
 * It implements the `MyList` interface for storing `Person` objects.
 */

public class MyLinkedList implements MyList{

    private Node first;
    private Node last;
    private int size = 0;

    /**
     * A static nested class representing a node in the linked list.
     * Each node contains a reference to the previous node, the value it stores,
     * and the next node in the list.
     */
    static class Node {
        private Node previous;
        Person value;
        private Node next;


        /**
         * Constructs a new `Node` with references to the previous and next nodes,
         * and stores the given `Person` value.
         * @param previous the previous node in the list
         * @param value    the `Person` object stored in this node
         * @param next     the next node in the list
         */
        public Node(Node previous, Person value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }


    /**
     * Retrieves the node at the specified index in the list.
     * @param index the index of the node to retrieve
     * @return the node at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }


    /**
     * Adds a new Person to the end of the list.
     * @param p  the Person object to be added to the list
     */
    @Override
    public void add(Person p) {
        if (size == 0) {
            first = new Node(null, p, null);
            last = first;
        } else {
            Node secondLast = last;
            last = new Node(secondLast, p, null);
            secondLast.next = last;
        }
        size++;
    }


    /**
     * Inserts a new Person at the specified index in the list.
     * @param p     the Person object to be added to the list
     * @param index the index at which the Person object should be added
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size)
     */
    @Override
    public void add(Person p, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(p);
            return;
        }
        Node nodeNext = getNode(index);
        Node nodePrevious = nodeNext.previous;
        Node newNode = new Node(nodePrevious, p, nodeNext);
        nodeNext.previous = newNode;
        if (nodePrevious != null) {
            nodePrevious.next = newNode;
        } else {
            first = newNode;
        }
        size++;
    }

    /**
     * Removes the first occurrence of the specified Person from the list.
     * @param p the Person object to be removed from the list
     * @return true if the Person was successfully removed, false otherwise
     */
    @Override
    public boolean remove(Person p) {
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(p)) {
                return removeAt(i);
            }
            node = node.next;
        }
        return false;
    }

    /**
     * Removes the Person at the specified index from the list.
     * @param index the index of the Person object to be removed
     * @return true if the Person was successfully removed, false otherwise
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    @Override
    public boolean removeAt(int index) {
        Node node = getNode(index);
        Node nodeNext = node.next;
        Node nodePrevious = node.previous;
        if (nodeNext != null) {
            nodeNext.previous = nodePrevious;
        } else {
            last = nodePrevious;
        }
        if (nodePrevious != null) {
            nodePrevious.next = nodeNext;
        } else {
            first = nodeNext;
        }
        size--;
        return true;
    }

    /**
     * Returns the Person at the specified index in the list.
     * @param index the index of the Person object to be returned
     * @return the Person object at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    @Override
    public Person get(int index) {
        return getNode(index).value;
    }

    /**
     * Replaces the Person at the specified index with the given Person.
     * @param index the index of the Person object to replace
     * @param p     the new Person object to be stored at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    @Override
    public void set(int index, Person p) {
        Node current = getNode(index);
        current.value = p;

    }

    /**
     * Returns a sublist containing the elements between the specified fromIndex, inclusive, and toIndex, exclusive.
     * @param fromIndex the starting index of the sublist (inclusive)
     * @param toIndex   the ending index of the sublist (exclusive)
     * @return an array of Node objects representing the sublist
     * @throws IndexOutOfBoundsException if fromIndex is out of range (fromIndex < 0 || fromIndex >= size)
     *                                   or toIndex is out of range (toIndex > size || toIndex < fromIndex)
     */
    @Override
    public Object subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size && toIndex<fromIndex) {
            throw new IndexOutOfBoundsException();
        }
        int j = 0;
        Node[] array = new Node[toIndex - fromIndex];
        for (int i=fromIndex; i<toIndex;i++){
            array[j] = getNode(i);
            j++;
        }
        return array;
    }

    /**
     * Returns the number of elements in the list.
     * @return the number of elements in the list
     */
    @Override
    public int size() {
        return size;
    }


}
