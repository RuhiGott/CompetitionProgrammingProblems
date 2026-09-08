class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(row -> row[0]));

        List<List<Integer>> sol = new ArrayList<>();

        int startTime = intervals[0][0];
        int endTime = intervals[0][1];
        
        int i = 1;
        while (i < intervals.length) {  
            
            if (endTime >= intervals[i][0]) {
                endTime = Math.max(endTime, intervals[i][1]);
            } else {
                sol.add(List.of(startTime, endTime));
                startTime = intervals[i][0];
                endTime = intervals[i][1];
            }
            i++;
        }   

        sol.add(List.of(startTime, endTime));

        int[][] arr = new int[sol.size()][2];
        i = 0;
        for (List<Integer> pair : sol) {
            arr[i][0] = pair.get(0);
            arr[i][1] = pair.get(1);
            i++;
        }

        return arr;
    }
}
