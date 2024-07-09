package MainProject;
import java.util.Scanner;

public class Main {
    public static <T> void printList(List<T> list){
        if (list.length() == 0){
            System.out.println("<>");
            return;
        }
        int actualPosition = list.currPos();
        int length = list.length();
        list.moveToStart();
        int outputCount = 0;
        System.out.print("<");
        while (outputCount < list.length()){
            T output = list.getValue();
            if (outputCount == actualPosition) {
                System.out.print("| ");
            }
            System.out.print(output);
            outputCount++;
            if (outputCount < length) System.out.print(" ");
            list.next();
        }
        if (actualPosition == length) System.out.print("|");
        System.out.println(">");
        list.moveToPos(actualPosition);
    }

    public static void main(String[] args) {
        int outputValue = -1;
        Scanner scanner = new Scanner(System.in);
        int givenLength = scanner.nextInt();
        int chunkSize = scanner.nextInt();

        Integer[] ara = new Integer[givenLength];
        for (int i=0; i<givenLength; i++) {
            ara[i] = scanner.nextInt();
        }
//        Arr<Integer> numberList = new Arr<>(chunkSize, givenLength, ara);
        LL<Integer> numberList = new LL<>(givenLength, ara);
        printList(numberList);

        while (true){
            int Q, P;
            Q = scanner.nextInt();
            P = scanner.nextInt();
            if (Q == 0) break;
            else if(Q==1) numberList.clear();
            else if(Q==2) numberList.insert(P);
            else if(Q==3) numberList.append(P);
            else if(Q==4) {
                Integer element = numberList.remove();
                if (element == null) outputValue = -1;
                else outputValue  = element;
            }
            else if(Q==5) numberList.moveToStart();
            else if(Q==6) numberList.moveToEnd();
            else if(Q==7) numberList.prev();
            else if(Q==8) numberList.next();
            else if(Q==9) outputValue = numberList.length();
            else if(Q==10) outputValue = numberList.currPos();
            else if(Q==11) numberList.moveToPos(P);
            else if(Q==12) {
                Integer that = numberList.getValue();
                if (that == null) outputValue = -1;
                else outputValue  = that;
            }
            else if(Q==13) outputValue = numberList.Search(P);
            else System.out.println("Wrong Input");


            printList(numberList);
            System.out.println(outputValue);
            outputValue = -1;
        }
    }
}
