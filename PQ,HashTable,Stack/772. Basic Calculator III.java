class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int number = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = number * 10 + (int)(c - '0');
            }
            if (c == '(') {
                
                int j = i, count = 0;
                for ( ;i < s.length(); i++) {
                    if (s.charAt(i) == '(') {
                        count++;
                    } else if (s.charAt(i) == ')') {
                        count--;
                    }
                    if (count == 0) {
                        number = calculate(s.substring(j + 1, i));
                        break;
                    }
                }
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(number);
                }
                if (sign == '-') {
                    stack.push(-number);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * number);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / number);
                }
                sign = c;
                number = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        } 
        return res;
    }
}
