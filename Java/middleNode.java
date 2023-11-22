public class middleNode {
    LinkedList slowNode = linkedList;
    LinkedList fastNode = linkedList;
    while (fastNode != null && fastNode.next != null) {
      slowNode = slowNode.next;
      fastNode = fastNode.next.next;
    }
    return slowNode;
}

public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      thi  s.value = value;
      this.next = null;
    }
  }

import java.util.*;

class ProgramTest {
  @Test
  public void TestCase1() {
    Program.LinkedList linkedList = new Program.LinkedList(0);
    linkedList.next = new Program.LinkedList(1);
    Program.LinkedList expected = new Program.LinkedList(2);
    linkedList.next.next = expected;
    expected.next = new Program.LinkedList(3);
    var actual = new Program().middleNode(linkedList);
    Utils.assertTrue(expected.equals(actual));
  }
}
