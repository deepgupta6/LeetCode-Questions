class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        StringBuilder word = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ')
                word.append(s.charAt(i));
            else if (!word.isEmpty()) {
                word.append(" ");
                res.append(word.reverse());
                word = new StringBuilder();
            }
        }
        if (!word.isEmpty()) {
            word.append(" ");
            res.append(word.reverse());
        }
        return res.substring(1);

    }
}

// more optimized version

class Solution2 {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ')
                i--;

            if (i < 0)
                break;

            int j = i;

            while (i >= 0 && s.charAt(i) != ' ')
                i--;
            if (res.length() > 0)
                res.append(" ");
            res.append(s.substring(i + 1, j + 1));

        }

        return res.toString();

    }
}