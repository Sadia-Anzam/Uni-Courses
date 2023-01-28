import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {	
	public static void main(String[] args) throws IOException {
			
		File Scheduling_fstram = new File("Scheduling_Input.txt");
		Scanner Schedule1 = new Scanner(Scheduling_fstram);
		Scanner Schedule2 = new Scanner(Scheduling_fstram);
		Scanner Schedule3 = new Scanner(Scheduling_fstram);
		
		File Memory_fstram = new File("Memory_Input.txt");
		Scanner Memory1 = new Scanner(Memory_fstram);
		Scanner Memory2 = new Scanner(Memory_fstram);
		Scanner Memory3 = new Scanner(Memory_fstram);		
		
		FileWriter Schedule_Writer = new FileWriter("Scheduling_Output.txt");
		FileWriter Memory_Writer = new FileWriter("Memory_Output.txt");		
		
		Scheduling_Algo obj = new Scheduling_Algo();
		Memory_MAnagement_Algo obj2 = new Memory_MAnagement_Algo();
		
		System.out.println("\n<<<<<  Scheduling Algorithms >>>>\n");		
		obj.FCFS(Schedule1, Schedule_Writer );
		Schedule1.close();
		obj.SJF_Non_Preemtive(Schedule2, Schedule_Writer );
		Schedule2.close();
		obj.SJF_Preemtive(Schedule3, Schedule_Writer );
		Schedule3.close();	
		
		System.out.println("\n<<<<<  Page Replacement Algorithms >>>>\n");		
		obj2.FIFO(Memory1, Memory_Writer);
		Memory1.close();		
		obj2.LRU(Memory2, Memory_Writer);
		Memory2.close();		
		obj2.OPR(Memory3, Memory_Writer);
		Memory3.close();	
		
		Schedule_Writer.close();
		Memory_Writer.close();
		
		
	}

}
