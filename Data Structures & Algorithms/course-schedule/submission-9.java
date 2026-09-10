class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new ArrayList[numCourses];

        for (int[] pair : prerequisites) {
            if (adjList[pair[1]] == null) {
                adjList[pair[1]] = new ArrayList<>();
            }

            adjList[pair[1]].add(pair[0]);
        }

        int[] visited = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && detectCycle(i, adjList, visited)) {
                return false;
            }

            visited[i] = 2;
            System.out.println("next node");

        }

        return true;
    }

    private boolean detectCycle(int i, List<Integer>[] adjList, int[] visited) {
        if (visited[i] == 1) {
            return true;
        } 

        visited[i] = 1;

        if (adjList[i] != null) {
            for (Integer neighbor : adjList[i]) {
               if (visited[neighbor] != 2) {
                if (detectCycle(neighbor, adjList, visited)) {
                    return true;
                };
               }
            }
            
        }

        visited[i] = 2;

        return false;
    }
}
