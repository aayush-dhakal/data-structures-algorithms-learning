public class MergeTwoSortedLinkedList {
  private ListNode head; // we needed head in display method. We are assigning its value in main method.

  public static class ListNode {
    private int data; // Generic type
    private ListNode next; // since next will store the reference to second node(not actual value) so the
                           // type will be ListNode itself and not the int

    // since we used priavte type to our variables we have to create a setter to
    // assign value to instance variables
    public ListNode(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public void insertEnd(int value) {
    // System.out.println("head initial value is " + head);

    ListNode newNode = new ListNode(value);
    // As the value of head is null initially we will assign a newNode to the head
    // at first
    if (head == null) {
      head = newNode;
      return;
    }

    ListNode current = head; // temp variable to traverse to last node
    while (current.next != null) { // current.next will be null for last node
      current = current.next; // move the current pointer to last node
    }
    current.next = newNode; // assign the new node to last node

  }

  public void display() {
    ListNode current = head;
    int length = 0;
    while (current != null) {
      System.out.print(current.data + " --> ");
      current = current.next;
      length++;
    }
    System.out.println("null");
    System.out.println("length is " + length);
  }

  public int length() {
    if (head == null) {
      return 0;
    }

    int count = 0;
    ListNode current = head;

    while (current != null) {
      count++;
      current = current.next;
    }
    return count;
  }

  public static ListNode merge(ListNode a, ListNode b) {
    ListNode dummy = new ListNode(0); // this will help to return the head of merge listnode
    ListNode tail = dummy; // we use this to point to next node

    while (a != null && b != null) {
      if (a.data <= b.data) {
        tail.next = a; // moving tail to small value node
        a = a.next;
      } else {
        tail.next = b; // moving tail to small value node
        b = b.next;
      }
      tail = tail.next; // moving the tail to last merged node
    }

    if (a == null) {
      // if a doesn't have any node left then we will merge the rest of the nodes from
      // b to tail
      tail.next = b;
    } else {
      tail.next = a;
    }

    return dummy.next; // we are returning the head of newly merged node
  }

  // without creating dummy node
  public static ListNode merge2(ListNode a, ListNode b) {
    // we asign head to node with smallest data
    ListNode head = null;
    if (a.data <= b.data) {
      head = a;
      a = a.next;
    } else {
      head = b;
      b = b.next;
    }

    ListNode tail = head; // we use this to point to next node

    while (a != null && b != null) {
      if (a.data <= b.data) {
        tail.next = a; // moving tail to small value node
        a = a.next;
      } else {
        tail.next = b; // moving tail to small value node
        b = b.next;
      }
      tail = tail.next; // moving the tail to last merged node
    }

    if (a == null) {
      // if a doesn't have any node left then we will merge the rest of the nodes from
      // b to tail
      tail.next = b;
    } else {
      tail.next = a;
    }

    return head;
  }

  public static void main(String[] args) {
    MergeTwoSortedLinkedList sll = new MergeTwoSortedLinkedList();
    sll.insertEnd(6);
    sll.insertEnd(8);
    sll.insertEnd(8);
    sll.insertEnd(10);

    MergeTwoSortedLinkedList sll2 = new MergeTwoSortedLinkedList();
    sll2.insertEnd(6);
    sll2.insertEnd(7);
    sll2.insertEnd(9);
    sll2.insertEnd(10);
    sll2.insertEnd(11);
    sll2.insertEnd(12);
    sll2.insertEnd(13);

    sll.display();
    sll2.display();

    MergeTwoSortedLinkedList result = new MergeTwoSortedLinkedList();
    result.head = merge(sll.head, sll2.head);
    // result.head = merge2(sll.head, sll2.head);
    System.out.println("After merge:");
    result.display();
  }
}
