import java.util.NoSuchElementException;

// FIFO
// Remove from front and insert from rear
class Queue {

  private ListNode front;
  private ListNode rear;
  private int length;

  private class ListNode {
    private int data;
    private ListNode next;

    public ListNode(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public int length() {
    return length;
  }

  public boolean isEmpty() {
    return length == 0;
  }

  public void enqueue(int data) {
    ListNode temp = new ListNode(data);

    if (isEmpty()) {
      front = temp;
    } else {
      rear.next = temp;
    }
    rear = temp;
    length++;
  }

  public int dequeue() {

    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    int result = front.data;
    front = front.next;

    // if there is only one node then assign rear to null as well
    if (front == null) {
      rear = null;
    }
    length--;
    return result;
  }

  public void print() {
    if (isEmpty()) {
      System.out.println("Queue is empty");
      return;
    }

    ListNode current = front;
    while (current != null) {
      System.out.print(current.data + " --> ");
      current = current.next;
    }
    System.out.println("null");
  }

  public static void main(String[] args) {
    Queue queue = new Queue();
    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(1);
    queue.enqueue(9);

    queue.print();

    System.out.println("After Dequeue");
    queue.dequeue();
    queue.print();
  }
}