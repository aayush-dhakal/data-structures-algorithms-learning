public class RemoveAGivenKeyNode {
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

  public void removeNodeWithKey(int value) {

    ListNode current = head;
    ListNode previous = null;

    // if key is a first node
    if (current.data == value) {
      head = current.next;
      current.next = null; // optional
      return;
    }

    // if value is in between node
    while (current.data != value) {
      previous = current;
      current = current.next;
    }

    previous.next = current.next;
    current.next = null; // optional
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
    RemoveAGivenKeyNode sll = new RemoveAGivenKeyNode();
    sll.insertEnd(6);
    sll.insertEnd(7);
    sll.insertEnd(8);
    sll.insertEnd(10);
    sll.insertEnd(9);

    sll.display();

    // sll.removeNodeWithKey(8);
    // sll.removeNodeWithKey(9);
    sll.removeNodeWithKey(6);
    sll.display();
  }
}
