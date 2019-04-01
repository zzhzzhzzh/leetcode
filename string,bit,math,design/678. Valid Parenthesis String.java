class Solution {
    public boolean checkValidString(String s) {
        int l = 0, cp = 0;
        for (int i = 0;  i< s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                l++;
                cp++;
            } else if (c == '*') {
                if (l > 0) {
                    l--;
                }
                cp++;
            } else {
                if (l > 0) {
                    l--;
                }
                cp--;
                if (cp < 0) {
                    return false;
                }
            }
        }
        if (l == 0) {
            return true;
        } else {
            return false;
        }
    }
}
