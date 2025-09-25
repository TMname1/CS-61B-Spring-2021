package randomizedtest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.princeton.cs.algs4.StdRandom;

public class randomizedTest {

  public static void randomizedTest() {
    AListNoResizing<Integer> L = new AListNoResizing<>();

    int N = 500;
    for (int i = 0; i < N; i += 1) {
      int operationNumber = StdRandom.uniform(0, 2);
      if (operationNumber == 0) {
        // addLast
        int randVal = StdRandom.uniform(0, 100);
        L.addLast(randVal);
        System.out.println("addLast(" + randVal + ")");
      } else if (operationNumber == 1) {
        // size
        int size = L.size();
        System.out.println("size: " + size);
      }
    }
  }

  public static void main(String[] args) {
    randomizedTest();
  }
}
