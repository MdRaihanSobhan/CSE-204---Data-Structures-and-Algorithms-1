package BankQueue;
import MainQueue.Arr;
import MainQueue.LL;
import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n=scanner.nextInt();
        int Queue_1_Time=0,Queue_2_Time=0;
        int currTime =0;

        int[] timeCounter=new int[3];
        Client[] clients =new Client[n];

/*        Arr<Client> Queue1=new Arr<>();
        Arr<Client> Queue2=new Arr<>();*/

        LL<Client> Queue1=new LL<>();
        LL<Client> Queue2=new LL<>();


        Client teller_1 = new Client(0);
        Client teller_2 = new Client(0);

        for(int i=0;i<n;i++)
        {
            int enterTime=scanner.nextInt();
            int serviceDuration=scanner.nextInt();
            clients[i]=new Client(enterTime,serviceDuration);
            clients[i].setId(i);
        }
        int clientIndex=0;
        while (Queue1.length()>0 || Queue2.length()>0 || teller_1.getAvailable()>0 || teller_2.getAvailable()>0 || clientIndex<n)
        {
            //if its currTime to leave the customer in teller1
            if(teller_1.getAvailable()>0 && currTime==teller_1.getLeaveTime())
            {
                // first 3 lines are for debugging and clear understanding
/*                clients[teller_1.getId()].setQueueNumber(1);
                clients[teller_1.getId()].setLeaveTime(teller_1.getLeaveTime());*/
/*                System.out.println("At currTime"+ currTime + " client number "+ teller_1.getId() + " Leaves from teller_1");*/

                teller_1.setAvailable(0);
            }
            //if its currTime leave the customer in teller2
            if(teller_2.getAvailable()>0 && currTime== teller_2.getLeaveTime())
            {
                // first 3 lines are for debugging and clear understanding
/*                clients[teller_2.getId()].setQueueNumber(2);
                clients[teller_2.getId()].setLeaveTime(teller_2.getLeaveTime());*/
/*                System.out.println("At currTime "+ currTime + " client number "+ teller_2.getId() + " Leaves from teller_2");*/
                teller_2.setAvailable(0);
            }
            //if teller1 is empty
            if(teller_1.getAvailable()==0 && Queue1.length()!=0)
            {
                // If the first client who will be waiting at queue 1 hasn't come yet  (at Queue_1_Time)
                if(Queue_1_Time< Queue1.frontValue().getEnterTime())
                    Queue_1_Time=Queue1.frontValue().getEnterTime();

                Queue_1_Time+= Queue1.frontValue().getServiceDuration();
                Queue1.frontValue().setLeaveTime(Queue_1_Time);

                teller_1= Queue1.dequeue();
                timeCounter[1]= teller_1.getLeaveTime();

/*                System.out.println("At currTime "+ currTime + " Client number "+ teller_1.getId() + " enters into teller_1");*/
            }
/*            if teller2 is empty*/
            if(teller_2.getAvailable()==0 && Queue2.length()!=0)
            {
                // If the first client who will be waiting at queue 2 hasn't come yet  (at Queue_2_Time)
                if(Queue_2_Time< Queue2.frontValue().getEnterTime())
                    Queue_2_Time=Queue2.frontValue().getEnterTime();

                Queue_2_Time+= Queue2.frontValue().getServiceDuration();
                Queue2.frontValue().setLeaveTime(Queue_2_Time);

                teller_2 = Queue2.dequeue();
                timeCounter[2]= teller_2.getLeaveTime();
/*                System.out.println("At currTime "+ currTime + " Client number "+ teller_2.getId() + " enters into teller_2");*/
            }

            //If both the teller is full
            if(clientIndex<n && clients[clientIndex].getEnterTime()==currTime)
            {
                //if both queue are equally filled
                if(Queue1.length()+ teller_1.getAvailable() ==Queue2.length()+ teller_2.getAvailable())
                {
                    // if client choose queue 1
/*                    Queue1.enqueue(clients[clientIndex]); */

                    // if client choose queue 2
                    Queue2.enqueue(clients[clientIndex]);
                }
                // if queue1 is longer than queue2 , client will chose the second one
                else if((Queue1.length()+ teller_1.getAvailable())> (Queue2.length()+ teller_2.getAvailable()))
                {
                    Queue2.enqueue(clients[clientIndex]);
                }

                // otherwise he will choose queue 1
                else{
                    Queue1.enqueue(clients[clientIndex]);
                }
                clientIndex++;
            }

            // if customer switches the queue
            if((Queue1.length()+ teller_1.getAvailable())- (Queue2.length()+ teller_2.getAvailable())>1)
            {
                Queue2.enqueue(Queue1.leaveQueue());
            }
            else if((Queue2.length()+ teller_2.getAvailable())-( Queue1.length()+ teller_1.getAvailable())>1)
            {
                Queue1.enqueue(Queue2.leaveQueue());
            }

            // if some client is waiting in the queue but one or both of the teller is/are empty, continue
            if((teller_1.getAvailable()==0 && Queue1.length()!=0) ||
                    (teller_2.getAvailable()==0 && Queue2.length()!=0))
                continue;

/*            System.out.println("Time : "+ currTime);
            System.out.println(timeCounter[0]+ " " + timeCounter[1]+ " " + timeCounter[2]);*/

            // timecounters: 0 te ache last client er enter currTime, 1 e thakbe teller 1 next kobe khali hobe
            // 2 the thakbe teller 2 next kobe khali hobe


            if(clientIndex<n) {
                // someone is waiting in the queue
                timeCounter[0] = clients[clientIndex].getEnterTime();
            }
            else {
                // there's no one who is waiting in the queue
                timeCounter[0]=0;
            }
            // teller 1 empty
            if(teller_1.getAvailable()==0) {
                timeCounter[1]= 0;
            }
            // teller 2 empty
            if(teller_2.getAvailable()==0){
                timeCounter[2]= 0;
            }
            if(timeCounter[0]>0){
                // last je waiting e thakbe tar enter currTime tai present timecount
                currTime=timeCounter[0];
            }
            else if(timeCounter[1]>0) {
                // keu waiting e na thakle teller 1 khali hoer currTime ta present timeCount
                currTime=timeCounter[1];
            }
            else if(timeCounter[2]>0){
                // same as 1
                currTime=timeCounter[2];
            }
            for(int i=0;i<3;i++)
            {
                if(currTime>timeCounter[i] && timeCounter[i]>0)
                    // jokhon last dhuka client er enter currTime , next kono teller khali hoer entertime er cheye beshi hoy
                    // tokhon present timeCount hobe kono teller khali hoer lowest currTime
                    currTime=timeCounter[i];
            }
/*            System.out.println("Changed Time : "+ currTime);
            System.out.println(timeCounter[0]+ " " + timeCounter[1]+ " " + timeCounter[2]);*/
        }
        System.out.println("Booth 1 finishes service at t="+Queue_1_Time);
        System.out.println("Booth 2 finishes service at t="+Queue_2_Time);
    }
}
