import java.util.HashSet;

public class RemoveLoopInList {
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

  public boolean detectALoop() {

    ListNode fastPtr = head;
    ListNode slowPtr = head;

    while (fastPtr != null && fastPtr.next != null) {
      fastPtr = fastPtr.next.next;
      slowPtr = slowPtr.next;

      if (slowPtr == fastPtr) {
        return true;
      }
    }
    return false;
  }

  public ListNode startOfLoop() {

    ListNode fastPtr = head;
    ListNode slowPtr = head;

    while (fastPtr != null && fastPtr.next != null) {
      fastPtr = fastPtr.next.next;
      slowPtr = slowPtr.next;

      if (slowPtr == fastPtr) {
        return getLoopStartingNode(slowPtr);
      }
    }
    return null;
  }

  public ListNode getLoopStartingNode(ListNode slowPtr) {
    ListNode temp = head;
    while (slowPtr != temp) {
      temp = temp.next;
      slowPtr = slowPtr.next;

    }
    return temp;
  }

  public void removeLoop() {

    ListNode fastPtr = head;
    ListNode slowPtr = head;

    while (fastPtr != null && fastPtr.next != null) {
      fastPtr = fastPtr.next.next;
      slowPtr = slowPtr.next;

      // first find the node where the fast and slow pointer meets
      if (slowPtr == fastPtr) {
        removeLoop(slowPtr);
      }
    }
  }

  // this method has arguments so it is method overloading
  private void removeLoop(ListNode slowPtr) {
    ListNode temp = head;
    // this this condition is true then the node that they point will be the
    // starting point of loop so slowPtr.next will contain the end of the loop node
    // in this case
    while (slowPtr.next != temp.next) {
      temp = temp.next;
      slowPtr = slowPtr.next;

    }
    slowPtr.next = null;
  }

  public boolean detectALoop2() {
    ListNode current = head;

    HashSet<ListNode> s = new HashSet<ListNode>();

    while (current != null) {
      // If we have already has this node
      // in hashmap it means there is a cycle
      // (Because we are encountering the
      // node second time).
      if (s.contains(current)) {
        return true;
      }

      // If we are seeing the node for
      // the first time, insert it in hash
      s.add(current);

      current = current.next;

    }
    return false;
  }

  public ListNode getLoopStartingNode2() {
    ListNode current = head;

    HashSet<ListNode> s = new HashSet<ListNode>();

    while (current != null) {
      // If we have already has this node
      // in hashmap it means there is a cycle
      // (Because we are encountering the
      // node second time).
      if (s.contains(current)) {
        return current;
      }

      // If we are seeing the node for
      // the first time, insert it in hash
      s.add(current);

      current = current.next;
    }
    return null;
  }

  public void removeLoop2() {
    ListNode current = head;
    ListNode previous = null;

    HashSet<ListNode> s = new HashSet<ListNode>();

    while (current != null) {
      // If we have already has this node
      // in hashmap it means there is a cycle
      // (Because we are encountering the
      // node second time).
      if (s.contains(current)) {
        previous.next = null;
        return;
      }

      // If we are seeing the node for
      // the first time, insert it in hash
      s.add(current);

      previous = current;
      current = current.next;
    }
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

  public void createALoopInLinkedList() {
    ListNode first = new ListNode(1);
    ListNode second = new ListNode(2);
    ListNode third = new ListNode(3);
    ListNode fourth = new ListNode(4);
    ListNode fifth = new ListNode(5);
    ListNode sixth = new ListNode(6);

    head = first;
    first.next = second;
    second.next = third;
    third.next = fourth;
    fourth.next = fifth;
    fifth.next = sixth;
    // sixth.next = third; // creates a loop
    sixth.next = fourth; // creates a loop
    // sixth.next = null; // doesnot create a loop
  }

  public static void main(String[] args) {
    RemoveLoopInList sll = new RemoveLoopInList();

    sll.createALoopInLinkedList();

    // sll.display(); // this will create a infinite loop if there is a loop in
    // linked list

    System.out.println("Loop exists = " + sll.detectALoop());
    // System.out.println("Loop exists = " + sll.detectALoop2());

    System.out.println("Start of loop = " + sll.startOfLoop().data);
    // System.out.println("Start of loop = " + sll.getLoopStartingNode2().data);

    sll.removeLoop();
    // sll.removeLoop2();
    System.out.println("Loop exists = " + sll.detectALoop());
    sll.display();

  }
}
