public class MyLinkedList<E> implements MyList<E> {

    private class Node {
        E element;
        Node next;
        Node prev;

        public Node(E element) {
            this.element = element;
        }
    }

    private Node head;
    private Node tail;
    private int size;



}