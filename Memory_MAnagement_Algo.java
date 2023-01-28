import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Memory_MAnagement_Algo {

	void FIFO(Scanner Filescanner, FileWriter myWriter) throws IOException {

		int n;
		int Frame;
		int Hit = 0;
		int Fault = 0;
		float Hit_Ratio;
		float Fault_Ratio;
		Frame = Filescanner.nextInt();
		int fifo[] = new int[Frame];
		n = Filescanner.nextInt();
		int inp[] = new int[n];

		for (int i = 0; i < n; i++) {

			inp[i] = Filescanner.nextInt();
		}
		for (int i = 0; i < Frame; i++) {

			fifo[i] = -1;
		}
		int j = 0;
		boolean check;
		for (int i = 0; i < n; i++) {
			check = false;

			for (int k = 0; k < Frame; k++) {
				if (fifo[k] == inp[i]) {
					check = true;
					Hit = Hit + 1;
				}
			}
			if (check == false) {
				fifo[j] = inp[i];
				j++;
				if (j >= Frame) {

					j = 0;
				}

				Fault = Fault + 1;
			}

		}
		Hit_Ratio = (float) Hit / (float) n;
		Fault_Ratio = (float) Fault / (float) n;
		System.out.println("#  First In First Out (FIFO) ");
		System.out.println("Number of Hit: " + Hit);
		System.out.println("Number of Faults: " + Fault);
		System.out.println("Hit Ratio: " + Hit_Ratio);
		System.out.println("Fault Ratio: " + Fault_Ratio);
		
		System.out.println();

		try {
			myWriter.write("#  First In First Out (FIFO) \n\n");
			myWriter.write("Number of Hit: " + Hit + "\n");
			myWriter.write("Number of Faults: " + Fault + "\n");
			myWriter.write("Hit Ratio: " + Hit_Ratio + "\n");
			myWriter.write("Fault Ratio: " + Fault_Ratio + "\n");

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	 void LRU(Scanner Filescanner, FileWriter myWriter) throws IOException 
	    {
		 
		 float Hit_Ratio;
		 float Fault_Ratio;
	        
	        int frames,pointer = 0, hit = 0, fault = 0,ref_len;
	        Boolean isFull = false;
	        int buffer[];
	        ArrayList<Integer> stack = new ArrayList<Integer>();
	        int reference[];
	        
	        frames = Filescanner.nextInt();
	       
	        ref_len = Filescanner.nextInt();
	        
	        reference = new int[ref_len];
	        buffer = new int[frames];
	        
	        for(int j = 0; j < frames; j++) {
	        	buffer[j] = -1;
	        }	                
	        
	        for(int i = 0; i < ref_len; i++)
	        {
	            reference[i] = Filescanner.nextInt();
	        }
	        
	        
	        for(int i = 0; i < ref_len; i++)
	        {
	            if(stack.contains(reference[i]))
	            {
	             stack.remove(stack.indexOf(reference[i]));
	            }
	            stack.add(reference[i]);
	            int search = -1;
	            for(int j = 0; j < frames; j++)
	            {
	                if(buffer[j] == reference[i])
	                {
	                    search = j;
	                    hit++;
	                    break;
	                }
	            }
	            if(search == -1)
	            {
	             if(isFull)
	             {
	              int min_loc = ref_len;
	                    for(int j = 0; j < frames; j++)
	                    {
	                     if(stack.contains(buffer[j]))
	                        {
	                            int temp = stack.indexOf(buffer[j]);
	                            if(temp < min_loc)
	                            {
	                                min_loc = temp;
	                                pointer = j;
	                            }
	                        }
	                    }
	             }
	                buffer[pointer] = reference[i];
	                fault++;
	                pointer++;
	                if(pointer == frames)
	                {
	                 pointer = 0;
	                 isFull = true;
	                }
	            }
	        }
	        
	        Hit_Ratio = (float) hit / (float) ref_len;
			Fault_Ratio = (float) fault / (float) ref_len;
			System.out.println("\n#  Least Recently Used (LRU) ");
			System.out.println("Number of Hit: " + hit);
			System.out.println("Number of Faults: " + fault);
			System.out.println("Hit Ratio: " + Hit_Ratio);
			System.out.println("Fault Ratio: " + Fault_Ratio);
			
			System.out.println();

			try {
				myWriter.write("\n#  Least Recently Used (LRU) \n\n");
				myWriter.write("Number of Hit: " + hit + "\n");
				myWriter.write("Number of Faults: " + fault + "\n");
				myWriter.write("Hit Ratio: " + Hit_Ratio + "\n");
				myWriter.write("Fault Ratio: " + Fault_Ratio + "\n");

			} catch (IOException e) {

				e.printStackTrace();
			}
	    }
	
	 void OPR (Scanner Filescanner, FileWriter myWriter) throws IOException 
	    {
	        int frames, pointer = 0, hit = 0, fault = 0,ref_len;
	        float Hit_Ratio = 0, Fault_Ratio = 0;
	        boolean isFull = false;
	        int buffer[];
	        int reference[];
	        
	        
	        frames = Filescanner.nextInt();

	        ref_len = Filescanner.nextInt();
	        
	        reference = new int[ref_len];
	
	        buffer = new int[frames];
	        for(int j = 0; j < frames; j++) {
	        	
	        	buffer[j] = -1;
	        }
	                
	        
	        for(int i = 0; i < ref_len; i++)
	        {
	            reference[i] = Filescanner.nextInt();
	        }
	        System.out.println();
	        for(int i = 0; i < ref_len; i++)
	        {
	         int search = -1;
	         for(int j = 0; j < frames; j++)
	         {
	          if(buffer[j] == reference[i])
	          {
	           search = j;
	           hit++;
	           break;
	          } 
	         }
	         if(search == -1)
	         {
	          if(isFull)
	          {
	           int index[] = new int[frames];
	           boolean index_flag[] = new boolean[frames];
	           for(int j = i + 1; j < ref_len; j++)
	           {
	            for(int k = 0; k < frames; k++)
	            {
	             if((reference[j] == buffer[k]) && (index_flag[k] == false))
	             {
	              index[k] = j;
	              index_flag[k] = true;
	              break;
	             }
	            }
	           }
	           int max = index[0];
	           pointer = 0;
	           if(max == 0)
	            max = 200;
	           for(int j = 0; j < frames; j++)
	           {
	            if(index[j] == 0)
	             index[j] = 200;
	            if(index[j] > max)
	            {
	             max = index[j];
	             pointer = j;
	            }
	           }
	          }
	          buffer[pointer] = reference[i];
	          fault++;
	          if(!isFull)
	          {
	           pointer++;
	              if(pointer == frames)
	              {
	               pointer = 0;
	               isFull = true;
	              }
	          }
	         }

	        }
	        
	       
	        Hit_Ratio = (float) hit / (float) ref_len;
			Fault_Ratio = (float) fault / (float) ref_len;
			System.out.println("\n#  Optimal Page Replagement (OPR) ");
			System.out.println("Number of Hit: " + hit);
			System.out.println("Number of Faults: " + fault);
			System.out.println("Hit Ratio: " + Hit_Ratio);
			System.out.println("Fault Ratio: " + Fault_Ratio);
			
			System.out.println();

			try {
				myWriter.write("\n#  Optimal Page Replagement (OPR) \n\n");
				myWriter.write("Number of Hit: " + hit + "\n");
				myWriter.write("Number of Faults: " + fault + "\n");
				myWriter.write("Hit Ratio: " + Hit_Ratio + "\n");
				myWriter.write("Fault Ratio: " + Fault_Ratio + "\n");

			} catch (IOException e) {

				e.printStackTrace();
			}
	    }
	
}
