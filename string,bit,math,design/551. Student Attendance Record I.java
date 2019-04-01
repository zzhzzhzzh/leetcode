class Solution {
    public boolean checkRecord(String s) {
        if (s == null || s.length() == 0) return true;
        int countA = 0;
        int countinousL = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                countinousL = 0;
                countA++;
                if (countA > 1) return false;
            }
            if (c == 'L') {
                countinousL++;
                if (countinousL > 2) return false;
            }
            if (c == 'P') {
                countinousL = 0;
            }
        }
        return true;
    }
}
