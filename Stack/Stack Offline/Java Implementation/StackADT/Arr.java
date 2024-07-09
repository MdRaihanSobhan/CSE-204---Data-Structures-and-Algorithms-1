package StackADT;

import java.awt.geom.Area;

public class Arr <T> implements Stack<T>{

    private static final int defaultSize= 10;
    private int maxSize;
    private int listSize;
    private int top;
    private T[] Ara;
    private int direction;

    public Arr(){
        Ara= (T[])new Object[defaultSize];
        top=-1;
        direction=1;
        maxSize=defaultSize;
    }
    public Arr(T[] ara, int direction){
        this.direction=direction;

        if(direction==-1){
            top = ara.length;
            maxSize=ara.length;
        }

        else{
            top = -1;
            maxSize=ara.length;
        }
        this.Ara=ara;
    }


    @Override
    public void clear() {
        if(direction==-1){
            top=maxSize;
        }
        else{
            top=-1;
        }
    }

    @Override
    public void push(T item) {
        if(direction==-1){
            if(top== 0){
                int previousMaxSize= maxSize;
                maxSize+=maxSize;
                T[] ara =(T[]) new Object[maxSize];

                for(int i=previousMaxSize-1;i>=top;i--){
                    ara[previousMaxSize+i]=Ara[i];
                }
                Ara=ara;
                top+= previousMaxSize;
            }
            Ara[--top]=item;
        }
        else{
            if(top== maxSize-1){
                maxSize+=maxSize;
                T[] ara=(T[]) new Object[maxSize];
                for(int i=0;i<=top;i++){
                    ara[i]=Ara[i];
                }
                Ara=ara;
            }
            Ara[++top]=item;
        }
    }

    @Override
    public T pop() {
        if(direction==-1){
            if(top!=maxSize)
                return Ara[top++];
        }
        else {
            if(top!=-1)
                return Ara[top--];
        }
        return null;
    }

    @Override
    public T topValue() {
        if(direction==-1){
            if(top!=maxSize)
                return Ara[top];
            }
        else {
            if(top!=-1)
                return Ara[top];
        }
        return null;
    }

    @Override
    public int length() {

        if(direction==-1){
            return maxSize-top;
        }
        else{
            return top+1;
        }
    }

    @Override
    public void setDirection(int direction) {
        if(length()==0){
            this.direction=direction;
            if(direction==-1){
                top=maxSize;
            }
            else {
                top=-1;
            }
        }
    }
}
