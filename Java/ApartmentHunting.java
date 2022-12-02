import java.util.*;

class ApartmentHunting {

    private static boolean gym;

    /**
     * We iterate through each block and for each block we iterate through each of the reqs and
     * calculate the distance from that block to the closest building that satisfies that req. We then
     * take the maximum of these distances to get the minimum distance we would have to travel from
     * that block to satisfy all of the reqs. We then return the block that has the minimum of these
     * maximums
     */
    public static void main(String[] args) {
        List<Map<String, Boolean>> blocks = new ArrayList<Map<String, Boolean>>() ;
        blocks.add(0, new HashMap<String, Boolean>());
        blocks.get(0).put("gym", false);
        blocks.get(0).put("school", true);
        blocks.get(0).put("store", false);

        blocks.add(1, new HashMap<String, Boolean>());
        blocks.get(1).put("gym", true);
        blocks.get(1).put("school", false);
        blocks.get(1).put("store", false);

        blocks.add(2, new HashMap<String, Boolean>());
        blocks.get(2).put("gym", true);
        blocks.get(2).put("school", true);
        blocks.get(2).put("store", false);

        blocks.add(3, new HashMap<String, Boolean>());
        blocks.get(3).put("gym", false);
        blocks.get(3).put("school", true);
        blocks.get(3).put("store", false);

        blocks.add(4, new HashMap<String, Boolean>());
        blocks.get(4).put("gym", false);
        blocks.get(4).put("school", true);
        blocks.get(4).put("store", true);
        String[] reqs = {"gym", "school", "store"};
        apartmentHunting(blocks, reqs);
    }

  /**
   * We iterate through each block and for each block, we find the closest block that has each of the
   * required amenities. We store these distances in an array. Finally, we return the index of the
   * block that's at the minimum distance from all the required amenities
   * 
   * @param blocks a list of dictionaries. Each dictionary has two keys: "gym" and "school". The value
   * corresponding to the key "gym" will be true if the apartment block has a gym and it will be false
   * if it does not have a gym. The value corresponding to the key "
   * @param reqs an array of strings, where each string is a requirement that the apartment needs to
   * have (e.g. "gym", "school", "store", etc.)
   * @return The index of the block that is closest to all the requirements.
   */
  public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
    int[] maxDistanceAtBlocks = new int[blocks.size()];
		Arrays.fill(maxDistanceAtBlocks, Integer.MIN_VALUE);
		
		for(int i =0; i < blocks.size(); i++) {
			for(String req : reqs) {
				int closestReqDistance = Integer.MAX_VALUE;
				for(int j = 0; j < blocks.size(); j++) {
					if(blocks.get(j).get(req)) {
						closestReqDistance = Math.min(closestReqDistance, distanceBetween(i, j));
				}
			}
			maxDistanceAtBlocks[i] = Math.max(maxDistanceAtBlocks[i], closestReqDistance);
		}
  }
    System.out.println(getIdxAtMinValue(maxDistanceAtBlocks));
	return getIdxAtMinValue(maxDistanceAtBlocks);
}

/**
 * > Find the index of the minimum value in an array
 * 
 * @param array the array to search
 * @return The index of the minimum value in the array.
 */
public static int getIdxAtMinValue(int[] array) {
	int idxAtMinValue = 0;
	int minValue = Integer.MAX_VALUE;
	for(int i = 0; i < array.length; i++) {
		int currentValue = array[i];
		if( currentValue < minValue) {
			minValue = currentValue;
			idxAtMinValue = i;
		}
	}
	return idxAtMinValue;
}

	/**
   * Returns the absolute value of the difference between two integers.
   * 
   * @param a The first number
   * @param b The number of the button that was pressed.
   * @return The absolute value of the difference between a and b.
   */
  public static int distanceBetween(int a, int b) {
		return Math.abs(a - b);
	}
}