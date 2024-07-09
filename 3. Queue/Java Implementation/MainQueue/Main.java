package MainQueue;

import java.util.Scanner;

public class Main {
    public static <T> void printQueue(Queue<T> queue){
//        Arr<T> tempQueue= new Arr<>();
        LL<T> tempQueue= new LL<>();
        while (queue.length()>0){
            T temp= queue.dequeue();
            tempQueue.enqueue(temp);
        }
        boolean flag= false;
        System.out.print("<");
        while (tempQueue.length()>0){
            if (flag) {
                System.out.print(" , ");
            }
            else {
                flag= true;
            }
            T temp= tempQueue.dequeue();
            System.out.print(temp);
            queue.enqueue(temp);
        }
        System.out.println(">");
    }

    public static<T> void main(String[] args) {
        int outputValue = -1;
        Scanner scanner = new Scanner(System.in);
        int givenLength = scanner.nextInt();
        Arr<Integer> numberList = new Arr<>(givenLength);
//        LL<Integer> numberList= new LL<>(givenLength);

        for (int i=0; i<givenLength; i++) {
            numberList.enqueue(scanner.nextInt());
        }
        printQueue(numberList);
        while (true){
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
                numberList.enqueue(P);
            }
            else if(Q==3){
                outputValue=(Integer) numberList.dequeue();
            }
            else if(Q==4){
                outputValue=numberList.length();
            }
            else if(Q==5){
                outputValue=(Integer) numberList.frontValue();
            }
            else if(Q==6){
                outputValue=(Integer) numberList.rearValue();
            }
            else if(Q==7){
                numberList.leaveQueue();
            }
            printQueue(numberList);
            System.out.println(outputValue);
            outputValue=-1;
        }

    }
}
