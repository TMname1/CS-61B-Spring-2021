package deque;

public class ArrayDeque<T> {

  private T[] arr;
  private int size;

  public ArrayDeque() {
    arr = (T[]) new Object[8];
    size = 0;
  }

  public void addFirst(T value) {
    size++;
    resize();
    // 复制数组
    addFirst();
    arr[0] = value;
  }

  private void addFirst() {
    T[] temp = (T[]) new Object[arr.length];
    System.arraycopy(arr, 0, temp, 1, size);
    arr = temp;
  }

  public void addLast(T value) {
    size++;
    resize();
    arr[size] = value;
  }

  public void removeFirst() {
    remove(true);
  }

  public void removeLast() {
    remove(false);
  }

  private void remove(boolean flag) {
    size--;
    resize();
    T[] temp = (T[]) new Object[arr.length];
    if (flag) {
      // 删除第一个数
      System.arraycopy(arr, 1, temp, 0, size - 1);
    } else {
      // 删除最后一个数
      System.arraycopy(arr, 0, temp, 0, size - 1);
    }
    arr = temp;
  }

  // 保证至少有25%的使用率
  private void resize() {
    // 缩小
    if (arr.length > size * 4) {
      resize(true);
    }
    // 扩大
    if (arr.length < size) {
      resize(false);
    }
  }

  private void resize(boolean flag) {
    T[] temp;
    if (flag) {
      temp = (T[]) new Object[arr.length / 2];
    } else {
      temp = (T[]) new Object[arr.length * 2];
    }
    System.arraycopy(arr, 0, temp, 0, size);
    arr = temp;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    if (size == 0) {
      return true;
    } else {
      return false;
    }
  }

  public void printDeque() {
    for (int i = 0; i < size; i++) {
      System.out.println(arr[i]);
    }
    System.out.println('\n');
  }

  public T get(int index) {
    return arr[index];
  }

  // public Iterator<T> iterator() {

  // }

  // public boolean equals(Object o) {

  // }
}
