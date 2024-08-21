import java.util.Arrays;

/**
 * A class that implements a dynamic array similar to `ArrayList` in Java.
 * It implements the `MyList` interface for storing `Person` objects.
 */
public class MyArrayList implements MyList {

    private Person[] array = new Person[10];
    private Person[] subArray;
    private int size = 0;

    /**
     * Checks if the provided index is within the valid range of the array.
     * @param index the index to check
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Doubles the size of the internal array if it is full.
     * This method ensures that there is enough capacity to add new elements.
     */
    private void increaseArray() {
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }

    /**
     * Adds a new `Person` object to the end of the list.
     * @param o the `Person` object to be added to the list
     */
    @Override
    public void add(Person o) {
        increaseArray();
        array[size] = o;
        size++;
    }

    /**
     * Inserts a new `Person` object at the specified index in the list.
     * Shifts the element currently at that position (if any) and any subsequent elements to the right.
     * @param p     the `Person` object to be added to the list
     * @param index the index at which the `Person` object should be added
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size)
     */
    @Override
    public void add(Person p, int index) {
        increaseArray();
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = p;
        size++;
    }

    /**
     * Removes the first occurrence of the specified `Person` from the list, if it is present.
     * @param p the `Person` object to be removed from the list
     * @return true if the `Person` was successfully removed, false otherwise
     */
    @Override
    public boolean remove(Person p) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(p)) {
                return removeAt(i);
            }
        }
        return false;
    }

    /**
     * Removes the `Person` object at the specified index in the list.
     * Shifts any subsequent elements to the left.
     * @param index the index of the `Person` object to be removed
     * @return true if the `Person` was successfully removed
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
        System.arraycopy(array, index + 1, array, index, size - 1 - index);
        size--;
        return true;
    }

    /**
     * Returns the `Person` object at the specified index in the list.
     * @param index the index of the `Person` object to be returned
     * @return the `Person` object at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    @Override
    public Person get(int index) {
        checkIndex(index);
        return array[index];
    }

    /**
     * Replaces the `Person` object at the specified index with the given `Person`.
     * @param index the index of the `Person` object to replace
     * @param p     the new `Person` object to be stored at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    @Override
    public void set(int index, Person p) {
        checkIndex(index);
        if (size == 0) {
            System.out.println("No objects have been created.");
            return;
        }
        array[index] = p;
    }

    /**
     * Returns a sublist of the list from the specified `fromIndex` (inclusive) to `toIndex` (exclusive).
     * @param fromIndex the starting index of the sublist (inclusive)
     * @param toIndex   the ending index of the sublist (exclusive)
     * @return an array containing the elements in the specified range of the list
     * @throws IndexOutOfBoundsException if the start or end index is out of range
     */
    @Override
    public Object subList(int fromIndex, int toIndex) {
        checkIndex(fromIndex);
        checkIndex(toIndex);
        subArray = Arrays.copyOfRange(array, fromIndex, toIndex);
        return subArray;
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
