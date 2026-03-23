class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mp = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);

            if (mp.containsKey(sorted)) {
                mp.get(sorted).add(strs[i]);
            } else {
                List<String> li = new ArrayList<>();
                li.add(strs[i]);
                mp.put(sorted, li);
            }
        }

        List<List<String>> res = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : mp.entrySet()) {
            res.add(entry.getValue());
        }
        return res;

    }
}