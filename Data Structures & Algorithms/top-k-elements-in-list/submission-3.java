class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // key: num, val: freq
        Map<Integer, Integer> map1 = new HashMap<>();
        
        for (int num : nums) {
            if (map1.containsKey(num)) {
                map1.put(num, map1.get(num) + 1);
            } else {
                map1.put(num, 1);
            }
        }

        // key: freq, val: set of nums
        List<Integer>[] map2 = new List[nums.length + 1];

        for (int num : map1.keySet()) {
            if (map2[map1.get(num)] == null) {
                map2[map1.get(num)] = new ArrayList<>();
            }

            map2[map1.get(num)].add(num);
        }

        int[] solution = new int[k];
        int idx = 0;

        for (int i = nums.length; idx < k && i >= 0; i--) {
            List<Integer> list = map2[i];

            if (list != null) {
                for (Integer num : list) {
                    solution[idx] = num;
                    idx++;

                    if (idx >= k) break;
                }
            }
        }

        return solution;
    }
}
