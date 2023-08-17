// if you wish to define ListNode class outside of main class then remove the private access modifiers. The default access modifier is called "default"
// class ListNode {
//   ListNode next;
//   int data;

//   public ListNode(int data) {
//     this.data = data;
//   }
// }

// if class definition starts with public then the class name should be same as file name
// public class CircularSinglyLinkedList {
class CircularSinglyLinkedList {
  private ListNode last; // defining variable
  private int length;

  private class ListNode {
    private ListNode next;
    private int data;

    public ListNode(int data) {
      this.data = data;
    }
  }

  public CircularSinglyLinkedList() {
    last = null;
    length = 0;
  }

  public int length() {
    return length;
  }

  public boolean isEmpty() {
    return length == 0;
  }

  public void createCircularLinkedList() {
    ListNode first = new ListNode(1);
    ListNode second = new ListNode(14);
    ListNode third = new ListNode(17);
    ListNode fourth = new ListNode(6);

    first.next = second;
    second.next = third;
    third.next = fourth;
    fourth.next = first;

    last = fourth; // assigning variable
  }

  public void display() {
    if (last == null) {
      return;
    }

    ListNode first = last.next;

    while (first != last) {
      System.out.print(first.data + " ");
      first = first.next;
    }
    System.out.println(first.data);
  }

  public void insertEnd(int data) {
    ListNode temp = new ListNode(data);

    if (last == null) {
      last = temp;
      last.next = last;
    } else {

      temp.next = last.next;
      last.next = temp;
      last = temp;
    }
    length++;
  }

  public void insertEnd2(int data) {
    ListNode temp = new ListNode(data);
    ListNode head = null;

    if (last == null) {
      last = temp;
      head = temp;
    } else {
      head = last.next;
      last.next = temp;
      temp.next = head;
      last = temp;
    }
    last.next = head;
    length++;
  }

  public static void main(String[] args) {
    CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
    // csll.createCircularLinkedList();

    csll.insertEnd(32);
    csll.insertEnd(4);
    csll.insertEnd(25);

    // csll.insertEnd2(2);
    // csll.insertEnd2(4);
    // csll.insertEnd2(25);

    csll.display();
  }
}