class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        Set<String> ops = Set.of("+", "-", "*", "/");

        for (String token : tokens) {
            if (ops.contains(token)) {
                int num2 = stack.pop();
                int num1 = stack.pop();

                if (token.equals("+")) stack.push(num1 + num2);
                if (token.equals("-")) stack.push(num1 - num2);
                if (token.equals("*")) stack.push(num1 * num2);
                if (token.equals("/")) {
                    stack.push(num1 / num2);
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.peek();
    }
}
