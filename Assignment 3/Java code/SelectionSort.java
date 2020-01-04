
// Program to sort a list of integers using Selection Sort Technique

public class SelectionSort {

	private static int[] myArray = {9,7,2,4,1,5,3}; 
	private static int temp,min;
	
	// Function to perform Selection Sort
	
	/*
	 * 
	 * 
	 */
	
	public int[] selectionSort(int[] myArray)
	{
		for(int i=0;i<myArray.length;i++)
		{
//			element = myArray[i];
			min = i;
			for(int j=i+1;j<myArray.length;j++)
			{
				if(myArray[j]<myArray[min])
				{
					min = j;
				}
			}
			temp = myArray[min];
			myArray[min]=myArray[i];
			myArray[i]=temp;
			System.out.print("The Array after Iteration "+ (i+1) +" is : ");
			for(int k=0;k<myArray.length;k++)
				System.out.print(myArray[k]+ " ");
			System.out.println();
		}
		return myArray;
	}
	
	// Main Method
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.print("\nThe Array Before Sorting is : ");
		for(int i=0;i<myArray.length;i++)
			System.out.print(myArray[i]+ " ");
		System.out.println("\n");
		SelectionSort select = new SelectionSort();
		myArray= select.selectionSort(myArray);
		System.out.println();
		System.out.print("The Array After applying Selection Sort is : ");
		for(int i=0;i<myArray.length;i++)
			System.out.print(myArray[i]+ " ");
				
	}

}
