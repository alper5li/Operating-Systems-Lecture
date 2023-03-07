
public class Process 
{
	int RID; // Resource ID
	
	int [] Allocated;
	int [] Need ;
	int [] Max;
	
	int MaxCounter;
	int NeedCounter;
	int AllocatedCounter;
	

	
	public Process [] CreateProcesses(int ProcessNumber,int ResourceNumber)
	{
		Process[] ProcessList = new Process[ProcessNumber];
		
		
		for(int i=0; i<ProcessNumber; i++) 
		{
			System.out.println("Process ["+i+"]");
			System.out.println("_____________________________");
			ProcessList[i] = new Process(ResourceNumber);
			System.out.println(ProcessInformation(ProcessList[i],ResourceNumber));
		}
		
		return ProcessList;
	}
	
	public Process() {
		
	}
	
	public Process(int ResourceNumber)
	{
		this.Max= new int[ResourceNumber];
		this.Need = new int[ResourceNumber];
		this.Allocated = new int[ResourceNumber];
		
		
		for(int i=0;i<ResourceNumber;i++)
		{
			int RID= i;
			int Max = RandomInt(9);
			int Allocated = RandomInt(Max);
			int Need = (Max - Allocated);
			
			this.RID = RID;
			this.Allocated[RID] = Allocated;
			this.Need[RID] = Need;
			this.Max[RID] = Max;
			
			this.AllocatedCounter += Allocated;
			this.NeedCounter += Need;
			this.MaxCounter += Max;
			
			CounterInformation();
		}
		
	}
	
	public int RandomInt(int integer) {
		return (int) (Math.random() * integer);
	}

	public String ProcessInformation(Process p,int ResourceNumber)
	{
		String information = "";
		for(int c=0;c<ResourceNumber;c++)
		{
			information += ("Process Allocated for R"+c+": "+p.Allocated[c]+"\n");
			information += ("Process Max for R"+c+": "+p.Max[c]+"\n");
			information += ("Process Need for R"+c+": "+p.Need[c]+"\n");
		}
		
		return information;

		
	}

	public String CounterInformation()
	{
		String information = "";
		information += "Max Counter for R"+this.RID+" "+this.MaxCounter+"\n";
		information += "Allocated Counter for R"+this.RID+" "+this.AllocatedCounter+"\n";
		information += "Need Counter for R"+this.RID+" "+this.NeedCounter+"\n";
		
		return information;
	}

	public void table(Process [] X) 
	{
		System.out.println("______________________________________________________________________________");
		System.out.println("|_____|Allocated|_____|_____|Max|_____|_____|Need|_____|_____|Available|_____|");
		System.out.println("|_____|____|____|_____|___|___|___|___|___|___|___|____|____|_____|_____|____|");
	}
}
