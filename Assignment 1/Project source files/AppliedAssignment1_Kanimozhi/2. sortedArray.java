
public class sortedArray {
	
	static int[] array1 = {2,3,5,8,10,15,21,25,29,34};
	static int element;
	
	public static void findelement(int ele)
	{
		element=ele;
		for(int i=0;i<array1.length;i++)
		{
			if (element==array1[i])
			{
			System.out.println("Element "+element+" is found at "+i+ "th positon ");
			break;
			}
			else
			{
				if(array1[i]>=element)
				{
					System.out.println("Element "+ element +" has to be inserted at position " +i);
					break;
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		int x = 21;
		findelement(x);
		
	}

}
