import java.util.Objects;

public class Stack<T> implements Cloneable{
    private Node<T> head;

    public void push(T value){
        if (head == null){
            head = new Node<>(value);
        } else {
            head = new Node<>(value, head);
        }
    }

    public T pop(){
        if (head == null){
            return null;
        } else {
            T value = head.getValue();
            head = head.getPrev();
            return value;
        }
    }

    public Stack<T> reverse(){
        Node<T>[] headAndTail;
        Stack<T> reversedStack;

        if(head == null){
            return new Stack<>();
        }

        try {
            reversedStack = this.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        headAndTail = reversedHead(head);
        reversedStack.setHead(headAndTail[0]);

        return reversedStack;
    }

    private Node<T>[] reversedHead(Node<T> node){
        Node<T>[] headAndTail;
        Node<T> newNode = new Node<>(node.getValue());
        if(node.getPrev() == null){
            return new Node[]{newNode, newNode};
        }else {
            headAndTail = reversedHead(node.getPrev());
            headAndTail[1].setPrev(newNode);
            return new Node[]{headAndTail[0], newNode};
        }
    }

    private void setHead(Node<T> head) {
        this.head = head;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (Objects.isNull(head)){
            return "EMPTY";
        } else {
            Node<T> node = head;
            while (node != null){
                sb.append(node.getValue());
                if(Objects.nonNull(node.getPrev())){
                    sb.append("->");
                }
                node = node.getPrev();
            }
            return sb.toString();
        }
    }



    @Override
    protected Stack<T> clone() throws CloneNotSupportedException {
        Stack<T> newStack = (Stack<T>) super.clone();
        newStack.head = (Node<T>) head.clone();
        return newStack;
    }
}
