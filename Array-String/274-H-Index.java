import java.util.Arrays;

public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int ans = 0;
        int n = citations.length;

        for (int i = 0; i < citations.length; i++) {
            if (n - i >= citations[i])
                ans = Math.max(ans, citations[i]);
            else if (n - i < citations[i])
                ans = Math.max(ans, n - i);
        }

        return ans;

    }
} 
