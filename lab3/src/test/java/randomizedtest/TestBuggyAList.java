package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
  @Test
  public void randomizedTest() {
    AListNoResizing<Integer> L = new AListNoResizing<>();
    BuggyAList<Integer> bugL = new BuggyAList<>();

    int N = 5000;
    for (int i = 0; i < N; i += 1) {
      int operationNumber = StdRandom.uniform(0, 3);
      if (operationNumber == 0) {
        // addLast
        int randVal = StdRandom.uniform(0, 100);
        L.addLast(randVal);
        bugL.addLast(randVal);
      } else if (operationNumber == 1) {
        // size
        int size1 = L.size();
        int size2 = bugL.size();
        assertEquals(size1, size2);
      } else if (operationNumber == 2) {
        if (L.size() == 0) {
          continue;
        }
        int temp1 = L.getLast();
        int temp2 = bugL.getLast();
        L.removeLast();
        bugL.removeLast();
        assertEquals(temp1, temp2);
      }
    }
  }

}
