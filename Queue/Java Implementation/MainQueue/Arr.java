package MainQueue;

public class Arr<T> implements Queue<T> {

    private static final int defaultSize= 15;
    private int length;
    private int listSize;
    private int front;
    private int rear;
    private T[] queueList;

    public Arr() {
        this.listSize = defaultSize + 1;
        this.queueList = (T[])new Object[listSize];
        this.length= 0;
        this.rear = 0;
        this.front= 1;
    }
    public Arr(int listSize){
        this.listSize= listSize+1;
        this.queueList = (T[])new Object[this.listSize];
        this.length= 0;
        this.rear = 0;
        this.front= 1;
    }
    public Arr(T[] givenList){
        this.listSize=givenList.length;
        this.length=givenList.length;
        this.front=1;
        this.rear=0;
        this.queueList= givenList;
    }


    @Override
    public void clear() {
        this.front=1;
        this.rear=0;
        this.length=0;
    }

    @Override
    public void enqueue(T item) {
        if(length+2<=listSize){
            rear= (rear+listSize+1)%listSize;
            queueList[rear]= item;
        }
        else {
            T tempList[] =(T[]) new Object[2*listSize-1];
            for(int i=0, j=front ;i<length;i++){
                tempList[i]= queueList[j];
                rear = i;
                j++;
                if(j==listSize) j=0;
            }
            front=0;
            tempList[++rear] = item;
            listSize= 2*listSize-1;
            queueList= tempList;
        }
        length++;
    }

    @Override
    public T dequeue() {
        if(length==0){
            System.out.println("The queue is empty");
            return null;
        }
        T ret = queueList[front];
        front= (front+listSize+1)%listSize;
        length--;
        return ret;
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
        return queueList[front];
    }

    @Override
    public T rearValue() {
        if(length==0) {
            System.out.println("The queue is empty");
            return null;
        }
        return queueList[rear];
    }


    @Override
    public T leaveQueue() {
        if(length==0){
            System.out.println("The queue is empty");
            return null;
        }
        T ret = queueList[rear];
        rear= (rear+listSize-1)%listSize;
        length--;
        return ret;
    }
}
