class Solution {
    public int trap(int[] list) {
        

        // u keep adding up amount as if these are the current bounds (not if there is a less than after the left)

        // if u find a bigger one that u use that as ure neew bound and treat old bounds as 

        // but how do u know when we are starting a full differnet section
        // u start a new section fo u find a new taler section

        int n = list.length;
        if (n <= 2) return 0;

        int l = 0;
        while (l < n - 1 && list[l] == 0) l++;
        int r = l + 1;
        int amt = 0;
        int sbt = 0;

        int r2 = n - 1;
        while (r2 >= 1 && list[r2] == 0) r2--;
        int l2 = r2 - 1;
        int sbt2 = 0;

        while (r < n && l2 >= 0) { 
            if (list[r] < list[l]) {
                sbt += list[r];
                r++;
            } else {
                amt += list[l] * (r - l - 1) - sbt;
                l = r;
                r++;
                sbt = 0;
            }

            if (list[l2] <= list[r2]) {
                sbt2 += list[l2];
                l2--;
            } else {
                amt += list[r2] * (r2 - l2 - 1) - sbt2;
                r2 = l2;
                l2--;
                sbt2 = 0;
            }
        }

        return amt; 
    }
}
