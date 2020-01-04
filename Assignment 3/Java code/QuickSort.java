
// Program to sort a list of integers using Quick Sort Technique

public class QuickSort 
{
	private int array[];
	private int length,m;
	private static int[] input = {4,6,2,8,3,1,10,12};
	
	public void sort(int[] inputArr) 
	{
		if (inputArr == null || inputArr.length == 0) 
		{
			return;
		}
		this.array = inputArr;
		length = inputArr.length;
		quickSort(0, length - 1);
		
	}

	// Function to perform Quick Sort
	
	/*
	 * Quick Sort applies a Divide and Conquer Algorithm
	 * It divides array into two sub arrays and recursively sorts them.
	 */
	
	private void quickSort(int lowerIndex, int higherIndex) 
	{
	
		 int i = lowerIndex;
		 int j = higherIndex;
		 // calculate pivot number, i.e. middle index number
		 int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
		 // Divide into two arrays
			while (i <= j) 
			{
				/*
	             In each iteration, we will identify a number from left side which 
	             is greater then the pivot value, and also we will identify a number 
	             from right side which is less then the pivot value. Once the search 
	             is done, then we exchange both numbers.
	             */
				while (array[i] < pivot) 
				{
					i++;
				}
				while (array[j] > pivot) {
					j--;
				}
				if (i <= j) {
					exchangeNumbers(i, j);
					//move index to next position on both sides
					i++;
					j--;
				}
			}
			m++;
			System.out.print("\nThe Array after Iteration "+ m +" is : ");
			for(int k:input)
			{
				System.out.print(k);
				System.out.print(" ");
			}	
//			System.out.println();
			if (lowerIndex < j)
				quickSort(lowerIndex, j);
			if (i < higherIndex)
				quickSort(i, higherIndex);
	}
	 
	private void exchangeNumbers(int i, int j)
	{
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
 
	// Main Method
	public static void main(String[] args)
	{
		System.out.print("\nThe Array before Sorting is : ");
		for(int i:input)
		{
			System.out.print(i);
			System.out.print(" ");
		}	
		System.out.println();
  		QuickSort quick = new QuickSort();
		quick.sort(input);
		System.out.print("\n\nThe Array after applying QuickSort is : ");
		for(int i:input)
		{
			System.out.print(i);
			System.out.print(" ");
		}	
	}

}