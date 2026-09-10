class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new ArrayList[numCourses];

        for (int[] pair : prerequisites) {
            if (adjList[pair[1]] == null) {
                adjList[pair[1]] = new ArrayList<>();
            }

            adjList[pair[1]].add(pair[0]);
        }
        
        //System.out.println(Arrays.deepToString(adjList));

        int[] visited = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            boolean bool = detectCycle(i, adjList, visited);
            if (bool) System.out.println("Cycle Detected");
            if (bool) {
                return false;
            }

            visited[i] = 2;
            System.out.println("next node");

        }

        return true;
    }

    private boolean detectCycle(int i, List<Integer>[] adjList, int[] visited) {
        //System.out.println(i);
        //System.out.println("visited" + visited[i]);
        if (visited[i] == 1) {
           //System.out.println("CYCLE");
            return true;
        } 

        visited[i] = 1;

        if (adjList[i] != null) {
            for (Integer neighbor : adjList[i]) {
               //System.out.println("detectCycle(" + neighbor + "," + Arrays.toString(visited) + ")");          i
               if (visited[neighbor] != 2) {
                if (detectCycle(neighbor, adjList, visited)) {
                    return true;
                };
               }
            }
            
        }

        visited[i] = 2;
        
        //System.out.println("break");

        return false;
    }
}
