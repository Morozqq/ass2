public class MyArrayList<E> implements MyList<E> {
    // Instance variables to hold the elements and size of the list
    private Object[] elements;
    private int size;
    // Constructor that initializes the elements array and size to 0
    public MyArrayList() {
        elements = new Object[10];
        size = 0;
    }
    // Returns the current size of the list
    @Override
    public int size() {
        return size;
    }
    // Checks if the specified object is present in the list
    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(T item) {
        // Check if the elements array is full
        if (size == elements.length) {
            // If it is, create a new array with double the size
            Object[] newElements = new Object[2 * elements.length];
            // Copy over the elements from the old array to the new array
            System.arraycopy(elements, 0, newElements, 0, size);
            // Set the elements array to the new array
            elements = newElements;
        }
        // Add the new item to the end of the list and increment the size
        elements[size] = item;
        size++;
    }
    public void add(T item, int index) {
        // Check if the index is out of bounds
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        // Check if the elements array is full
        if (size == elements.length) {
            // If it is, create a new array with double the size
            Object[] newElements = new Object[elements.length * 2];
            // Copy over the elements from the old array to the new array
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }
            // Set the elements array to the new array
            elements = newElements;
        }
        // Shift all elements after the specified index to the right by one position
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        // Insert the new item at the specified index and increment the size
        elements[index] = item;
        size++;
    }
    public boolean remove(T item) {
        // Search for the index of the item in the elements array
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(item)) {
                index = i;
                break;
            }
        }
        // If the item was not found, return false
        if (index == -1) {
            return false;
        }
        // Shift all elements after the specified index to the left by one position
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        // Set the last element to null and decrement the size
        elements[--size] = null;
        return true;
    }
}