package implementations;

import interfaces.QueueADT;

public class MyQueue<E> implements QueueADT<E> {

    private MyDLL<E> list;  // We use a double linked list as the underlying structure

    public MyQueue() {
        list = new MyDLL<>();
    }

    @Override
    public void enqueue(E element) {
        list.addLast(element);  // Add the element to the end of the list
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Queue is empty.");
        }
        return list.removeFirst();  // Remove and return the first element of the list
    }

    @Override
    public E first() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Queue is empty.");
        }
        return list.getFirst();  // Return, but do not remove, the first element of the list
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();  // Return true if the list is empty, false otherwise
    }

    @Override
    public int size() {
        return list.size();  // Return the number of elements in the list
    }
}
