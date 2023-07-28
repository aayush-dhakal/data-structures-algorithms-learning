public class NthNodeFromLast {
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

  // let nth position from end of node is 2 then
  // for 6 --> 7 --> 8 --> null: middle node is 7
  // for 6 --> 7 --> 8 --> 9 --> null: middle node is 8
  // for 6 --> 7 --> null: middle node is 6
  public ListNode findNthNodeFromEnd(int n) {
    ListNode mainPointer = head;
    ListNode referencePointer = head;
    int count = 0;

    while (count < n) {
      referencePointer = referencePointer.next;
      count++;
    }

    while (referencePointer != null) {
      referencePointer = referencePointer.next;
      mainPointer = mainPointer.next;
    }

    return mainPointer;
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

  public static void main(String[] args) {
    NthNodeFromLast sll = new NthNodeFromLast();
    sll.insertEnd(6);
    sll.insertEnd(7);
    sll.insertEnd(8);
    sll.insertEnd(9);

    sll.display();
    System.out.println("middle node is: " + sll.findNthNodeFromEnd(2).data);
  }
}
