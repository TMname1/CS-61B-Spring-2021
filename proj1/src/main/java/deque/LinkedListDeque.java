package deque;

import java.io.ObjectInput;

public class LinkedListDeque<T> {

  private class Node {
    public T value;
    public Node next;
    public Node prev;

    // 构造一个结点
    public Node(Node p, Node n, T v) {
      this.next = n;
      this.prev = p;
      this.value = v;
    }
  }

  private Node sentinel;
  private int size;

  // 初始化哨兵结点，即创建空结点
  public LinkedListDeque() {
    sentinel = new Node(null, null, null);
    sentinel.next = sentinel;
    sentinel.prev = sentinel;
    size = 0;
  }

  // 在sentinel后面添加一个结点
  public void addFirst(T value) {
    if (size == 0) {
      sentinel.next = new Node(sentinel, sentinel, value);
      sentinel.prev = sentinel.next;
    } else {
      sentinel.next = new Node(sentinel, sentinel.next, value);
      sentinel.next.next.prev = sentinel.next;
    }
    size++;
  }

  // 在sentinel"前面"添加一个结点
  public void addLast(T value) {
    if (size == 0) {
      sentinel.next = new Node(sentinel, sentinel, value);
      sentinel.prev = sentinel.next;
    } else {
      sentinel.prev = new Node(sentinel.prev, sentinel, value);
      sentinel.prev.prev.next = sentinel.prev;
    }
    size++;
  }

  public boolean isEmpty() {
    if (size == 0) {
      return true;
    } else {
      return false;
    }
  }

  public int size() {
    return size;
  }

  public void printDeque() {
    Node p = sentinel.next;
    while (p.value != null) {
      System.out.println(p.value + " ");
      p = p.next;
    }
    System.out.println('\n');
  }

  public T removeFirst() {
    Node p = sentinel.next;
    if (p.value == null) {
      return null;
    } else {
      sentinel.next = p.next;
      p.next.prev = sentinel;
    }
    size--;
    return p.value;
  }

  public T removeLast() {
    Node p = sentinel.prev;
    if (p.value == null) {
      return null;
    } else {
      sentinel.prev = p.prev;
      p.prev.next = sentinel;
    }
    size--;
    return p.value;
  }

  // 获得第index个元素
  public T get(int index) {
    if (index >= size || index < 0) {
      return null;
    }
    Node temp = sentinel;
    for (int i = 0; i < index; i++) {
      temp = temp.next;
    }
    return temp.value;
  }

  // 递归实现get
  public T getRecursive(int index) {
    if (index >= size || index < 0) {
      return null;
    }
    return getNextNodeValue(sentinel, index);
  }

  // 辅助递归get函数
  public T getNextNodeValue(Node n, int index) {
    if (index == 0) {
      return n.value;
    }
    return getNextNodeValue(n.next, index - 1);
  }

  // public Iterator<T> iterator(){

  // }

  // public boolean equals(Object o){
  // if(o instanceof LinkedListDeque){

  // }
  // }
}