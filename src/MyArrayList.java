public class MyArrayList<T> implements MyList<T> {
    //define a variable Object
    private Object[] elements;
    //define a variable size
    private int size;
    // Constructor to initialize the elements array with a specified capacity
    public MyArrayList(int capacity) {
        this.elements = new Object[capacity];
        this.size = 0;
    }
    //Constructor with capacity of elements of 10
    public MyArrayList(){
        this(10);
    }
    //method add with the generic type<T>
    public void add(T element){
        //This line checks if the size of the list is equal to the length of the internal array
        if(this.size == this.elements.length){
            //If the size of the list is equal to the length of the internal array,
            // this line creates a new array newElements that has twice the length of the current array.
            Object[] newElements= new Object[this.elements.length*2];
            //This line checks if the size of the list is equal to the length of the internal arrayThis line copies the elements of the current array elements to the new array newElements.
            System.arraycopy(this.elements,0,newElements,0,this.elements.length);
            //This line copies the elements of the current array to the new array
            this.elements= newElements;
            //sets the internal array elements to be the new array newElements
            this.elements[this.size] = element;

        }
    }
}