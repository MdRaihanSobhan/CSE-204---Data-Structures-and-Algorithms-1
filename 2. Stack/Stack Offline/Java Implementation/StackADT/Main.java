package StackADT;

import java.util.Scanner;

public class Main {
    public static<T> void printList(Stack<T> stack){

        Arr<T> stack1 = new Arr<>();
        Arr<T> stack2= new Arr<>();

/*        LL<T> stack1 = new LL<>();
        LL<T> stack2 = new LL<>();*/

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
        Integer outputValue = -1;
        Scanner scanner = new Scanner(System.in);
        int givenLength = scanner.nextInt();

        Integer[] ara = new Integer[givenLength];
        Integer[] temp = new Integer[givenLength];
        for (int i=0; i<givenLength; i++) {
            ara[i] = scanner.nextInt();
        }
        Arr<Integer> numberList = new Arr<>(ara,1);
//        LL<Integer> numberList = new LL<>(temp);
        for(int i=0;i<givenLength;i++){
            numberList.push(ara[i]);
        }
        printList(numberList);


        while(true){
            int Q, P;
            Q = scanner.nextInt();
            P = scanner.nextInt();

            if(Q==0){
                break;
            }
            else if(Q==1){
                numberList.clear();
            }
            else if(Q==2){
                numberList.push(P);
            }
            else if(Q==3){
                outputValue=(Integer) numberList.pop();
            }
            else if(Q==4){
                outputValue=numberList.length();
            }
            else if(Q==5){
                outputValue=(Integer) numberList.topValue();
            }
            else if(Q==6){
                numberList.setDirection(P);
            }

            printList(numberList);
            System.out.println(outputValue);
            outputValue=-1;
        }
    }
}
