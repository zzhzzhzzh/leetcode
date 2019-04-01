class Solution {
	public char[] reverse(char[] ch) {
		if (ch.length == 0) return ch;
		int i = 0, j = 0;
		while (i < ch.length && j < ch.length) {
			i = j;
			while (i < ch.length && !Character.isDigit(ch[i])) {
				i++;
			}
			j = i;
			while (j < ch.length && Character.isDigit(ch[j])) {
				j++;
			}
			if (i >= ch.length) break;
			swap(ch, i, j - 1);
		}
		return ch;
	}
	public void swap(char[] ch, int i, int j) {
		while(i < j) {
			char c = ch[i];
			ch[i] = ch[j];
			ch[j] = c;
			i++;
			j--;
		}
	}
}
