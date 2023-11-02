package implementations;

public class MyDLL<E> {
    private MyDLLNode<E> head;
    private MyDLLNode<E> tail;
    private int size;

    public MyDLL() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst(E data) {
        MyDLLNode<E> newNode = new MyDLLNode<>(data, null, head);
        if (head != null) {
            head.setPrev(newNode);
        }
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        size++;
    }

    public void addLast(E data) {
        MyDLLNode<E> newNode = new MyDLLNode<>(data, tail, null);
        if (tail != null) {
            tail.setNext(newNode);
        }
        tail = newNode;
        if (head == null) {
            head = newNode;
        }
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("List is empty.");
        }
        E temp = head.getData();
        head = head.getNext();
        if (head != null) {
            head.setPrev(null);
        }
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return temp;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("List is empty.");
        }
        E temp = tail.getData();
        tail = tail.getPrev();
        if (tail != null) {
            tail.setNext(null);
        }
        size--;
        if (isEmpty()) {
            head = null;
        }
        return temp;
    }

    public E getFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("List is empty.");
        }
        return head.getData();
    }

    public E getLast() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("List is empty.");
        }
        return tail.getData();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    
}
