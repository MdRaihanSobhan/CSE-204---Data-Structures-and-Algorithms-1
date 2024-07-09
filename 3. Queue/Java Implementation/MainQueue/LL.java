package MainQueue;

public class LL<T> implements Queue<T> {

    private LinkNode<T> front;
    private LinkNode<T> rear;
    int length;

    public LL() {
        this.length= 0;
        front=rear=new LinkNode<>(null);
    }
    public LL(int listSize){
       this();
    }
    public LL(T[] givenList){
        this.front=null;
        this.rear=null;
        this.length=0;
        for(int i=0;i<givenList.length;i++){
            if(givenList[i]!=null)
                enqueue(givenList[i]);
        }
    }

    @Override
    public void clear() {
        this.length= 0;
        front=rear=new LinkNode<>(null);
    }

    @Override
    public void enqueue(T item) {
        rear.setNextNode(new LinkNode<T>(item,null));
        rear= rear.getNextNode();
        length++;
    }

    @Override
    public T dequeue() {
        if(length==0){
            System.out.println("The queue is empty");
            return null;
        }
        T item= front.getNextNode().getValue();
        front.setNextNode(front.getNextNode().getNextNode());
        if(front.getNextNode()==null){
            rear= front;
        }
        length--;
        return item;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public T frontValue() {
        if(length==0){
            System.out.println("The queue is empty");
            return null;
        }
        return front.getNextNode().getValue();
    }

    @Override
    public T rearValue() {
        if(length==0){
            System.out.println("The queue is empty");
            return null;
        }
        return rear.getValue();
    }

    @Override
    public T leaveQueue() {
        if(length==0){
            System.out.println("The queue is empty");
            return null;
        }
        T ret= rear.getValue();
        LinkNode<T> prevRear= front;

        while (prevRear.getNextNode()!=rear){
            prevRear= prevRear.getNextNode();
        }
        rear= prevRear;
        rear.setNextNode(null);
        length--;
        return ret;
    }
}
