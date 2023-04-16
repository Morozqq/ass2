public class MyLinkedList<T> implements MyList<T> {

    private class Node {
        T element;
        Node next;
        Node prev;

        // Constructor to create a new node with a given element
        public Node(T element) {
            this.element = element;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;  // Reference to the first node in the list
    private Node tail;  // Reference to the last node in the list
    private int size;   // Number of elements in the list

    // Constructor to create an empty linked list
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Helper method to get the node at a given index
    private Node getNode(int index) {
        // Check for invalid index
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        Node currNode;
        // Traverse the list from the beginning if the index is in the first half
        if (index < size / 2) {
            currNode = head;
            for (int i = 0; i < index; i++) {
                currNode = currNode.next;
            }
        }
        // Traverse the list from the end if the index is in the second half
        else {
            currNode = tail;
            for (int i = size - 1; i > index; i--) {
                currNode = currNode.prev;
            }
        }

        return currNode;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public void add(T item) {
        // Create a new node with the given item
        Node newNode = new Node(item);

        // Add the new node to the end of the list
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        // Increase the size of the list
        size++;
    }

    @Override
    public void add(T item, int index) {
        // Check for invalid index
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        // Add the item to the end of the list if the index is equal to the size
        if (index == size) {
            add(item);
        }
        // Add the item to the specified index
        else {
            Node newNode = new Node(item);
            Node currNode = getNode(index);

            // Insert the new node at the beginning of the list
            if (currNode.prev == null) {
                head = newNode;
            }
            // Insert the new node in the middle of the list
            else {
                currNode.prev.next = newNode;
                newNode.prev = currNode.prev;
            }

            // Insert the new node at the specified index
            newNode.next = currNode;
            currNode.prev = newNode;

            // Increase the size of the list
            size++;
        }
    }

    // This method removes the specified item from the linked list
    @Override
    public boolean remove(T item) {
        Node currNode = head;

        // Traverse the linked list to find the node containing the specified item
        while (currNode != null) {
            if (currNode.element.equals(item)) {
                // If the node is the head node, update the head pointer
                if (currNode.prev == null) {
                    head = currNode.next;
                    // If the head pointer is not null, update its previous pointer
                    if (head != null) {
                        head.prev = null;
                    } else {
                        // If the head pointer is null, update the tail pointer to null as well
                        tail = null;
                    }
                    // If the node is the tail node, update the tail pointer
                } else if (currNode.next == null) {
                    tail = currNode.prev;
                    tail.next = null;
                } else {
                    // If the node is in the middle, update the pointers of the nodes before and after it
                    currNode.prev.next = currNode.next;
                    currNode.next.prev = currNode.prev;
                }

                size--; // Update the size of the linked list
                return true; // Return true to indicate successful removal
            }

            currNode = currNode.next; // Move to the next node
        }

        return false; // Return false to indicate the item was not found in the linked list
    }

    // This method removes the item at the specified index from the linked list
    @Override
    public T remove(int index) {

        Node currNode = getNode(index); // Get the node at the specified index

        if (currNode.prev == null) {
            head = currNode.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else if (currNode.next == null) {
            tail = currNode.prev;
            tail.next = null;
        } else {
            currNode.prev.next = currNode.next;
            currNode.next.prev = currNode.prev;
        }

        size--; // Update the size of the linked list
        return currNode.element; // Return the element of the removed node
    }

    // This method removes all nodes from the linked list
    @Override
    public void clean() {
        head = null; // Set the head pointer to null
        tail = null; // Set the tail pointer to null
        size = 0; // Reset the size of the linked list to 0
    }
    @Override
    public T get(int index) {
        // Returns the element at the specified position in the list.
        return getNode(index).element;
    }

    @Override
    public int indexOf(Object o) {
        // Returns the index of the first occurrence of the specified element in the list, or -1 if the list does not contain the element.
        int index = 0;
        Node currNode = head;

        while (currNode != null) {
            if (currNode.element.equals(o)) {
                return index;
            }

            index++;
            currNode = currNode.next;
        }

        return -1;
    }

    @Override
    public int lastIndex(Object o) {
        // Returns the index of the last occurrence of the specified element in the list, or -1 if the list does not contain the element.
        int index = size - 1;
        Node currNode = tail;

        while (currNode != null) {
            if (currNode.element.equals(o)) {
                return index;
            }

            index--;
            currNode = currNode.prev;
        }

        return -1;
    }
    public String toString() {
        if (head == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = head;
        while (current != null) {
            sb.append(current.element);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

}