class Solution {
	public static void reverse(String s) {
		if (s == null || s.length() == 0) return;
		int i = 0, j = 0;
		s = s.trim();
		StringBuilder sb = new StringBuilder();
		while (i < s.length() && j < s.length()) {
			i = j;
			while (i < s.length() && !Character.isLetter(s.charAt(i))) {
				i++;
			}
			j = i;
			while (j < s.length() && Character.isLetter(s.charAt(j))) {
				j++;
			}
			if (i > s.length()) break;
			if (i == j) System.out.println(s.charAt(i));
			else System.out.println(s.substring(i, j));
		}
	}
	public static void main(String[] args) {
		String s = "the sky is blue";
		reverse(s);
	}	
}
