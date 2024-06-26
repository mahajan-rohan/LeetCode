/*
345. Reverse Vowels of a String
Given a string s, reverse only all the vowels in the string and return it.
The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

Example 1:
Input: s = "hello"
Output: "holle"

Example 2:
Input: s = "leetcode"
Output: "leotcede"

Constraints:
1 <= s.length <= 3 * 105
s consist of printable ASCII characters.
 */

public class ReverseVowels {
    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
                || c == 'U';
    }

    public String reverseVowels(String s) {
        StringBuilder ans = new StringBuilder(s);
        for (int i = 0, j = s.length() - 1; i < j;) {
            if (isVowel(s.charAt(i)) && isVowel(s.charAt(j))) {
                char ch = s.charAt(i);
                ans.setCharAt(i, s.charAt(j));
                ans.setCharAt(j, ch);
                i++;
                j--;
            } else {
                if (!isVowel(s.charAt(i)))
                    i++;
                if (!isVowel(s.charAt(j)))
                    j--;
            }
        }
        return ans.toString();
    }
}
