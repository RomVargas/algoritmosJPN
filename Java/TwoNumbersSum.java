import java.io.*; 

public class TwoNumbersSum{

    public static void main(String[] args){
        int[] array = {1,2,3,5,6,8,9,-1,-4};
        System.out.println(twoNumbersSum(array, 13));
        System.out.println(twoNumbersSum2(array, 13));
    }

    public static int[] twoNumbersSum(int[] array, int targetSum){
        for (int i=0; i < array.length - 1; i++){
            int firstNum = array[i];
            for (int j = i + 1; j < array.length; j++){
                int secondNum = array[j];
                if(firstNum + secondNum == targetSum){
                    int[] res = {firstNum, secondNum};
                    System.out.print(res[0] + " + ");
                    System.out.print(res[1]);
                    System.out.println(" ");
                    return res;
                }
            }
        }
        return null;
    }

    public static int[] twoNumbersSum2(int[] array, int targetSum){
        Set<Integer> nums = new HashSet<>();

        return null;
    }
}
