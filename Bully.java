
import java.io.*;  
import java.util.Scanner; 
public class Bully{
	static int n;  //number of processes
    static int pro[] = new int[100]; //priorities of process
    static int sta[] = new int[100]; //status of process 0 for inactive 1 for active
    static int co; //static declare the coordinator
     
    public static void main(String args[])throws IOException
    {
        System.out.println("Enter the number of process");
        Scanner in = new Scanner(System.in);//scans the input
        n = in.nextInt();
         
        int i;
         
        for(i=0;i<n;i++)
        {
            System.out.println("\nFor process "+(i+1)+":");
            System.out.println("\nStatus:");
            sta[i]=in.nextInt();
            System.out.println("\nPriority");
            pro[i] = in.nextInt();
        }
         
        System.out.println("\nWhich process will initiate election?");
        int ele = in.nextInt();
         
        elect(ele);
        System.out.println("\nFinal coordinator is "+co);
    }
     
    static void elect(int ele)
    {
        ele = ele-1; 
        co = ele+1;
        for(int i=0;i<n;i++)
        {
            if(pro[ele]<pro[i])
            {
                System.out.println("\nElection message is sent from "+(ele+1)+" to "+(i+1));
                if(sta[i]==1)
                    elect(i+1);
            }
        }
    }
}
