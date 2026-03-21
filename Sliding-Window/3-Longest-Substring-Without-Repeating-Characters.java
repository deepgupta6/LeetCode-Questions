class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> st = new HashSet<>();

        int i = 0, j = 0;
        int len = 0;

        while (i < s.length()) {
            while (st.contains(s.charAt(i))) {
                st.remove(s.charAt(j));
                j++;
            }

            st.add(s.charAt(i));
            len = Math.max(len, i - j+1);
            i++;
        }
        return len;

    }
}