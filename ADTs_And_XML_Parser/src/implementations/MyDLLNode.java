package implementations;

public class MyDLLNode<E> {
    private E data;
    private MyDLLNode<E> next;
    private MyDLLNode<E> prev;

    public MyDLLNode(E data, MyDLLNode<E> prev, MyDLLNode<E> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public MyDLLNode<E> getNext() {
        return next;
    }

    public void setNext(MyDLLNode<E> next) {
        this.next = next;
    }

    public MyDLLNode<E> getPrev() {
        return prev;
    }

    public void setPrev(MyDLLNode<E> prev) {
        this.prev = prev;
    }
}
