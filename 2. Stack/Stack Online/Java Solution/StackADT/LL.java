package StackADT;

public class LL<T> implements Stack<T> {

    private LinkNode<T> top;
    private int listSize;

    public LL(){
        this.top=null;
        this.listSize=0;
    }
    LL(int listSize){
        this.top=null;
        this.listSize=listSize;
    }
    public LL(T[] Ara){
        this.top=null;
        this.listSize=0;
        for(int i=0;i<Ara.length;i++){
            if(Ara[i]!=null)
                push(Ara[i]);
        }
    }


    @Override
    public void clear() {
        top=null;
        listSize=0;
    }

    @Override
    public void push(T item) {
        top= new LinkNode<T>(item,top);
        listSize++;
    }

    @Override
    public T pop() {
        if(top!=null){
            T value= top.getValue();
            top=top.getNextNode();
            listSize--;
            return value;
        }
        return null;
    }

    @Override
    public T topValue() {
        if(top!=null){
            return top.getValue();
        }
        return null;
    }

    @Override
    public int length() {
        return listSize;
    }

    @Override
    public void setDirection(int direction) {
        // it's only for Array based stack implementation
    }
}
