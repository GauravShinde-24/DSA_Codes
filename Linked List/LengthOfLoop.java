// Based on the provided Java code, here is the formal problem description:
// Find the Length of a Loop in a Linked List

// Problem Statement:
// Given the head of a singly linked list, determine whether the linked list contains a cycle (loop). If a cycle exists, find and return the number of nodes present within that cycle.

// If the linked list does not contain a cycle, or if the list is empty, return 0.
// A cycle occurs in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
    
// Expected Complexity:
// Time Complexity: $O(N)$, where $N$ is the number of nodes in the linked list. The Tortoise and Hare algorithm guarantees we traverse the list in linear time.
// Space Complexity: $O(1)$, as the solution only uses two pointers (slow and fast) regardless of the list size.

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class Solution {

    public int lengthOfLoop(Node head) {

        if (head == null) {
            return 0;
        }

        Node slow = head;
        Node fast = head;

        // Detect Loop using Floyd's Cycle Detection Algorithm
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            // Loop found
            if (slow == fast) {

                int count = 1;
                Node temp = slow.next;

                while (temp != slow) {
                    count++;
                    temp = temp.next;
                }

                return count;
            }
        }

        // No loop found
        return 0;
    }
}

public class Main {

    public static void main(String[] args) {

        // Create Nodes
        Node head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);
        Node fifth = new Node(50);

        // Connect Nodes
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        // Create Loop
        // 50 -> 30
        fifth.next = third;

        Solution obj = new Solution();

        int length = obj.lengthOfLoop(head);

        System.out.println("Length of Loop = " + length);
    }
}
