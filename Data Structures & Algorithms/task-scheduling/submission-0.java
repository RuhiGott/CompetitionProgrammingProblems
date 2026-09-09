class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freqs = new int[26];

        for (char task : tasks) {
            freqs[task - 'A']++;
        }

        int maxFreq = 0;
        int numMaxFreq = 0;

        for (int freq : freqs) {
            if (freq > maxFreq) {
                maxFreq = freq;
                numMaxFreq = 1;
            } else if (freq == maxFreq) {
                numMaxFreq++;
            }
        }

        return Math.max(tasks.length, (n + 1) * (maxFreq - 1) + numMaxFreq);



    }
}
