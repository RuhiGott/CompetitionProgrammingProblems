class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        } 

        List<Character> starting = List.of('(', '{', '[');
        List<Character> ending = List.of(')', '}', ']');

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char currLetter = s.charAt(i);
            
            if (currLetter == '(') stack.push(')');
            else if (currLetter == '{') stack.push('}');
            else if (currLetter == '[') stack.push(']');
            
            else {
                if (stack.isEmpty() || stack.pop() != currLetter) {
                    return false;
                }
               
            }
        }

        return stack.isEmpty();
    }
}
