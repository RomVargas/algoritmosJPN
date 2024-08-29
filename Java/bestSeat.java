public class bestSeat {
    int bestSeat = -1;
    int maxSpace= 0;

    int left = 0;
    while(left < seats.length) {
      int right = left + 1;
      Object seats;
      while(right < seats.length && seats[right] == 0) {
        right++;
      }
      int availableSpace = right -left - 1;
      if (availableSpace > maxSpace) {
        bestSeat = (left + right) / 2;
        maxSpace = availableSpace;
      }
      left = right;
    }
    return bestSeat;
}

import java.util.*;

class ProgramTest {
  @Test
  public void TestCase1() {
    var input = new int[] {1, 0, 1, 0, 0, 0, 1};
    var expected = 4;
    var actual = new Program().bestSeat(input);
    Utils.assertTrue(expected == actual);
  }
}