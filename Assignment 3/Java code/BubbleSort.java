
// Program to sort a list of integers using Bubble Sort Technique

public class BubbleSort 
{
	
	private static int[] myArray = {9,7,3,4,2,5,1}; 
	private static int temp;
	
// Function to perform Bubble Sort
	
	/*
	 * In Bubble sort, Largest element bubbles to top (last)
	 */

	public int[] bubbleSort(int[] myArray)
	{
		for(int i=myArray.length;i>1;i--)
		{
			for(int j=0;j<i-1;j++)
			{
				if(myArray[j+1]<myArray[j])
				{
					temp = myArray[j];
					myArray[j]=myArray[j+1];
					myArray[j+1]=temp;
				}
			}
			System.out.print("The Array after Iteration "+(myArray.length-i+1)+" is : ");
			for(int k=0;k<myArray.length;k++)
				System.out.print(myArray[k]+ " ");
			System.out.println();
		}
		return myArray;
	}
	
	//Main Method
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.print("\nThe Array Before Sorting is : ");
		for(int i=0;i<myArray.length;i++)
			System.out.print(myArray[i]+ " ");
		System.out.println("\n");
		BubbleSort bubble = new BubbleSort();
		myArray=bubble.bubbleSort(myArray);
		System.out.println();
		System.out.print("The Array After applying Bubble Sort is : ");
		for(int i=0;i<myArray.length;i++)
			System.out.print(myArray[i]+ " ");
	}
}
