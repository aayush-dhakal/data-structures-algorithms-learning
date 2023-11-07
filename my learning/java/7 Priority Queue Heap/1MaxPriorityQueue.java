// A Max Heap is a complete binary tree in which each node value is >= than the values of its children
class MaxPriorityQueue {
  Integer[] heap;
  int n; // n represents the number of elements in the heap array. Basically size of heap

  public MaxPriorityQueue(int capacity) {
    heap = new Integer[capacity + 1]; // index 0 of heap will be kept as empty so we are taking heap size one
                                      // more as capacity + 1
    n = 0; // initally there will be no elementws in the heap array so n will be 0
  }

  public boolean isEmpty() {
    return n == 0;
  }

  public int size() {
    return n;
  }

  public void insert(int x) {
    if (n == heap.length - 1) { // if heap size is full and we are still trying to insert the new value then we
                                // first double the capacity of the heap
      resize(2 * heap.length);
    }
    n++; // signifies we are inerting the new value so the size of the element inserted
         // in heap will be increased first
    heap[n] = x;
    swim(n); // this swin also known as Bottom-up Reheapify makes the max heap property
             // persistent by
             // swapping the value of heap making sure that the parent node is always greater
             // than the child node
  }

  public void resize(int capacity) {
    Integer[] temp = new Integer[capacity];
    for (int i = 0; i < heap.length; i++) {
      temp[i] = heap[i]; // copying value from old heap
    }
    heap = temp; // assigning old heap to newly formed heap with double the capacity
  }

  public void swim(int k) {
    // when there is only one element then k will be 1 so no need to check anything
    // remember 5/2 returns the floor value ie 2 ansd we know that to find the
    // parent of n and n+1 child we use n/2
    while (k > 1 && heap[k / 2] < heap[k]) {
      int temp = heap[k];
      heap[k] = heap[k / 2]; // k/2 denoted the parent node
      heap[k / 2] = temp;
      k = k / 2; // again assigning k to its parent node coz we need to verify the max property
                 // to every upper parent node
    }
  }

  public void printMaxHeap() {
    for (int i = 1; i <= n; i++) { // since first elememt of heap is empty so starting from the 1 index
      System.out.print(heap[i] + " ");
    }
  }

  public static void main(String[] args) {
    MaxPriorityQueue pq = new MaxPriorityQueue(3);

    pq.insert(4);
    pq.insert(5);
    pq.insert(2);
    pq.insert(6);
    pq.insert(1);
    pq.insert(3);

    System.out.println(pq.size());
    pq.printMaxHeap();
  }
}