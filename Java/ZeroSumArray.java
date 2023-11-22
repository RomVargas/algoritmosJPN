/*
<p>
    You're given a list of integers <span>nums</span>. Write a function that
    returns a boolean representing whether there exists a zero-sum subarray of
   <span>nums</span>.
</p>
<p>
    A zero-sum subarray is any subarray where all of the values add up to zero.
    A subarray is any contiguous section of the array. For the purposes of this
    problem, a subarray can be as small as one element and as long as the
    original array.
  </p>
 */

public class ZeroSumArray {
  import java.util.*;

  public boolean zeroSumSubarray(int[] nums) {
    HashSet<Integer> sums = new HashSet<Integer>();
    sums.add(0);
    int currentSum = 0;
    for (int num : nums) {
      currentSum += num;
      if (sums.contains(currentSum)){
        return true;
      }
      sums.add(currentSum);
    }
    return false;
    
  }

}
