public class InsertNodeAtBeginning {
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

  public void insertFirst(int value) {
    // System.out.println("head initial value is " + head);

    ListNode newNode = new ListNode(value);
    newNode.next = head; // for first time this will be null. As the value of head is null initially
    head = newNode; // assigning value of head here. so now the head inside display() method will
                    // not be null
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
    InsertNodeAtBeginning sll = new InsertNodeAtBeginning();
    sll.insertFirst(6);
    sll.insertFirst(7);
    sll.insertFirst(8);

    sll.display();
    System.out.println("lenght from the method is: " + sll.length());
  }
}
