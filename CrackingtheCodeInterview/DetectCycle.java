/*
A linked list is said to contain a cycle if any node is visited
more than once while traversing the list.

Complete the function provided in the editor below. It has one
parameter: a pointer to a Node object named that points to the
head of a linked list. Your function must return a boolean
denoting whether or not there is a cycle in the list. If there
is a cycle, return true; otherwise, return false.

Note: If the list is empty,  will be null.

Link: https://www.hackerrank.com/challenges/ctci-linked-list-cycle
*/

/*
Detect a cycle in a linked list. Note that the head pointer may
be 'null' if the list is empty.

A Node is defined as:
    class Node {
        int data;
        Node next;
    }
*/

boolean hasCycle(Node head) {
    Node slow = head;
    Node fast = head;
    Node fast2;
    if (fast != null)
        fast2 = head.next;
    else
        return false;

    while (fast != null && fast2 != null) { // it has not yet hit the end of the linked list
        slow = slow.next;
        fast = fast2.next;
        if (fast != null)
            fast2 = fast.next;

        if (slow == fast || slow == fast2)
            return true;
    }
    return false;
}
