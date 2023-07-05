class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() < str2.length()) {
            // Swap the strings so that str1 is always longer or equal in length to str2
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        
        if (!str1.startsWith(str2)) {
            // If str2 is not a prefix of str1, there is no common divisor
            return "";
        } else if (str2.isEmpty()) {
            // If str2 is empty, str1 is the greatest common divisor
            return str1;
        } else {
            // Recursively find the greatest common divisor by removing str2 from str1
            return gcdOfStrings(str1.substring(str2.length()), str2);
        }
    }
}
