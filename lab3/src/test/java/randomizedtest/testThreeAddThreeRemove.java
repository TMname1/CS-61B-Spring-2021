package randomizedtest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.princeton.cs.introcs.StdRandom;

public class testThreeAddThreeRemove {

  @Test
  public void addAndRemoveTest() {
    AListNoResizing<Integer> a1 = new AListNoResizing<>();
    BuggyAList<Integer> a2 = new BuggyAList<>();
    a1.addLast(4);
    a1.addLast(5);
    a1.addLast(6);
    a2.addLast(4);
    a2.addLast(5);
    a2.addLast(6);

    for (int i = 0; i < 3; i++) {
      a1.removeLast();
      a2.removeLast();
      equal(a1, a2);
    }
  }

  public void equal(AListNoResizing<Integer> a1, BuggyAList<Integer> a2) {
    assertEquals(a1.size(), a2.size());
    for (int i = 0; i < a1.size(); i++) {
      assertEquals(a1.get(i), a2.get(i));
    }
  }

}
