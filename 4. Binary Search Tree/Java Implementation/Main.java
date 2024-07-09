import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File textFile = new File("F:\\1905095\\src\\TextFile.txt");
        try {
            Scanner scanner = new Scanner(textFile);

            BST bst = new BST();
            while(scanner.hasNext()){

                String commandChar=scanner.next();

                if(commandChar.equalsIgnoreCase("I")){
                    if(bst.getRootNode()==null)
                        bst=new BST(scanner.nextInt());
                    else
                        bst.Insert(scanner.nextInt());
                }
                else if(commandChar.equalsIgnoreCase("F")){
                    if(bst.getRootNode()==null)
                        System.out.println("False");
                    else {
                        if (bst.Find(scanner.nextInt()) == true)
                            System.out.println("True");
                        else System.out.println("False");
                    }
                }
                else if(commandChar.equalsIgnoreCase("D")){
                     bst.Delete(scanner.nextInt());
                }
                else if(commandChar.equalsIgnoreCase("T")){
                    String type = scanner.next();
                    if(type.equalsIgnoreCase("In"))
                        bst.InOrder();
                    else if(type.equalsIgnoreCase("Pre"))
                        bst.PreOrder();
                    else if(type.equalsIgnoreCase("Post"))
                        bst.PostOrder();
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
