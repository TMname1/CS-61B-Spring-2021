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
    int idx = size;
    // 缩小
    if (size * 4 < arr.length && arr.length > initLen) {
      temp = (T[]) new Object[arr.length / 2];
      flag = true;
      // 还原原本大小
      idx++;
    }
    // 扩大
    if (size > arr.length) {
      temp = (T[]) new Object[arr.length * 2];
      flag = true;
      // 还原原本大小
      idx--;
    }
    if (flag == false) {
      return;
    }

    for (int i = 0; i < idx; i++) {
      nextFirst = move(nextFirst, true);
      temp[i + 1] = arr[nextFirst];
    }
    arr = temp;
    nextFirst = 0;
    nextLast = idx + 1;
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
    int left = nextFirst;
    for (int i = 0; i < size; i++) {
      left = move(left, true);
      System.out.println(arr[left]);
    }
    System.out.println('\n');
  }

  public T get(int index) {
    int p = move(nextFirst, false);
    for (int i = 0; i < index; i++) {
      p = move(p, false);
    }
    return arr[p];
  }

  // public Iterator<T> iterator() {

  // }

  // public boolean equals(Object o) {

  // }
}
