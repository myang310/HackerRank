public class Cache {
  private int capacity;
  private HashMap<Integer, Node> map;
  Node head;
  Node end;

  public Cache(int capacity) {
    map = new HashMap<Integer, Node>();
    this.capacity = capacity;
    head = end = null;
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      Node node = map.get(key);
      remove(node);
      setHead(node);
      return node.value;
    }

    return -1;
  }

  public void set(int key, int value) {
    if (head == null) {
      head = tail = new Node(key, value);
      map.put(key, head);
    }else {

    }
  }

  private void remove(Node n) {

  }

  private void setHead(Node n) {

  }

  private static class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
      prev = next = null;
    }
  }
}
