public class Solution {
    /**
     * @param n: n pairs
     * @return: All combinations of well-formed parentheses
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        //List<String> list = new ArrayList<>();
        if (n < 0) {
            return res;
        }
        dfs(n, new StringBuilder(), res);
        return res;
    }
    
    private void dfs(int n, StringBuilder sb, List<String> res) {
        if (sb.length() == n * 2) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                sb.append("(");
            } else {
                sb.append(")");
            }
            if (isValid(sb, n)) {
                dfs(n, sb, res);
            }
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    private boolean isValid(StringBuilder sb, int n) {
        int count = 0;
        int left = 0;
        for (char c: sb.toString().toCharArray()) {
            if (c == '(') {
                count++;
                left++;
            } else {
                count--;
            }
            if (count < 0 || left > n) 
                return false;
        }
        return true;
    }
}
