class Solution {
    public boolean buddyStrings(String s, String goal) {
        int n = s.length();
        int m = goal.length();

        if (n != m) {
            return false;
        }

        if (s.equals(goal)) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
                if (count[c - 'a'] >= 2) {
                    return true;
                }
            }
            return false;
        }

        int index1 = -1, index2 = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (index1 == -1) {
                    index1 = i;
                } else if (index2 == -1) {
                    index2 = i;
                } else {
                    return false;
                }
            }
        }

        return (index2 != -1 && s.charAt(index1) == goal.charAt(index2) && s.charAt(index2) == goal.charAt(index1));
    }
}
