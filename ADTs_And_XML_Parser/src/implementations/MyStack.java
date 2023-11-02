package implementations;


import interfaces.StackADT;

import java.util.EmptyStackException;

public class MyStack<E> implements StackADT<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private int top;    // Index of the top element
    private E[] elements;

    public MyStack() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public MyStack(int initialCapacity) {
        elements = (E[]) new Object[initialCapacity];
        top = -1;
    }

    @Override
    public void push(E element) {
        if (top == elements.length - 1) {
            expandCapacity();
        }
        elements[++top] = element;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E result = elements[top];
        elements[top] = null;  // For garbage collection
        top--;
        return result;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements[top];
    }

    @Override
    public boolean isEmpty() {
        return (top == -1);
    }

    @Override
    public int size() {
        return top + 1;
    }

    @SuppressWarnings("unchecked")
    private void expandCapacity() {
        E[] larger = (E[]) (new Object[elements.length * 2]);
        for (int i = 0; i < elements.length; i++) {
            larger[i] = elements[i];
        }
        elements = larger;
    }
}
