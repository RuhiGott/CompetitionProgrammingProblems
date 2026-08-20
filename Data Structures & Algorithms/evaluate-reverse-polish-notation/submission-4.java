class Solution {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];

        int i = 0;



        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int num2 = stack[i - 1];
                int num1 = stack[i - 2];

                i -= 2;

                if (token.equals("+")) {
                    stack[i] = num1 + num2;
                } else if (token.equals("-")) {
                    stack[i] = num1 - num2;
                } else if (token.equals("*")) {
                    stack[i] = num1 * num2;
                } else if (token.equals("/")) {
                    stack[i] = num1 / num2;
                }
            } else {
                stack[i] = Integer.parseInt(token);
            }

            i++;
        }

        return stack[i - 1];
    }
}
