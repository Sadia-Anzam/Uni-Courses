import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Scheduling_Algo {

	void FCFS(Scanner Filescanner, FileWriter myWriter) throws IOException {
		int n;
		n = Filescanner.nextInt();

		int ar[] = new int[n];
		int bt[] = new int[n];
		int pid[] = new int[n];
		int ct[] = new int[n];
		int ta[] = new int[n];
		int wt[] = new int[n];

		for (int i = 0; i < n; i++) {
			pid[i] = Filescanner.nextInt();
			ar[i] = Filescanner.nextInt();
			bt[i] = Filescanner.nextInt();
		}
		int temp;
		float avgwt = 0, avgta = 0;

		// sorting according to arrival times

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - (i + 1); j++) {
				if (ar[j] > ar[j + 1]) {
					temp = ar[j];
					ar[j] = ar[j + 1];
					ar[j + 1] = temp;
					temp = bt[j];
					bt[j] = bt[j + 1];
					bt[j + 1] = temp;
					temp = pid[j];
					pid[j] = pid[j + 1];
					pid[j + 1] = temp;
				}
			}
		}

		// finding completion times
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				ct[i] = ar[i] + bt[i];
			} else {
				if (ar[i] > ct[i - 1]) {
					ct[i] = ar[i] + bt[i];
				} else
					ct[i] = ct[i - 1] + bt[i];
			}
			ta[i] = ct[i] - ar[i]; // turnaround time= completion time- arrival time
			wt[i] = ta[i] - bt[i]; // waiting time= turnaround time- burst time
			avgwt += wt[i]; // total waiting time
			avgta += ta[i]; // total turnaround time
		}

		System.out.println("#   First In First Out schiduling allgortihm. ");

		System.out.println("Pid  Arrival  Brust  Complete  Turn   Waiting");
		for (int i = 0; i < n; i++) {
			System.out.println(
					"  " + pid[i] + "  \t " + ar[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + ta[i] + "\t  " + wt[i]);
		}
		System.out.println("\nAverage waiting time:     " + (avgwt / n) + "s");
		System.out.println("Average turnaround time:  " + (avgta / n) + "s");

		try {
			myWriter.write("#   First Come First Serve Algorithm \n");
			myWriter.write("Pid  Arrival  Brust  Complete  Turn   Waiting   \n");
			for (int i = 0; i < n; i++) {
				myWriter.write("  " + pid[i] + "  \t " + ar[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + ta[i] + "\t  "
						+ wt[i] + "\n");
			}
			myWriter.write("\nAverage waiting time:     " + (avgwt / n) + "s   \n");
			myWriter.write("Average turnaround time:  " + (avgta / n) + "s   \n");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	void SJF_Non_Preemtive(Scanner Filescanner, FileWriter myWriter) throws IOException {

		int n = Filescanner.nextInt();
		
		
		int process_id[] = new int[n];
		int complete_time[] = new int[n];
		int arrival_time[] = new int[n];
		int burst_time[] = new int[n];
		int turn_around_time[] = new int[n];
		int waiting_time[] = new int[n];
		int f[] = new int[n];
		int st = 0, total_processes = 0;
		float avgwt = 0, avgta = 0;
		for (int i = 0; i < n; i++) {
			process_id[i] = Filescanner.nextInt();
			arrival_time[i] = Filescanner.nextInt();
			burst_time[i] = Filescanner.nextInt();
			f[i] = 0;
		}
		boolean a = true;
		while (true) {
			int c = n, min = 999;
			if (total_processes == n)
				break;

			for (int i = 0; i < n; i++) {

				if ((arrival_time[i] <= st) && (f[i] == 0) && (burst_time[i] < min)) {
					min = burst_time[i];
					c = i;
				}
			}

			if (c == n)
				st++;
			else {
				complete_time[c] = st + burst_time[c];
				st += burst_time[c];
				turn_around_time[c] = complete_time[c] - arrival_time[c];
				waiting_time[c] = turn_around_time[c] - burst_time[c];
				f[c] = 1;
				total_processes++;
			}
		}

		System.out.println("\nShortest Job First(Non-Preemtive) schiduling allgortihm. ");

		System.out.println("Pid  Arrival  Brust  Complete  Turn   Waiting");
		for (int i = 0; i < n; i++) {
			avgwt += waiting_time[i];
			avgta += turn_around_time[i];
			System.out.println(process_id[i] + "\t" + arrival_time[i] + "\t" + burst_time[i] + "\t" + complete_time[i]
					+ "\t" + turn_around_time[i] + "\t" + waiting_time[i]);
		}
		System.out.println("\nAverage waitting time is:    " + (float) (avgwt / n) + "s");
		System.out.println("Average trunaround time is:  " + (float) (avgta / n) + "s");

		try {
			myWriter.write("\n#  Shortest Job First(Non-Preemtive) schiduling allgortihm. \n");
			myWriter.write("Pid  Arrival  Brust  Complete  Turn   Waiting   \n");
			for (int i = 0; i < n; i++) {
				myWriter.write("  " + process_id[i] + "  \t " + arrival_time[i] + "\t" + burst_time[i] + "\t"
						+ complete_time[i] + "\t" + turn_around_time[i] + "\t  " + waiting_time[i] + "\n");
			}
			myWriter.write("\nAverage waiting time:     " + (avgwt / n) + "s   \n");
			myWriter.write("Average turnaround time:  " + (avgta / n) + "s   \n");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	void SJF_Preemtive(Scanner Filescanner, FileWriter myWriter) throws IOException {
		int n = Filescanner.nextInt();
		
		
		
		int pid[] = new int[n]; // it takes pid of process
		int at[] = new int[n]; // at means arrival time
		int bt[] = new int[n]; // bt means burst time
		int ct[] = new int[n]; // ct means complete time
		int ta[] = new int[n];// ta means turn around time
		int wt[] = new int[n]; // wt means waiting time
		int f[] = new int[n]; // f means it is flag it checks process is completed or not
		int k[] = new int[n]; // it is also stores brust time
		int st = 0, tot = 0;
		float avgwt = 0, avgta = 0;

		for (int i = 0; i < n; i++) {
			pid[i] = Filescanner.nextInt();
			at[i] = Filescanner.nextInt();
			bt[i] = Filescanner.nextInt();
			k[i] = bt[i];
			f[i] = 0;
		}

		while (true) {
			int min = 99, c = n;
			if (tot == n)
				break;

			for (int i = 0; i < n; i++) {
				if ((at[i] <= st) && (f[i] == 0) && (bt[i] < min)) {
					min = bt[i];
					c = i;
				}
			}

			if (c == n)
				st++;
			else {
				bt[c]--;
				st++;
				if (bt[c] == 0) {
					ct[c] = st;
					f[c] = 1;
					tot++;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			ta[i] = ct[i] - at[i];
			wt[i] = ta[i] - k[i];
			avgwt += wt[i];
			avgta += ta[i];
		}
		System.out.println("\nShortest Job First(Preemtive) schiduling allgortihm. ");
		System.out.println("pid  arrival  burst  complete turn waiting");
		for (int i = 0; i < n; i++) {
			System.out.println(pid[i] + "\t" + at[i] + "\t" + k[i] + "\t" + ct[i] + "\t" + ta[i] + "\t" + wt[i]);
		}

		System.out.println("\nAverage waitting time is:    " + (float) (avgwt / n) + "s");
		System.out.println("Average trunaround time is:  " + (float) (avgta / n) + "s");

		try {
			myWriter.write("\n#  Shortest Job First(Preemtive) schiduling allgortihm. \n");
			myWriter.write("\nPid  Arrival  Brust  Complete  Turn   Waiting  \n");
			for (int i = 0; i < n; i++) {
				myWriter.write("  " + pid[i] + "  \t " + at[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + ta[i] + "\t  "
						+ wt[i] + "\n");
			}
			myWriter.write("\nAverage waiting time:     " + (avgwt / n) + "s   \n");
			myWriter.write("Average turnaround time:  " + (avgta / n) + "s   \n");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
}
