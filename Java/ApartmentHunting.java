import java.util.*;

class ApartmentHunting {

    private static boolean gym;

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

	public static int distanceBetween(int a, int b) {
		return Math.abs(a - b);
	}
}