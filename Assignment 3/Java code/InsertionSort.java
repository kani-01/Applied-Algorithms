
// Program to sort a list of integers using Insertion Sort Technique

public class InsertionSort 
{
	private static int[] myArray = {9,7,2,4,1,5,3}; 
	
	// Function to perform Insertion Sort
	
	/*
	 * In Insertion sort, an element from unsorted part is transferred to Sorted part
	 * While inserting to sorted part, it is inserted into the correct position (in Ascending order)
	 */
	
	public int[] insertionSort(int[] myArray)
	{
		int ele,temp;		
		for(int j=1;j<myArray.length;j++)
		{
			for(int i=0;i<j;i++)
			{
				ele=myArray[i];
				if(myArray[j]<ele)
				{
					temp=myArray[j];
					myArray[j]=ele;
					myArray[i]=temp;
				}
			}
			System.out.print("The array after Iteration "+j+" is : ");
			for(int i=0;i<myArray.length;i++)
			System.out.print(myArray[i]+" ");
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
		InsertionSort insert = new InsertionSort();
		myArray= insert.insertionSort(myArray);
		System.out.println();
		System.out.print("The Array After applying Insertion Sort is : ");
		for(int i=0;i<myArray.length;i++)
			System.out.print(myArray[i]+ " ");
	}
}
