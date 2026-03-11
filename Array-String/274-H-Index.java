import java.util.Arrays;

// Brute Force T.C -> O(nlogn), S.C -> O(1)

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

// optimized version  T.C -> O(n), S.C -> O(n)

class Solution2 {
    public int hIndex(int[] citations) {
        int[] cnt = new int [1001];

        for(int i=0;i<citations.length;i++){
            cnt[citations[i]]++;
           
        }
        int res=0;

        for(int i=1000;i>=0;i--){
            if(cnt[i]>0){
                res+=cnt[i];
            }
            if(res>=i) return i;
        }
        return 0;

    }
}
