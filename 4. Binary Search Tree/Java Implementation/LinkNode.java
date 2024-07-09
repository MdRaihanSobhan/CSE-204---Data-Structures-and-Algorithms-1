public class LinkNode {
    private int data;
    private LinkNode leftNode;
    private LinkNode rightNode;

    public LinkNode(int data) {
        this.data = data;
        leftNode= rightNode= null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LinkNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(LinkNode leftNode) {
        this.leftNode = leftNode;
    }

    public LinkNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(LinkNode rightNode) {
        this.rightNode = rightNode;
    }
}