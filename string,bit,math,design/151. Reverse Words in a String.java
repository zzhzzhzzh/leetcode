class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";
        String[] ss = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = ss.length - 1; i >= 0; i--) {
            String str = ss[i];
            if (!str.equals("")) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(str);
            }
        }

        return sb.toString();
    }
}
