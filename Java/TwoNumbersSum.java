import java.io.*; 
import java.util.*;

public class TwoNumbersSum{

    public static void main(String[] args){
        int[] array = {1,2,3,5,6,8,9,-1,-4};
        int[] res = twoNumbersSum2(array, 17);
        System.out.print(Integer.toString(res[0]) + " + ");
        System.out.print(Integer.toString(res[1]));
        System.out.println("");
        int[] res2 = twoNumbersSum2(array, 13);
        System.out.print(Integer.toString(res2[0]) + " + ");
        System.out.print(Integer.toString(res2[1]));
        int[] res3 = twoNumbersSum2(array, 17);
        System.out.println("");
        System.out.print(Integer.toString(res3[0]) + " + ");
        System.out.print(Integer.toString(res3[1]));
        System.out.println("");
    }

    public static int[] twoNumbersSum(int[] array, int targetSum){
        for (int i=0; i < array.length - 1; i++){
            int firstNum = array[i];
            for (int j = i + 1; j < array.length; j++){
                int secondNum = array[j];
                if(firstNum + secondNum == targetSum){
                    int[] res = {firstNum, secondNum};
                    return res;
                }
            }
        }
        return new int[0];
    }

public static int[] twoNumbersSum2(int[] array, int targetSum) {
    Set<Integer> nums = new HashSet<>();
		for (int num : array) {
			int potentialMatch = targetSum - num;
			if(nums.contains(potentialMatch)) {
				return new int[] {potentialMatch, num};
			} else {
				nums.add(num);
			}
		}
    return new int[0];
  }

 public static int[] twoNumbersSum3(int[] array, int targetSum) {
    Arrays.sort(array);
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			int currentSum = array[left] + array[right];
			if (currentSum == targetSum) {
				return new int[] {array[left], array[right]};
			} else if (currentSum < targetSum) {
				left++; 
			} else if(currentSum > targetSum) {
				right--;
			}
		}
    return new int[0];
  }
}


