// Java program to reverse a linked list in groups of
// given size
class LinkedList
{
    Node head;  // head of list
    static int List_len = 0; //Length of list

    /* Linked list Node*/
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
 
    Node reverse(Node head, int k)
    {
       Node current = head;
       Node next = null;
       Node prev = null;
        
       if( LinkedList.List_len >= k ){
           int count = 0;
           while (count < k && current != null) 
           {
               next = current.next;
               current.next = prev;
               prev = current;
               current = next;
               count++;
           }
           LinkedList.List_len = LinkedList.List_len - k;
           if (next != null) 
               head.next = reverse(next, k);
	    } 
	else{
	    prev = head;
	}
       return prev;
    }                      
 
 
    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);
  
        /* 3. Make next of new Node as head */
        new_node.next = head;
  
        /* 4. Move the head to point to new Node */
        head = new_node;
	
	LinkedList.List_len = LinkedList.List_len + 1;
    }
 
    /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
 
     /* Drier program to test above functions */
    public static void main(String args[])
    {
        LinkedList llist = new LinkedList();
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->null */
        llist.push(8);
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);
         
        System.out.println("Given Linked List");
        llist.printList();
         
        llist.head = llist.reverse(llist.head, 3);
 
        System.out.println("Reversed list");
        llist.printList();
    }
} 
