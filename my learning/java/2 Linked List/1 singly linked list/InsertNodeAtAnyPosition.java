public class InsertNodeAtAnyPosition {
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

  // we assume that the list is not empty ie there will be atleast 2 nodes
  public void insertCertainPosition(int value, int position) {
    // System.out.println("head initial value is " + head);

    if (position > length()) {
      return; // return in void functions will break out of function
    }

    ListNode newNode = new ListNode(value); // generate new node which has data and next property

    if (position == 1) {
      newNode.next = head;
      head = newNode;
    } else {
      int length = 1;
      ListNode previous = head; // temp variable to traverse to certain position node(ie position-1) where we
                                // will add the new node
      while (length < position - 1) {
        previous = previous.next; // get the node of position-1
        length++;
      }
      ListNode current = previous.next; // currently pointing next value(ie before adding new node)
      newNode.next = current; // assigning the currently pointing next value to new node
      previous.next = newNode; // assign the new node to specified position
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

  public static void main(String[] args) {
    InsertNodeAtAnyPosition sll = new InsertNodeAtAnyPosition();
    sll.insertEnd(6);
    sll.insertEnd(7);
    sll.insertEnd(8);
    sll.insertEnd(9);

    sll.display();

    sll.insertCertainPosition(10, 1);

    sll.display();
    // System.out.println("lenght from the method is: " + sll.length());
  }
}
