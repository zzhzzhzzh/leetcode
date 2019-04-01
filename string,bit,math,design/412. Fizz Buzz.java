class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        for (int i = 1; i <= n; i++) {
            String string = "";
            if (i % 3 == 0)
                string += "Fizz";
            if (i % 5 == 0)
                string += "Buzz";
            if (string.length() == 0) {
                res.add(String.valueOf(i));
            } else {
                res.add(string);
            }
        }
        return res;
    }
}
