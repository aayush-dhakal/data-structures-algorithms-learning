/*
**
** Given two non-empty linked lists representing two non-negative integers.
** The digits are stored in reverse order, and each of their nodes contains a single digit.
** Add the two numbers and return the sum as a linked list.
**
** Note: Two numbers do not contain any leading zero, except the number 0 itself.
**
** e.g Input: list1 = 2->4->7
**            list2 = 3->9->4->9
** calculation: 742+9493=>10235
** Output: 5->3->2->0->1
**
** For video explanation, please refer to my Youtube channel in the link below:
** Channel: youtube.com/fitcoder
** Linked List Playlist: https://youtube.com/playlist?list=PLFj4kIJmwGu1oI1HVzAZlpJgKf9xv6mM1
**
** Please subscribe to the channel if you find this helpful
*/

public class AddTwoListNumbers {

  static class ListNode {
    int val;
    ListNode next;

    ListNode(int v) {
      val = v;
      next = null;
    }
  }

  static ListNode insertAtBeginning(ListNode head, int data) {
    ListNode newNode = new ListNode(data);
    newNode.next = head;
    return newNode;
  }

  static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
    ListNode dummy = new ListNode(-1);
    ListNode prevNode = dummy;
    int sum = 0, carry = 0;
    while (head1 != null || head2 != null) {
      int digit1 = 0, digit2 = 0;
      if (head1 != null) {
        digit1 = head1.val;
        head1 = head1.next;
      }
      if (head2 != null) {
        digit2 = head2.val;
        head2 = head2.next;
      }
      sum = digit1 + digit2 + carry;
      carry = sum / 10;
      prevNode.next = new ListNode(sum % 10);
      prevNode = prevNode.next;
    }
    if (carry != 0) {
      prevNode.next = new ListNode(carry);
    }
    return dummy.next;
  }

  static void printList(ListNode head) {
    while (head != null) {
      System.out.print(head.val);
      if (head.next != null) {
        System.out.print("->");
      }
      head = head.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    ListNode head1 = null, head2 = null;
    head1 = insertAtBeginning(head1, 7); // 7
    head1 = insertAtBeginning(head1, 4); // 4->7
    head1 = insertAtBeginning(head1, 2); // 2->4->7

    head2 = insertAtBeginning(head2, 9); // 9
    head2 = insertAtBeginning(head2, 4); // 4->9
    head2 = insertAtBeginning(head2, 9); // 9->4->9
    head2 = insertAtBeginning(head2, 3); // 3->9->4->9

    System.out.print("Number 1: ");
    printList(head1);
    System.out.print("Number 2: ");
    printList(head2);

    System.out.print("Number after addition:"); // 742+9493=10235
    ListNode res = addTwoNumbers(head1, head2); // 5->3->2->0->1
    printList(res);
  }
}

// without using static class
/*
 * public class AddTwoListNumbers {
 * 
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int v) {
 * val = v;
 * next = null;
 * }
 * }
 * 
 * ListNode insertAtBeginning(ListNode head, int data) {
 * ListNode newNode = new ListNode(data);
 * newNode.next = head;
 * return newNode;
 * }
 * 
 * ListNode addTwoNumbers(ListNode head1, ListNode head2) {
 * ListNode dummy = new ListNode(-1);
 * ListNode prevNode = dummy;
 * int sum = 0, carry = 0;
 * while (head1 != null || head2 != null) {
 * int digit1 = 0, digit2 = 0;
 * if (head1 != null) {
 * digit1 = head1.val;
 * head1 = head1.next;
 * }
 * if (head2 != null) {
 * digit2 = head2.val;
 * head2 = head2.next;
 * }
 * sum = digit1 + digit2 + carry;
 * carry = sum / 10;
 * prevNode.next = new ListNode(sum % 10);
 * prevNode = prevNode.next;
 * }
 * if (carry != 0) {
 * prevNode.next = new ListNode(carry);
 * }
 * return dummy.next;
 * }
 * 
 * void printList(ListNode head) {
 * while (head != null) {
 * System.out.print(" " + head.val);
 * head = head.next;
 * }
 * System.out.println();
 * }
 * 
 * public static void main(String[] args) {
 * AddTwoListNumbers obj = new AddTwoListNumbers();
 * AddTwoListNumbers.ListNode head1 = obj.new ListNode(0);
 * AddTwoListNumbers.ListNode head2 = obj.new ListNode(0);
 * 
 * // ... (rest of the main method remains unchanged)
 * }
 * }
 */