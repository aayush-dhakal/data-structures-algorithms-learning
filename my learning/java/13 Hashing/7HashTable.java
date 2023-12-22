class HashTable {

  private HashNode[] buckets; // these are nodes of each array containing key and value
  private int numOfBuckets; // capacity ie number of array nodes
  private int size; // number of key value pairs in hash table or number of hash nodes in a
                    // HashTable

  public HashTable() {
    this(10); // default capacity
  }

  public HashTable(int capacity) {
    this.numOfBuckets = capacity;
    this.buckets = new HashNode[numOfBuckets];
    this.size = 0;
  }

  private class HashNode {
    private Integer key; // Can be generic type
    private String value; // Can be generic type
    private HashNode next; // reference to next HashNode

    public HashNode(Integer key, String value) {
      this.key = key;
      this.value = value;
    }
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void put(Integer key, String value) {
    if (key == null || value == null) {
      throw new IllegalArgumentException("Key or Value is null !!!");
    }

    int bucketIndex = getBucketIndex(key);
    HashNode head = buckets[bucketIndex];

    while (head != null) {
      if (head.key.equals(key)) { // if the key is already present then we will simply update the value
        head.value = value;
        return;
      }
      head = head.next;
    }

    size++;
    head = buckets[bucketIndex]; // bringing the head to the first index if it is being travered inside while
                                 // loop above
    HashNode node = new HashNode(key, value); // (key, value) -> null
    node.next = head; // we will be putting new collision key at the beginning of the head so we need
                      // this
    buckets[bucketIndex] = node;
  }

  private int getBucketIndex(Integer key) {
    return key % numOfBuckets; // or use buckets.length instead of numOfBuckets
  }

  public String get(Integer key) {
    if (key == null) {
      throw new IllegalArgumentException("Key is null !!!");
    }

    int bucketIndex = getBucketIndex(key);
    HashNode head = buckets[bucketIndex];

    while (head != null) {
      if (head.key.equals(key)) {
        return head.value;
      }
      head = head.next;
    }

    return null;
  }

  public String remove(Integer key) {
    if (key == null) {
      throw new IllegalArgumentException("Key is null !!!");
    }

    int bucketIndex = getBucketIndex(key);
    HashNode head = buckets[bucketIndex]; // (21, "Tom") -> (31, "Harry") -> (41, "Sana") -> null
    HashNode previous = null; // keeping track of previous head. Initially setting it to null

    while (head != null) {
      if (head.key.equals(key)) {
        break;
      }
      previous = head; // when the key to remove is in between of the nodes then we keep track of the
                       // previos head
      head = head.next;
    }

    if (head == null) {
      return null; // when the key to be searched is not present then the head will point to null
                   // so we will simply return null
    }

    size--;

    if (previous != null) {
      previous.next = head.next; // when the key is in middle then previous is not null as it points to the
                                 // previous head so then we will come in this block
    } else {
      buckets[bucketIndex] = head.next; // when the key is in first node then we arrive in this block
    }

    return head.value;
  }

  public static void main(String[] args) {
    HashTable table = new HashTable(10);
    table.put(105, "Tom");
    table.put(21, "Harry");
    table.put(31, "Dinesh");
    table.put(7, "Ram");

    System.out.println(table.size());// 1 => (31, "Dinesh") -> (21, "Harry") -> null

    System.out.println("Value for key 21 is " + table.get(21)); // returns Harry
    System.out.println("Value for key 7 is " + table.get(7));
    System.out.println("Value for key 211 is " + table.get(45)); // will return null if the key is not present

    System.out.println(table.remove(7));
    // System.out.println(table.remove(31));

    System.out.println(table.size());
    System.out.println("Value for key 7 is " + table.get(7)); // returns Harry

  }

}