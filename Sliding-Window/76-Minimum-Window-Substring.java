class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> mp = new HashMap<>();

        for (char c : t.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }

        int i = 0, j = 0;
        int ws = Integer.MAX_VALUE;
        int si = 0;
        int req = t.length();

        while (i < s.length()) {

            char c = s.charAt(i);

            if (mp.containsKey(c)) {
                mp.put(c, mp.get(c) - 1);

                if (mp.get(c) >= 0) {
                    req--;
                }
            }

            while (req == 0) {

                if (i - j + 1 < ws) {
                    ws = i - j + 1;
                    si = j;
                }

                char ch = s.charAt(j);

                if (mp.containsKey(ch)) {
                    mp.put(ch, mp.get(ch) + 1);

                    if (mp.get(ch) > 0) {
                        req++;
                    }
                }

                j++;
            }

            i++;
        }

        return ws == Integer.MAX_VALUE ? "" : s.substring(si, si + ws);
    }
}