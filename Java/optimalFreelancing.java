public class optimalFreelancing {
     public int optimalFreelancing(Map<String, Integer>[] jobs) {
    final int LENGTH_OF_WEEK = 7;
    int profit = 0;
    Arrays.sort(jobs, new Comparator<Map<String, Integer>>() {
      public int compare(
        final Map<String, Integer> jobOne, final Map<String, Integer> jobTwo
      ) {
        return jobTwo.get("payment").compareTo(jobOne.get("payment"));
      }
    });

    boolean[] timeline = new boolean[LENGTH_OF_WEEK];

    for (Map<String, Integer> job : jobs) {
      int maxTime = Math.min(job.get("deadline"), LENGTH_OF_WEEK);
      for(int time = maxTime - 1; time >= 0; time--) {
        if(timeline[time] == false) {
          timeline[time] = true;
          profit += job.get("payment");
          break;
        }
      }
    }
    return profit;
  }
}
