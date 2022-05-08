//package ring;
import java.util.Scanner;

public class ring {

	public static void main(String[] args) {
		int temp, i, j;
		char str[] = new char[10];
		Rr proc[] = new Rr[10];
        // object initialisation
		for (i = 0; i < proc.length; i++)
			proc[i] = new Rr();

        // scanner used for getting input from console
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of process : ");
		int num = in.nextInt();

// getting input from users
		for (i = 0; i < num; i++) {
			proc[i].index = i;
			System.out.println("Enter the id of process : ");
			proc[i].id = in.nextInt();
			proc[i].state = "active";
			proc[i].f = 0;
		}


// sorting the processes from on the basis of id
		for (i = 0; i < num - 1; i++) {
			for (j = 0; j < num - 1; j++) {
				if (proc[j].id > proc[j + 1].id) {
					temp = proc[j].id;
					proc[j].id = proc[j + 1].id;
					proc[j + 1].id = temp;
				}
			}
		}


		for (i = 0; i < num; i++) {
			System.out.print("  [" + i + "]" + " " + proc[i].id);
		}




		int init;
		int ch;
		proc[num - 1].state = "inactive";

		System.out.println("\n process " + proc[num - 1].id + "select as co-ordinator");

		while (true) {
			System.out.println("\n 1.election \n2.quit ");
			ch = in.nextInt();

			for (i = 0; i < num; i++) {
				proc[i].f = 0;
			}

			switch (ch) {
			case 1:
				System.out.println("\n Enter the Process number who initialsied election : ");
				init = in.nextInt();
				System.out.println(init);
				break;
			case 2:
            System.out.println("Program terminated ...");
            return ;
			default:
				System.out.println("\n invalid response \n");
				break;
			}


		}
	}

}

class Rr {

	public int index;   // to store the index of process
	public int id;      // to store id/name of process
	public int f;
	String state;       // indiactes whether active or inactive state of node

}