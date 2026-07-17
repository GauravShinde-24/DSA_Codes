// This algorithm uses two pointers: a slow pointer and a fast pointer. The slow pointer moves one step at a time, while the fast pointer moves two steps at a time.
// If there is a loop in the linked list, the two pointers will eventually meet at some point. If there is no loop, the fast pointer will reach the end of the list.
// The method should follow these guidelines:

// 1. Create two pointers, slow and fast, both initially pointing to the head of the linked list.
// 2. Traverse the list with the slow pointer moving one step at a time, while the fast pointer moves two steps at a time.
// 3. If there is a loop in the list, the fast pointer will eventually meet the slow pointer. If this occurs, the method should return true.
// 4. If the fast pointer reaches the end of the list or encounters a null value, it means there is no loop in the list. In this case, the method should return false.

// Output:
// Return true if the linked list has a loop.
// Return false if the linked list does not have a loop.

// Constraints:
// You are not allowed to use any additional data structures (such as arrays) or modify the existing data structure.
// You can only traverse the linked list once.


public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.value);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
    
    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

	
	public boolean hasLoop(){
	    
	    Node fast = head;
	    Node slow = head;
	    boolean ans = false;
	    
	    while(fast != null && fast.next != null){
	        
	        slow = slow.next;
	        fast = fast.next.next;
	        
	        if(fast == slow){
	            ans = true;
	            return ans;
	        }
	        
	    }
	    
	    return ans;
	    
	    
	    
	}

}


public class Main {

    public static void main(String[] args) {

        // Test 1: Empty list
        System.out.println("Test 1: Empty List");
        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.makeEmpty();  // Make list empty
        System.out.println("Expected: false");
        System.out.println("Actual: " + myLinkedList.hasLoop());
        System.out.println();

        // Test 2: One node, no loop
        System.out.println("Test 2: One Node (No Loop)");
        myLinkedList = new LinkedList(1);
        System.out.println("Expected: false");
        System.out.println("Actual: " + myLinkedList.hasLoop());
        System.out.println();

        // Test 3: One node, with loop to itself
        System.out.println("Test 3: One Node (Loop to Itself)");
        myLinkedList = new LinkedList(1);
        myLinkedList.getHead().next = myLinkedList.getHead();  // Create loop
        System.out.println("Expected: true");
        System.out.println("Actual: " + myLinkedList.hasLoop());
        System.out.println();

        // Test 4: Multi-node, no loop
        System.out.println("Test 4: Multi-Node (No Loop)");
        myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        System.out.println("1 -> 2 -> 3 -> 4");
        System.out.println("Expected: false");
        System.out.println("Actual: " + myLinkedList.hasLoop());
        System.out.println();

        // Test 5: Multi-node, loop back to head
        System.out.println("Test 5: Multi-Node (Loop to Head)");
        myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.getTail().next = myLinkedList.getHead();  // Loop to head
        System.out.println("1 -> 2 -> 3 -> 4 -> (loops back to 1)");
        System.out.println("Expected: true");
        System.out.println("Actual: " + myLinkedList.hasLoop());
        System.out.println();

        // Test 6: Multi-node, loop in the middle
        System.out.println("Test 6: Multi-Node (Loop to Middle Node)");
        myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        LinkedList.Node middle = myLinkedList.getHead().next.next;  // Node 3
        myLinkedList.getTail().next = middle;  // Tail loops to 3
        System.out.println("1 -> 2 -> 3 -> 4 -> (loops back to 3)");
        System.out.println("Expected: true");
        System.out.println("Actual: " + myLinkedList.hasLoop());
        System.out.println();

        /*
            EXPECTED OUTPUT:
            ----------------
            Test 1: Empty List
            Expected: false
            Actual: false

            Test 2: One Node (No Loop)
            Expected: false
            Actual: false

            Test 3: One Node (Loop to Itself)
            Expected: true
            Actual: true

            Test 4: Multi-Node (No Loop)
            1 -> 2 -> 3 -> 4
            Expected: false
            Actual: false

            Test 5: Multi-Node (Loop to Head)
            1 -> 2 -> 3 -> 4 -> (loops back to 1)
            Expected: true
            Actual: true

            Test 6: Multi-Node (Loop to Middle Node)
            1 -> 2 -> 3 -> 4 -> (loops back to 3)
            Expected: true
            Actual: true
        */
        
    }
    
}
