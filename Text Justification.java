class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int startIndex = 0;

        while (startIndex < words.length) {
            int endIndex = findEndIndex(words, startIndex, maxWidth);
            result.add(justifyLine(words, startIndex, endIndex, maxWidth));
            startIndex = endIndex + 1;
        }

        return result;
    }

    private int findEndIndex(String[] words, int startIndex, int maxWidth) {
        int endIndex = startIndex;
        int lineLength = words[startIndex].length();

        while (endIndex < words.length - 1 && lineLength + words[endIndex + 1].length() + 1 <= maxWidth) {
            endIndex++;
            lineLength += words[endIndex].length() + 1;
        }

        return endIndex;
    }

    private String justifyLine(String[] words, int startIndex, int endIndex, int maxWidth) {
        StringBuilder line = new StringBuilder();

        if (startIndex == endIndex || endIndex == words.length - 1) {
            // Left justify if only one word in the line or last line
            for (int i = startIndex; i <= endIndex; i++) {
                line.append(words[i]);
                if (i != endIndex) {
                    line.append(" ");
                }
            }

            while (line.length() < maxWidth) {
                line.append(" ");
            }
        } else {
            int wordCount = endIndex - startIndex + 1;
            int totalSpaces = maxWidth - countWordsLength(words, startIndex, endIndex);
            int spacesBetweenWords = totalSpaces / (wordCount - 1);
            int extraSpaces = totalSpaces % (wordCount - 1);

            for (int i = startIndex; i <= endIndex; i++) {
                line.append(words[i]);

                if (i != endIndex) {
                    int spacesToAdd = spacesBetweenWords + (extraSpaces-- > 0 ? 1 : 0);
                    appendSpaces(line, spacesToAdd);
                }
            }
        }

        return line.toString();
    }

    private int countWordsLength(String[] words, int startIndex, int endIndex) {
        int length = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            length += words[i].length();
        }
        return length;
    }

    private void appendSpaces(StringBuilder sb, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(" ");
        }
    }
}ss