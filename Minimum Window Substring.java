class Solution {
    public String minWindow(String s, String t) {
        // Map to track the count of characters in t
        Map<Character, Integer> target = new HashMap<>();
        for (char c : t.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        
        int left = 0; // Left pointer of the sliding window
        int count = 0; // Count of characters in t found in the current window
        int minLen = Integer.MAX_VALUE; // Minimum window length
        int minStart = 0; // Start index of the minimum window substring
        
        // Traverse the string using the right pointer
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            
            // Decrement the count of the current character in target map
            if (target.containsKey(c)) {
                target.put(c, target.get(c) - 1);
                if (target.get(c) >= 0) {
                    count++;
                }
            }
            
            // Check if all characters in t are found in the current window
            while (count == t.length()) {
                // Update the minimum window substring if necessary
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                
                // Move the left pointer to find a smaller window
                char leftChar = s.charAt(left);
                if (target.containsKey(leftChar)) {
                    target.put(leftChar, target.get(leftChar) + 1);
                    if (target.get(leftChar) > 0) {
                        count--;
                    }
                }
                
                left++;
            }
        }
        
        // Return the minimum window substring or an empty string if not found
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        
        return s.substring(minStart, minStart + minLen);
    }
}