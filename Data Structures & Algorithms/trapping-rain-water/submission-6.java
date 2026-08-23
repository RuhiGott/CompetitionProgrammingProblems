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

    while (r < n) { 
        if (list[r] < list[l]) {
            sbt += list[r];
            r++;
        } else {
            amt += list[l] * (r - l - 1) - sbt;
            l = r;
            r++;
            sbt = 0;
        }
    }

    sbt = 0;

    r = n - 1;
    while (r >= 1 && list[r] == 0) r--;
    l = r - 1;

    while (l >= 0) { 
        if (list[l] <= list[r]) {
            sbt += list[l];
            l--;
        } else {
            amt += list[r] * (r - l - 1) - sbt;
            r = l;
            l--;
            sbt = 0;
        }
    }




    return amt;






    }
}
