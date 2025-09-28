package deque;

public class ArrayDeque<T> {

  private T[] arr;
  private int size;
  private int nextFirst;
  private int nextLast;
  private int initLen = 8;

  public ArrayDeque() {
    arr = (T[]) new Object[initLen];
    size = 0;
    nextFirst = 0;
    nextLast = 1;
  }

  public void addFirst(T value) {
    size++;
    resize();
    arr[nextFirst] = value;
    nextFirst = move(nextFirst, false);
  }

  public void addLast(T value) {
    size++;
    resize();
    arr[nextLast] = value;
    nextLast = move(nextLast, true);
  }

  public T removeFirst() {
    if (isEmpty()) {
      return null;
    }
    size--;
    resize();
    nextFirst = move(nextFirst, true);
    return arr[nextFirst];
  }

  public T removeLast() {
    if (isEmpty()) {
      return null;
    }
    size--;
    resize();
    nextLast = move(nextLast, false);
    return arr[nextLast];
  }

  // 至少有25%的利用率
  private void resize() {
    T[] temp = null;
    boolean flag = false;
    // 缩小
    if (size * 4 < arr.length && arr.length > initLen) {
      temp = (T[]) new Object[arr.length / 2];
      flag = true;
    }
    // 扩大
    if (size > arr.length) {
      temp = (T[]) new Object[arr.length * 2];
      flag = true;
    }
    if (flag == false) {
      return;
    }
    int idx = 1;
    while (nextFirst != nextLast) {
      nextFirst = move(nextFirst, false);
      temp[idx] = arr[nextFirst];
      idx++;
    }
    arr = temp;
    nextFirst = 0;
    nextLast = idx;
  }

  private int move(int dir, boolean plus) {
    if (plus) {
      return plusMove(dir);
    } else {
      return negMove(dir);
    }
  }

  private int plusMove(int dir) {
    if (dir + 1 >= arr.length) {
      dir = 0;
    } else {
      dir++;
    }
    return dir;
  }

  private int negMove(int dir) {
    if (dir - 1 < 0) {
      dir = arr.length - 1;
    } else {
      dir--;
    }
    return dir;
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
    int left = nextFirst, right = nextLast;
    while (left != right) {
      left = move(left, false);
      System.out.println(arr[left]);
    }
    System.out.println('\n');
  }

  // public Iterator<T> iterator() {

  // }

  // public boolean equals(Object o) {

  // }
}
