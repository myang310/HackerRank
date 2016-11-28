/*
You’re given the pointer to the head node of a doubly linked
list. Reverse the order of the nodes in the list. The head
node might be NULL to indicate that the list is empty.

Link: https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list
*/

/*
  Insert Node at the end of a linked list
  head pointer input could be NULL as well for empty list
  Node is defined as
  class Node {
     int data;
     Node next;
     Node prev;
  }
*/

Node Reverse(Node head) {
    Node root = head;
    Node next;
    while (head != null) {
        next = head.next;
        head.next = head.prev;
        head.prev = next;
        root = head;
        head = next;
    }
    return root;
}
