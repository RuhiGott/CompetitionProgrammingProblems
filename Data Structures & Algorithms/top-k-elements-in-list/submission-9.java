class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       
        
        // num -> freq
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for (int num : map.keySet()) {
            if (buckets[map.get(num)] == null) {
                buckets[map.get(num)] = new ArrayList<>();
            }
            
                buckets[map.get(num)].add(num);
            
            
        }

        int[] sol = new int[k];

        int i = nums.length;

        while (k >= 0 && i >= 0) {
            if (!(buckets[i] == null)) {
                for (Integer num : buckets[i]) {
                    k--;
                    if (k < 0) break;
                    sol[k] = num;
                }
            }

            i--;
        }

        return sol;
        
    }
}
