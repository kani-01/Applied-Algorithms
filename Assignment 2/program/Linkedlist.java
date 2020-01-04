// Linked list program
class Linkedlist 
{ 
    Node head;

    private static class Node 
    {
		private int data;
		private Node next;
 
		Node(int value)
		{
			this.data = value;
			next = null;
		}
	}

    public void printMiddle() 
    { 
        Node slow_ptr = head; 
        Node fast_ptr = head; 
        if (head != null) 
        { 
            while (fast_ptr != null && fast_ptr.next != null) 
            { 
                fast_ptr = fast_ptr.next.next; 
                slow_ptr = slow_ptr.next; 
            } 
            System.out.println("The middle element is " + slow_ptr.data + " \n"); 
        } 
    } 

    public void push(Node node) 
    {
		if (head == null) 
		{
			head = node;
		} 
		else 
		{
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;
			temp.next = node;
		}
	}
  
    public void printList() 
    { 
        Node tnode = head; 
        while (tnode != null) 
        { 
            System.out.print(tnode.data+" "); 
            tnode = tnode.next; 
        } 
        System.out.println(); 
    } 
  
    public static void main(String [] args) 
    { 
        Linkedlist llist = new Linkedlist();
        Linkedlist llist2 = new Linkedlist();
        int[] arr = {5,1,7,2,9,3};
        int[] arr2 = {6,4,8,1,9};
        for (int i=0; i<arr.length; i++) 
        { 
            llist.push(new Node(arr[i])); 
        }
        System.out.print("The EVEN Linked List is : ");
        llist.printList(); 
        llist.printMiddle(); 
        for (int i=0; i<arr2.length; i++) 
        { 
            llist2.push(new Node(arr2[i])); 
        }
        System.out.print("The ODD Linked List is : ");
        llist2.printList(); 
        llist2.printMiddle(); 
    } 
}
