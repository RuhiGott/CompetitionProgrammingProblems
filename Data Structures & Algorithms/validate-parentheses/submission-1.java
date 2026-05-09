class Solution {
    public boolean isValid(String s) {
        List<Character> starting = List.of('(', '{', '[');
        List<Character> ending = List.of(')', '}', ']');

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char currLetter = s.charAt(i);
            
            if (starting.contains(currLetter)) {
                stack.push(currLetter);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char lastLetter = stack.pop();
                if (starting.get(ending.indexOf(currLetter)) != lastLetter) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
