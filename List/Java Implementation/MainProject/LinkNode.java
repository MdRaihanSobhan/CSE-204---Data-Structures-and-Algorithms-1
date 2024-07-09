package MainProject;
public class LinkNode <T> {
    private LinkNode<T> nextNode;
    private T value;

    // Constructors

    LinkNode(T item, LinkNode<T> nextValue){
        value = item;
        nextNode= nextValue;
    }
    LinkNode(LinkNode<T> nextValue){
        nextNode= nextValue;
    }

    // helper methods


    public LinkNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(LinkNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    public T getValue() {
        return value;
    }

    public T setValue(T value) {
        this.value = value;
        return value;
    }
}
