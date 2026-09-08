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

        for (int num : nums) {
            if (buckets[map.get(num)] == null) {
                buckets[map.get(num)] = new ArrayList<>();
            }
            if (!buckets[map.get(num)].contains(num)) {
                buckets[map.get(num)].add(num);
            }
            
        }

        int[] sol = new int[k];

        int i = nums.length;
        int index = 0;
        k--;

        while (k >= 0 && i >= 0) {
            if (!(buckets[i] == null)) {
                for (Integer num : buckets[i]) {
                    sol[k] = num;
                    k--;
                }
            }

            i--;
        }

        return sol;
        
    }
}
