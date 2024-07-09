package StackADT;

import java.util.Scanner;

public class OATSmain {

    public static<T> void printList(Arr<T> stack){

        Arr<T> stack1 = new Arr<>();
        Arr<T> stack2= new Arr<>();


        int size= stack.length();
        for(int i=0;i<size;i++){
            stack1.push(stack.topValue());
            stack2.push(stack.pop());
        }
        System.out.print("<");
        for(int i=0;i<size;i++){
            System.out.print(stack1.pop());
            if(i<size-1){
                System.out.print(", ");
            }
        }
        System.out.println(">");
        for(int i=0;i<size;i++){
            stack.push(stack2.pop());
        }
    }


    public static void main(String[] args) {


        Scanner scanner= new Scanner(System.in);
        int n= scanner.nextInt();
        OATS temp = new OATS(n);
        for(int i=0;i<n;i++){
            temp.Oats_Arr[i]= scanner.nextInt();
        }

        int output= -1;
        while (true){
            int Q= scanner.nextInt();
            int P= scanner.nextInt();

            if(Q==1){
                temp.pushA(P);
            }
            else if(Q==2){
                temp.pushB(P);
            }
            else if (Q==3){
                temp.popA();
            }
            else if(Q==4){
                temp.popB();
            }
            else if(Q==5){
                output= temp.topValueA();
            }
            else if(Q==6){
                output= temp.topValueB();
            }
        }
    }
}
