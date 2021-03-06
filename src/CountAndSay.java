/*
 * Problem 38: Count and Say
 * 
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
 */
public class CountAndSay {

	public static void main(String[] args) {

	}

	public String countAndSay(int n) {
		StringBuffer s = new StringBuffer("1");
		StringBuffer res = new StringBuffer();
		while ((--n) != 0) {
			res.setLength(0);
			int size = s.length();
			int cnt = 1;
			char cur = s.charAt(0);
			// Keep calculating the count and then append the count and the number
			for (int i = 1; i < size; i++) {
				if (s.charAt(i) != cur) {
					res.append(cnt);
					res.append(cur);
					cur = s.charAt(i);
					cnt = 1;
				} else
					++cnt;
			}
			res.append(cnt);
			res.append(cur);
			StringBuffer tmp = s;
			s = res;
			res = tmp;
		}
		return s.toString();
	}
}
