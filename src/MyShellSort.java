
public class MyShellSort {
	int testData[] = new int[13];
	boolean swapPerformed = false;
	int startPoint=1;
	int endPoint=testData.length;
	int gaps[] = {5,3,1};
	
	public MyShellSort()
	{
		testData[0] = 35;
		testData[1] = 5;
		testData[2] = 26;
		testData[3] = 4;
		testData[4] = 1;
		testData[5] = 99;
		testData[6] = 32;
		testData[7] = 11;
		testData[8] = 3;
		testData[9] = 1;
		testData[10] = 7;
		testData[11] = 15;
		testData[12] = 8;
	}
	
	public void insertionSort()
	{
		for(int slotExamined=1;slotExamined<endPoint;slotExamined++) 
		{
			int numberFromSlot = testData[slotExamined];
			int count;
			for(count = slotExamined; count>=startPoint && testData[count-1]>numberFromSlot; count--)
				{
				testData[count] = testData[count-1];
				}
			testData[count] = numberFromSlot;
	
					printArrayState();
		}
	}
	
	

	public void shellSort()
	{
		for(int delta : gaps)
		{
			for(int slotExamined=1;slotExamined<endPoint;slotExamined++) 
			{
				int numberFromSlot = testData[slotExamined];
				int count;
				for(count = slotExamined; count>=delta && testData[count-delta]>numberFromSlot; count-=delta)
					{
					testData[count] = testData[count-delta];
					}
				testData[count] = numberFromSlot;
		
						printArrayState();
			}
		}
	}
	
	
	public void printArrayState()
	{
		for(int x=0;x<testData.length;x++)
		{
			System.out.print(" " + testData[x]);
		}
		System.out.print("\n");
	}

}
