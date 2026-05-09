class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); // num, frequency
        List<Integer>[] frequencies = new List[nums.length + 1];

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : map.keySet()) {
            int freq = map.get(num);
            
            if (frequencies[freq] == null) {
                frequencies[freq] = new ArrayList<>();
            }

            frequencies[freq].add(num);
        }
        
        int[] solution = new int[k];
        int j = 0;
        int i = frequencies.length - 1;
        while (k > 0) {
            if (frequencies[i] != null) {
               

                for (int num : frequencies[i]) {
                    solution[j] = num;
                    j++;
                    k--;
                }

            }

            i--;
        }

        return solution;
    }
}
