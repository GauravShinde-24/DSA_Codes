// Implement a method called findKthFromEnd that returns the k-th node from the end of a singly linked list.
// The linked list does not store its length, so you must determine the correct node without using a size property.

// The value of k is 1-based:
// 1. k = 1 returns the last node (tail).
// 2. k = 2 returns the second-to-last node.
// 3. k = list length returns the head node.
// 4. k <= 0 or k > list length returns null.

// You must solve this problem using the two-pointer technique, ensuring the solution runs in a single traversal of the list (O(n) time, O(1) space).

public class LinkedList {

    private Node head;
    private Node tail;

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
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
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
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }


    public Node findKthFromEnd(int k) {
        
        if(k <= 0){
            return null;
        }
        
        Node fast = head;
        Node slow = head;
        
        
        for(int i = 0; i<k; i++){
           
           if(fast == null){
                return null;
            }
            fast = fast.next;
            
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }

}

public class Main {
    public static void main(String[] args) {

        // Test 1: Empty list (k = 1)
        System.out.println("Test 1: Empty List (k = 1)");
        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.makeEmpty();
        LinkedList.Node result = myLinkedList.findKthFromEnd(1);
        System.out.println("Expected: null");
        System.out.println("Actual: " + (result == null ? "null" : result.value));
        System.out.println();

        // Test 2: One element, k = 1 (last node)
        System.out.println("Test 2: One Element (k = 1)");
        myLinkedList = new LinkedList(10);
        result = myLinkedList.findKthFromEnd(1);
        System.out.println("10");
        System.out.println("Expected: 10");
        System.out.println("Actual: " + (result == null ? "null" : result.value));
        System.out.println();

        // Test 3: One element, k = 2 (beyond end)
        System.out.println("Test 3: One Element (k = 2, Beyond End)");
        myLinkedList = new LinkedList(20);
        result = myLinkedList.findKthFromEnd(2);
        System.out.println("20");
        System.out.println("Expected: null");
        System.out.println("Actual: " + (result == null ? "null" : result.value));
        System.out.println();

        // Prepare a multi-node list
        myLinkedList = new LinkedList(1);
        for (int i = 2; i <= 6; i++) {
            myLinkedList.append(i);
        }
        // List: 1 -> 2 -> 3 -> 4 -> 5 -> 6

        // Test 4: k = 1 (last node)
        System.out.println("Test 4: Multi-Node (k = 1)");
        result = myLinkedList.findKthFromEnd(1);
        System.out.println("1 -> 2 -> 3 -> 4 -> 5 -> 6");
        System.out.println("Expected: 6");
        System.out.println("Actual: " + (result == null ? "null" : result.value));
        System.out.println();

        // Test 5: k = 2 (second-to-last node)
        System.out.println("Test 5: Multi-Node (k = 2)");
        result = myLinkedList.findKthFromEnd(2);
        System.out.println("1 -> 2 -> 3 -> 4 -> 5 -> 6");
        System.out.println("Expected: 5");
        System.out.println("Actual: " + (result == null ? "null" : result.value));
        System.out.println();

        // Test 6: k = 7 (k too large, length=6)
        System.out.println("Test 6: Multi-Node (k = 7, Too Large)");
        result = myLinkedList.findKthFromEnd(7);
        System.out.println("1 -> 2 -> 3 -> 4 -> 5 -> 6");
        System.out.println("Expected: null");
        System.out.println("Actual: " + (result == null ? "null" : result.value));
        System.out.println();

        // Test 7: k = 4 (middle node)
        System.out.println("Test 7: Multi-Node (k = 4)");
        result = myLinkedList.findKthFromEnd(4);
        System.out.println("1 -> 2 -> 3 -> 4 -> 5 -> 6");
        System.out.println("Expected: 3");
        System.out.println("Actual: " + (result == null ? "null" : result.value));
        System.out.println();

        /*
            EXPECTED OUTPUT:
            ----------------
            Test 1: Empty List (k = 1)
            Expected: null
            Actual: null

            Test 2: One Element (k = 1)
            10
            Expected: 10
            Actual: 10

            Test 3: One Element (k = 2, Beyond End)
            20
            Expected: null
            Actual: null

            Test 4: Multi-Node (k = 1)
            1 -> 2 -> 3 -> 4 -> 5 -> 6
            Expected: 6
            Actual: 6

            Test 5: Multi-Node (k = 2)
            1 -> 2 -> 3 -> 4 -> 5 -> 6
            Expected: 5
            Actual: 5

            Test 6: Multi-Node (k = 7, Too Large)
            1 -> 2 -> 3 -> 4 -> 5 -> 6
            Expected: null
            Actual: null

            Test 7: Multi-Node (k = 4)
            1 -> 2 -> 3 -> 4 -> 5 -> 6
            Expected: 3
            Actual: 3
        */
        
    }
    
}
