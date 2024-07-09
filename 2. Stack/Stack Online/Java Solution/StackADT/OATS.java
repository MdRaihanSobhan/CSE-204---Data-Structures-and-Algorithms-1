package StackADT;
import StackADT.Arr;
public class OATS<T> extends Arr {


    Integer Oats_Arr[];
    Arr<Integer> A=new Arr<>(Oats_Arr,-1);
    Arr<Integer> B=new Arr<>(Oats_Arr,1);




    public OATS(int n) {
        Integer Oats_Arr[]=new Integer[n];
        for(int i=0;i<n;i++){
            A.push(Oats_Arr[i]);
            B.push(Oats_Arr[i]);
        }
    }


    void pushA(Integer item){
        A.push(item);
    }
    void pushB(Integer item){
        B.push(item);
    }
    void popA(){
        A.pop();
    }
    void popB(){
        B.pop();
    }
    Integer topValueA(){
        return A.topValue();
    }
    Integer topValueB(){
        return B.topValue();
    }
    int lengthA(){
        return A.length();
    }
    int lengthB(){
        return B.length();
    }
    void clearA(){
        A.clear();
    }
    void clearB(){
        B.clear();
    }



}
