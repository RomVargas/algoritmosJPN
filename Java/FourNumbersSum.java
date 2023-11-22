import java.util.*;
/**
 * <h1> Four Numbers Sum </h1>
 * <p> Algoritmo para obtener 4 digitos que sumen un resultado dado </p>
 * <p>  </p>
 * { @code fourNumbersum() }
 * @author Roman Vargas
 * @since 1.0
 * @version 1.0
 */
class FourNumbersSum {
  
  /** 
   * @param array
   * @param targetSum
   * @return List<Integer[]>
   */
  public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
    Map<Integer, List<Integer[]>> allPairSums = new HashMap<>();
		List<Integer[]> quadruplets = new ArrayList<Integer[]>();
		for(int i = 1; i < array.length - 1; i++) {
			for(int j = i + 1; j < array.length; j++) {
				int currentSum = array[i] + array[j];
				int difference = targetSum - currentSum;
				if(allPairSums.containsKey(difference)) {
					for(Integer[] pair: allPairSums.get(difference)) {
						Integer[] newQuadruplet = {pair[0], pair[1], array[i], array[j]};
						quadruplets.add(newQuadruplet);
					}
				}
			}
			for(int k = 0; k < i; k++){
				int currentSum = array[i] + array[k];
				Integer[] pair = {array[k], array[i]};
				if(!allPairSums.containsKey(currentSum)) {
					List<Integer[]> pairsGroup = new ArrayList<Integer[]>();
					pairsGroup.add(pair);
					allPairSums.put(currentSum, pairsGroup);
				} else {
					allPairSums.get(currentSum).add(pair);
				}
			}
		}
    return quadruplets;
  }
}