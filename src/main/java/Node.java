public class Node<T> implements Cloneable{
    private T value;
    private Node<T> prev;

    public Node(T value) {
        this.value = value;
        this.prev = null;
    }

    public Node(T value, Node<T> prev) {
        this.value = value;
        this.prev = prev;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    @Override
    protected Node<T> clone() throws CloneNotSupportedException {
        return (Node<T>) super.clone();
    }
}
