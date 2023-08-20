import java.util.EmptyStackException;

class Stack {

  private int top;
  private int capacity;
  // private int[] arrayStack=new int[capacity];
  private int arrayStack[];

  public Stack() {
    top = -1;
    capacity = 3;
    arrayStack = new int[capacity];
  }

  public void push(int data) {
    if (top + 1 == capacity) {
      System.out.println("Stack is full");
      return;
    }
    top++;
    arrayStack[top] = data;
  }

  public int pop() {
    if (top == -1) {
      throw new EmptyStackException();
    }

    int result = arrayStack[top];
    top--;

    return result;
  }

  public int peek() {
    if (top == -1) {
      throw new EmptyStackException();
    }
    return arrayStack[top];
  }

  public static void main(String[] args) {
    Stack stack = new Stack();
    stack.push(10);
    stack.push(15);
    stack.push(20);
    stack.push(20);

    // stack.pop();

    System.out.println("top element is: " + stack.peek());
    System.out.println("removed element is: " + stack.pop());
    System.out.println("top element now is: " + stack.peek());
  }
}