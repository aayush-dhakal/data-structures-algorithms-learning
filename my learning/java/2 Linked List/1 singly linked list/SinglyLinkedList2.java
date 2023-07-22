
public class SinglyLinkedList2 {
  public static ListNode head;

  public static class ListNode {
    private int data; // Generic type
    private ListNode next;

    public ListNode(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public static void display() {
    ListNode current = head;
    while (current != null) {
      System.out.print(current.data + " --> ");
      current = current.next;
    }
    System.out.println("null");
  }

  public static void main(String[] args) {
    // SinglyLinkedList2 sll = new SinglyLinkedList2();
    head = new ListNode(10);
    ListNode second = new ListNode(1);
    ListNode third = new ListNode(8);
    ListNode fourth = new ListNode(11);

    // Now we will connect then together to form a chain
    head.next = second; // 10 --> 1
    second.next = third; // 10 --> 1 --> 8
    third.next = fourth; // 10 --> 1 --> 8 --> 11 --> null

    display();
  }
}
