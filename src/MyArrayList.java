public class MyArrayList<T> implements MyList<T> {
    // Declare an array to hold the elements and a variable to keep track of the size of the array
    private Object[] elements;
    private int size;

    // Constructor that initializes the array with a length of 10 and sets the size to 0
    public MyArrayList() {
        elements = new Object[10];
        size = 0;
    }

    // Return the size of the array
    public int size() {
        return size;
    }

    // Check if the array contains the specified object and return a boolean value
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    // Add an element to the end of the array, resize if necessary
    public void add(T item) {
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
        elements[size] = item;
        size++;
    }

    // Add an element at a specified index, resize if necessary, and shift existing elements to the right
    public void add(T item, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = item;
        size++;
    }

    // Remove the specified element from the array, shift remaining elements to the left, and return a boolean value indicating success
    public boolean remove(T item) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(item)) {
                for (int j = i; j < size - 1; j++) {
                    elements[j] = elements[j + 1];
                }
                size--;
                return true;
            }
        }
        return false;
    }

    // Remove the element at the specified index, shift remaining elements to the left, and return the removed element
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T removedElement = (T) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return removedElement;
    }

    // Reset the array to a length of 10 and size to 0
    public void clean() {
        elements = new Object[10];
        size = 0;
    }

    // Return the element at the specified index
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) elements[index];
    }




    // Method that returns the index of the first occurrence of the given object, or -1 if not found
    public int indexOf(Object o) {
        // Iterate through the list and return the index of the first occurrence of the object
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        // Return -1 if the object is not found in the list
        return -1;
    }

    // Method that returns the index of the last occurrence of the given object, or -1 if not found
    public int lastIndex(Object o) {
        // Iterate through the list in reverse order and return the index of the last occurrence of the object
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        // Return -1 if the object is not found in the list
        return -1;
    }
}
