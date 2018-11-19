public class MyCocktailSort {
	int testData[] = new int[13];
	boolean swapPerformed = false;
	int startPoint=0;
	int endPoint=testData.length;
	
	public MyCocktailSort()
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
	
	public void bubbleSort()
	{
		for(int count = 1; count < testData.length; count ++)
		{
			
			for( int innerCount = 0; innerCount < testData.length-count; innerCount++)
				{
					if(testData[innerCount] > testData[innerCount+1])
					{
						int temp = testData[innerCount];
						testData[innerCount]=testData[innerCount+1];
						testData[innerCount+1] = temp;
				
					}
					
				}
			for(int x=0;x<testData.length;x++)
			{
				System.out.print(" " + testData[x]);
			}
			System.out.print("\n");
		}
	}
	
public void cocktailSort() {
	swapPerformed = false;
	for(int count = startPoint; count < endPoint-1; count ++)
	{
		
				if(testData[count] > testData[count+1])
				{
					int temp = testData[count];
					testData[count]=testData[count+1];
					testData[count+1] = temp;
					swapPerformed=true;
				}
				
	}
		printArrayState();
	endPoint--;
	for(int count = endPoint-1; count > startPoint; count--)
	{
		
				if(testData[count] < testData[count-1])
				{
					int temp = testData[count];
					testData[count]=testData[count-1];
					testData[count-1] = temp;
					swapPerformed = true;
				}
				
	}
	startPoint++;
	printArrayState();
	if(swapPerformed)
	{
		cocktailSort();
	}
	else
		System.out.println("The Array is sorted!");

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
