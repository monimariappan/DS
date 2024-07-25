import java.util.Scanner; 

// SEPERATE FILES  FOR CLASSES PROVIDES BETTER MODULARITY

public class Node {
    int data ;   
    Node next;  

    // Constructor to create a new node with given data
    public Node(int data) {
        this.data = data;
        this.next = null; 
    }
}
public class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    
    public void insert(int data) {
    	  Node node = new Node(data);
    	  if (head == null ) {
    		  head = node;
    	  }
    	  else {
    		  Node current = head;
    		  while (current.next != null) {
    			  current = current.next;
    		  }
    		  current.next = node;
    	  }
    	  System.out.println("Inserted at end successfully.");
    }

    
    public void insertAt(int index, int data) {
    	Node node = new Node(data);
    	if ( index == 0) {
    		node.next = head; 
    		head = node;
    	}
    	else {
    		Node current = head;
    		for (int i = 0;i<index-1;i++) {
    			current = current.next;
    		}
    		node.next = current.next;
    		current.next = node;
    		System.out.println("Inserted at position " + index + " successfully.");		
    	}
    	
    }

    // Method to insert a node at the start
    public void insertAtStart(int data) {
    	 Node newNode = new Node(data); 
         newNode.next = head; 
         head = newNode; 
         System.out.println("Inserted at start successfully.");
    }

    // Method to delete a node
    public void delete(int index) {
    	 if (head == null) {
             return; // If the list is empty, there's nothing to delete
         }

         if (index == 0) {
             head = head.next; // If deleting the head, update the head to the next node
         } 
         else {
        	 Node current = head;
     		for (int i = 0;i<index-1;i++) {
     			current = current.next;
     		}
     		current.next = current.next.next;
         }
         System.out.println("Deleted at position " + index + " successfully.");
    }

    // Method to display the linked list
    public void show() {
    	System.out.println("The linked list is:");
    	 Node current = head; // Start from the head
         while (current != null) {
             System.out.print(current.data + " "); // Print the data in each node
             current = current.next; // Move to the next node
         }
         
    }
}
public class LinkedListImplementaion {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        int choice, data, index;

        do {
            System.out.println("\nLinked List Operations Menu:");
            System.out.println("1. Insert at end");
            System.out.println("2. Insert at start");
            System.out.println("3. Insert at position");
            System.out.println("4. Delete at position");
            System.out.println("5. Show list");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert at end: ");
                    data = scanner.nextInt();
                    list.insert(data);
                     break;

                case 2:
                    System.out.print("Enter data to insert at start: ");
                    data = scanner.nextInt();
                    list.insertAtStart(data);
                    break;

                case 3:
                    System.out.print("Enter position to insert: ");
                    index = scanner.nextInt();
                    System.out.print("Enter data to insert at position: ");
                    data = scanner.nextInt();
                    list.insertAt(index, data);
                    break;

                case 4:
                    System.out.print("Enter position to delete: ");
                    index = scanner.nextInt();
                    list.delete(index);                    
                    break;

                case 5:
                    list.show();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
