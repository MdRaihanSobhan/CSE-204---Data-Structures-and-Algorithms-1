package StackADT;

public interface Stack <T> {
    public void clear();
    public void push(T item);
    public T pop();
    public T topValue();
    public int length();
    public void setDirection(int direction);
}
