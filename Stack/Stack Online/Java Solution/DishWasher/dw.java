package DishWasher;
import StackADT.Arr;
import StackADT.LL;
import StackADT.Stack;

import java.util.Scanner;

public class dw {
    public static<T> void printList(Stack<T> stack){

/*        Arr<T> stack1 = new Arr<>();
        Arr<T> stack2= new Arr<>();*/

        LL<T> stack1 = new LL<>();
        LL<T> stack2 = new LL<>();

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
        int n, x, k, t, s, currTime;
        Scanner scanner= new Scanner(System.in);
        n= scanner.nextInt();  // total number of friends
        x= scanner.nextInt();   // number of dishes in the course
        int friends[]=new int[n]; // array for friends count who has eaten how many dishes
        int washTimes[]=new int[x]; // time needed to wash the dishes of each dish of the course
        Integer dishes[]=new Integer[x*n]; // max number of dirty dishes can be x*n number

        /*LL<Integer> dirtyDishes=new LL<>(dishes);
        LL<Integer> cleanedDishes=new LL<>(dishes);*/

        Arr<Integer> cleanedDishes=new Arr<>(dishes,-1);
        Arr<Integer> dirtyDishes=new Arr<>(dishes,1);

        int totalFriends = friends.length;
        for(int i=0;i<totalFriends;i++){
            friends[i]=0;  // keeping the count of number of dishes eaten by each friend
        }
        int totalDishes = washTimes.length;
        for(int i=0;i<totalDishes;i++){
            washTimes[i]=scanner.nextInt(); // taking the input of wash time of the dishes of each course
        }
        currTime=0; // total time needed to wash all dishes

        while(true){
            k= scanner.nextInt();    // which friend is pushing the dish
            t= scanner.nextInt();   // time of pushing
            s= scanner.nextInt();   // index of which course the dish was used for


            if(k==0){
                while(dirtyDishes.length()!=0){
                    currTime+= dirtyDishes.pop();
                    cleanedDishes.push(currTime-1);
                }
                break;
            }

            friends[k-1]++;  // kth friend has eaten 1 course

            if(t<currTime){ // t endTime er cheye kom, tar mane ager gulai wash kora shesh hoy nai , jomaye rakhi dirty te
                dirtyDishes.push(washTimes[s-1]);
            }
            else if(t==currTime){   // t ar endtime same, tar mane ami dirty te rakhbo and wash kore felbo
                dirtyDishes.push(washTimes[s-1]);
                currTime+= dirtyDishes.pop();
                cleanedDishes.push(currTime-1);
            }
            else{           // t endtime er cheye beshi , tar mane ami ager dirty gula wash korte thakbo
                            // jotokhkhon na new dish ashe othoba dirty dish shesh hoy
                while(t>currTime && dirtyDishes.length()!=0){
                    currTime+= dirtyDishes.pop();
                    cleanedDishes.push(currTime-1);
                }
                currTime=t; // t porjonto to emniteo boshe thaka lagbe
                dirtyDishes.push(washTimes[s-1]);
                currTime+= dirtyDishes.pop();
                cleanedDishes.push(currTime-1);
            }
        }

        currTime--;                     // endtime minute count kore, koto tomo minute ta count kore na, tai 1 minus
        System.out.println(currTime);
        printList(cleanedDishes);

        int eaten=0;
        int eatAll =1;              // eatAll 1 hole shobai shob item kheyeche , 0 hole No

        for(int i=0;i<n;i++){
            if(friends[i]!=x){
                eatAll=0;
            }
            else
                eaten++;
        }
        if(eatAll==1){
            System.out.println("Y");
        }
        else {
            System.out.println("N");
        }
        int temp=0;
        for(int i=0;i<n;i++){
            if(friends[i]==x){
                System.out.print(i+1);
                temp++;
                if(temp<eaten)
                    System.out.print(",");
            }

        }
        System.out.println();
    }
}
