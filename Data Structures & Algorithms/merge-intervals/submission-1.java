class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> sol = new ArrayList<>();

        int startTime = intervals[0][0];
        int endTime = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++) {
            if (endTime >= intervals[i][0]) {
                endTime = Math.max(endTime, intervals[i][1]);
            } else {
                sol.add(new int[]{startTime, endTime});
                startTime = intervals[i][0];
                endTime = intervals[i][1];
            }
        }   

        sol.add(new int[]{startTime, endTime});

        return sol.toArray(new int[sol.size()][]);
    }
}
