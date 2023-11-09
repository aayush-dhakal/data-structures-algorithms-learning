// A Max Heap is a complete binary tree in which each node value is >= than the values of its children.
// A complete bianry tree is a binary tree where all levels are completely filled except last level and last level has nodes in such a way that left side is never empty.
class MaxPriorityQueue {
  Integer[] heap;
  int n; // n represents the number of elements in the heap array. Basically size of heap

  public MaxPriorityQueue(int capacity) {
    heap = new Integer[capacity + 1]; // index 0 of heap will be kept as empty(bacause it helps to identify
                                      // parent and child node with formula) so we are taking heap size one
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
    swim(n); // this swin also known as Bottom-up Reheapify(meaning take the bottom node and
             // put it in appropriate place ie at top making sure it is grater than its
             // child node)
             // makes the max heap property persistent by swapping the value of heap making
             // sure that the parent node is always greater than the child node
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
    // remember 5/2 returns the floor value ie 2 and we know that to find the
    // parent of kth index = k/2
    // example: parent of 7th index = 7/2 = 3
    // example: parent of 6th index = 6/2 = 3
    // children of kth index = 2*k, 2*k+1
    // eg: children of 1st index = 2,3
    while (k > 1 && heap[k / 2] < heap[k]) {
      int temp = heap[k];
      heap[k] = heap[k / 2]; // k/2 denoted the parent node
      heap[k / 2] = temp;
      k = k / 2; // again assigning k to its parent node coz we need to verify the max property
                 // to every upper parent node
    }
  }

  // for deleteing the max node ie the first node
  public int deleteMax() {
    int max = heap[1];

    swap(1, n); // we first swap the first node with the last node
    n--; // then srink the heap size to remove the swaped last node from heap

    sink(1); // this sink also known as Top-Down Reheapify(meaning take the top node and
             // put it in appropriate place ie at bottom making sure it is smaller than its
             // parent node)
             // makes the max heap property persistent by swapping the value of heap making
             // sure that the child node is always samller than the parent node

    heap[n + 1] = null; // making the last node where deleted element was stored null

    // when we keep putting null to the last deleted node then at certain point we
    // srink the heap size
    if (n > 0 && (n == heap.length - 1 / 4)) {
      resize(heap.length / 2);
    }

    return max;
  }

  public void swap(int a, int b) {
    int temp = heap[a];
    heap[a] = heap[b];
    heap[b] = temp;
  }

  private void sink(int k) {
    while (2 * k <= n) { // while there are children nodes for kth index
      int j = 2 * k; // pointing to child of k

      // j < n condition if true then it tells that there is right child too
      // heap[j] < heap[j + 1] tells that the right child is grater than left child so
      // we increment j so that we can compare with kth parent node to maximum child
      // node and swap them if necessary.
      // if left child is greater ie when heap[j] < heap[j + 1] is false then j will
      // point to left child and we will compare parent node to left child node(ie
      // greatest child node) and swap them if necessary
      if (j < n && heap[j] < heap[j + 1]) {
        j++;
      }
      // if parent node is greater then do nothing
      if (heap[k] >= heap[j]) {
        break;
      }
      // if child node is greater then swap it with parent node
      swap(k, j);
      // then at last point the node to comapare to remaining child node to continue
      // this process iteratively
      k = j;
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

    System.out.println();

    pq.deleteMax();
    System.out.println("After delete: ");
    pq.printMaxHeap();
  }
}