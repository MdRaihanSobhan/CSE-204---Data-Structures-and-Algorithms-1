package TNL;

import java.util.Scanner;
import MainProject.Arr;
import MainProject.LL;
import MainProject.List;

public class TNL<T> {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K,L,M,T;
//        System.out.println("Enter the number of Rickshaw Stops: ");
        K= scanner.nextInt();
        Integer[] RS= new Integer[K];
        for(int i=0;i<K;i++){
            RS[i]=i;
        }
//        System.out.println("Enter the number of Bus Stops: ");
        L= scanner.nextInt();
//        System.out.println("Enter the position of all Bus Stops: ");
        Integer[] BS= new Integer[L];
        for(int i=0;i<L;i++){
            BS[i]= scanner.nextInt();
        }

//        System.out.println("Enter the number of Train Stations: ");
        M= scanner.nextInt();
//        System.out.println("Enter the position of all Train Stations: ");
        Integer[] TS= new Integer[M];
        for(int i=0;i<M;i++){
            TS[i]= scanner.nextInt();
        }

//        System.out.println("Enter the task number to perform : ");
        T= scanner.nextInt();

        LL<Integer> RickshawStopPositions = new LL<>(K, RS);
//        Arr<Integer> RickshawStopPositions = new Arr<>(K, K, RS);

        LL<Integer> BusStopPositions = new LL<>(L, BS);
//        Arr<Integer> BusStopPositions = new Arr<>(L,L,BS);

        LL<Integer> TrainStationPositions = new LL<>(M, TS);
//        Arr<Integer> TrainStationPositions = new Arr<>(M,M,TS);

        if(T==1){
            RickshawStopPositions.moveToStart();
            for(int i=0; i<K; i++ ){
                int output= RickshawStopPositions.getValue();
                System.out.print(output);
                RickshawStopPositions.next();

                if(i<K-1) System.out.print(",");
                else System.out.println();
            }
            RickshawStopPositions.moveToStart();

            BusStopPositions.moveToStart();
            for(int i=0;i<K;i++){

                int index= BusStopPositions.Search(i);
                if(index!=-1 && i<K-1) {
                    System.out.print(BusStopPositions.getValue() + ",");
                    BusStopPositions.next();
                }
                else if(index!=-1) {
                    System.out.print(BusStopPositions.getValue());
                    System.out.println();
                }
                else
                    System.out.print(",");

            }
            BusStopPositions.moveToStart();

            TrainStationPositions.moveToStart();
            for(int i=0;i<K;i++){

                int index= TrainStationPositions.Search(i);
                if(index!=-1 && i<K-1) {
                    System.out.print(TrainStationPositions.getValue() + ",");
                    TrainStationPositions.next();
                }
                else if(index!=-1) {
                    System.out.print(TrainStationPositions.getValue());
                    System.out.println();
                }
                else
                    System.out.print(",");

            }
            TrainStationPositions.moveToStart();
        }
    }
}
