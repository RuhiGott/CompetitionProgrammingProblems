class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = Map.of('(',')','{','}','[',']');
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                
                if (map.get(stack.pop()) != s.charAt(i)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
