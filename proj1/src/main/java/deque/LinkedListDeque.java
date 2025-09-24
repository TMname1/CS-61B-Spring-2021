package deque;

public class LinkedListDeque<Item> {

  private class Node {
    public Item value;
    public Node next;
    public Node prev;

    // 构造一个结点
    public Node(Node p, Node n, Item v) {
      next = n;
      prev = p;
      value = v;
    }
  }

  private Node sentinel;
  private int size;

  // 初始化哨兵结点，即创建空结点
  public LinkedListDeque(Item value) {
    sentinel = new Node(sentinel, sentinel, value);
    size = 0;
  }

  // 在sentinel后面添加一个结点
  public void addFirst(Item value) {
    if (sentinel.next == null) {
      sentinel.next = new Node(sentinel, sentinel, value);
    } else {
      sentinel.next = new Node(sentinel, sentinel.next, value);
    }
    size++;
  }

  public void addLast(Item value) {

  }

  public void removeFirst() {

  }

  public void removeLast() {

  }

  // 获得第index个元素
  public Item get(int index) {
    Node temp = sentinel;
    for (int i = 0; i < index; i++) {
      temp = temp.next;
    }
    return temp.value;
  }
}
