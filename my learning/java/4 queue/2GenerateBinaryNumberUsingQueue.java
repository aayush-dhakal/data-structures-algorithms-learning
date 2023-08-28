import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class QueueClass {
  static String[] generateBinaryNumbers(int n) {
    String[] result = new String[n];

    Queue<String> q = new LinkedList<>();
    q.offer("1"); // offer enqueues

    for (int i = 0; i < n; i++) {
      result[i] = q.poll(); // poll dequeues
      String n1 = result[i] + "0";
      String n2 = result[i] + "1";

      q.offer(n1);
      q.offer(n2);
    }

    return result;
  }

  public static void main(String[] args) {

    System.out.println("Binary number for " + 5 + " is " + Arrays.toString(generateBinaryNumbers(5)));

  }
}