import mpi.MPI;
public class MPI1{ 
public static void main(String[] args) { 
MPI.Init(args); //receives command line argument
int root = 0; 
int rank = MPI.COMM_WORLD.Rank(); 
int size = MPI.COMM_WORLD.Size(); 
double[] buffer = new double[size]; 
double[] processBuffer = new double[1]; 
initBuffer(rank, root, buffer); 
scatterData(rank, root, buffer, processBuffer); 
processData(rank, processBuffer); 
gatherData(rank, root, buffer, processBuffer); 
MPI1.Finalize(); //shut down mpi method
} 
private static void initBuffer(int rank, int root, double[] inputBuffer) { 
if (rank == root) { 
inputBuffer[0] = 10; 
inputBuffer[1] = 20; 
inputBuffer[2] = 30;
inputBuffer[3] = 40; 
} 
} 
private static void scatterData(int rank, int root, double[] buffer, double[] processBuffer) { 
if (rank == root) { 
print("Scatter Data : "); 
for (double j : buffer) { 
print(j + " "); 
} 
print("\n"); 
} 
MPI.COMM_WORLD.Scatter(buffer, 0, 1, MPI.DOUBLE, processBuffer, 0, 1, MPI.DOUBLE, root); 
} 
private static void processData(int rank, double[] receiveBuffer) { double input = receiveBuffer[0]; 
double output = input / 3.281; 
print("Processing Data " + rank + " Input Feet : " + input + " Output Metres : " + output + "\n"); 
receiveBuffer[0] = output; 
}
private static void gatherData(int rank, int root, double[] buffer, double[] processBuffer) { 
MPI.COMM_WORLD.Gather(processBuffer, 0, 1, MPI.DOUBLE, buffer, 0, 1, MPI.DOUBLE, root); 
if (rank == root) { 
print("Gather Data : "); 
for (double j : buffer) { 
print(j + " "); 
} 
print("\n"); 
} 
} 
private static void print(String s) { 
System.out.print(s); 
} 
}
//javac -cp $MPJ_HOME/lib/mpj.jar MPI1.java
//export MPJ_HOME=/home/utkarsha/Downloads/mpj-v0_44
//$MPJ_HOME/bin/mpjrun.sh -np 4 MPI1



