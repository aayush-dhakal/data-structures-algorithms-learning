class DoublyLinkedList {

  private ListNode head;
  private ListNode tail;
  private int length;

  private class ListNode {
    private int data;
    private ListNode next;
    private ListNode previous;

    public ListNode(int data) {
      this.data = data; // only data is assigned value, so by default next and previous will be null for
                        // a newly created node
    }
  }

  // constructor for DoublyLinkedList class. This will run whenever we create
  // an instance of this class
  public DoublyLinkedList() {
    this.head = null;
    this.tail = null;
    this.length = 0;
  }

  public boolean isEmpty() {
    return length == 0;
  }

  public int length() {
    return length;
  }

  public void insertFirst(int value) {
    ListNode newNode = new ListNode(value); // creates a new node with data as value and next and previous as null

    if (isEmpty()) {
      tail = newNode;
    } else {
      head.previous = newNode;
      newNode.next = head;
    }

    head = newNode;
    length++;
  }

  public void displayForward() {
    if (head == null) {
      System.out.println("List is empty");
      return;
    }

    ListNode temp = head;

    System.out.println("Display Forward");

    while (temp != null) {
      System.out.print(temp.data + "-->");
      temp = temp.next;
    }
    System.out.println("null");
  }

  public void displayBackward() {
    if (tail == null) {
      System.out.println("List is empty");
      return;
    }

    ListNode temp = tail;

    System.out.println("Display backward");

    while (temp != null) {
      System.out.print(temp.data + "-->");
      temp = temp.previous;
    }
    System.out.println("null");
  }

  public static void main(String[] args) {
    DoublyLinkedList dll = new DoublyLinkedList();
    dll.insertFirst(1);
    dll.insertFirst(13);
    dll.insertFirst(17);
    dll.insertFirst(31);

    dll.displayForward();
    dll.displayBackward();
  }
}