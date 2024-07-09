package StackADT;

public class LinkNode<T> {
    private T value;
    private LinkNode<T> nextNode;
    LinkNode(LinkNode<T> nextNode){
        this.nextNode=nextNode;
    }
    LinkNode(T value, LinkNode<T>nextNode){
        this.value=value;
        this.nextNode=nextNode;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public LinkNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(LinkNode<T> nextNode) {
        this.nextNode = nextNode;
    }
}
