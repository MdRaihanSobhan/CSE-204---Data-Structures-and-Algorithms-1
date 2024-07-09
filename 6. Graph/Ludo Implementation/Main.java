import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static ludoSquare[] BFS (Integer edges[], int n, int dice){
        Queue<ludoSquare> queue =new LinkedList<>();
        ludoSquare[] visited = new ludoSquare[10001];
        for(int i=0;i<=n;i++){
            visited[i]= new ludoSquare(i,-1,-1);
        }
        ludoSquare square = new ludoSquare(1,1,1);
        queue.add(square);
        visited[1].height=0;
        visited[1].parent=0;

        while(!queue.isEmpty()){
            ludoSquare currentSquare = queue.peek();
            int currentIndex = currentSquare.index;
            queue.remove();
            for(int i=1;i+currentIndex<=n && i<=dice;i++){
                if(visited[i+currentIndex].height==-1){
                    int position = i+currentIndex;
                    visited[position].height= visited[currentIndex].height+1;
                    visited[position].parent=currentIndex;
                    while (edges[position]!=-1 && visited[edges[position]].height==-1) {
                        visited[edges[position]].parent = position;
                        position = edges[position];
                        visited[position].height = visited[currentIndex].height + 1;
                    }
                    if(edges[position]==-1){
                        queue.add(visited[position]);
                    }
                }

            }
        }


        return visited;
    }

    public static void main(String[] args) throws IOException {


        BufferedWriter bw = new BufferedWriter( new FileWriter("output.txt"));
        File input = new File("input.txt");
        Scanner scanner = new Scanner(input);

        int t= scanner.nextInt();
        while(t!=0) {
            int a;
            Integer edges[]= new Integer[10001];
            int die= scanner.nextInt();
            int n = scanner.nextInt();

            for(int i=0;i<=n; i++){
                edges[i]=-1;
            }

            int ladNum = scanner.nextInt();
            for(int k=0;k<ladNum; k++){
                a=scanner.nextInt();
                edges[a]=scanner.nextInt();
            }
            int snakNum = scanner.nextInt();
            for(int k=0;k<snakNum; k++){
                a=scanner.nextInt();
                edges[a]=scanner.nextInt();
            }

            ludoSquare[] moves= BFS(edges,n,die);
            if(moves[n].height== -1 ){
                bw.write("-1\nNo Solution\n");
            }
            else {
                bw.write(moves[n].height+ "\n");

                Integer path[] = new Integer[10001];
                int count =0, x = n;
                path[count++]= n;
                while ((moves[x].parent!=1)){
                    x=moves[x].parent;
                    path[count++]=x;
                }
                bw.write("1");
                for(int i=count-1; i>=0;i--){
                    bw.write(" -> "+ path[i]);
                }
                bw.write("\n");
            }
            int count =0;

            for(int i=2;i<=n;i++){
                if(moves[i].height==-1){
                    bw.write(i+ " ");
                    count++;
                }
            }
            if(count==0) {
                bw.write("All Reachable");
            }
            bw.write("\n\n");

            t--;
        }
        scanner.close();
        bw.close();
    }
}
