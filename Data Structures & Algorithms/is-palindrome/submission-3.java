class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;

                if (left >= right) {
                    return true;
                }
            }

            while (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;

                if (left >= right) {
                    return true;
                }
            }

            if (left >= right) {
                return true;
            }

            System.out.println("left: " + s.charAt(left));
            System.out.println("right: " + s.charAt(right));

            if (Character.toUpperCase(s.charAt(left)) != Character.toUpperCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
