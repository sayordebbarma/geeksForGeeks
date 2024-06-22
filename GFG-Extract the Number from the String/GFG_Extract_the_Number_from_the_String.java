class Solution {
    long ExtractNumber(String sentence) {
        // code here
        String[] tokens = sentence.split(" ");
        long maxNumber = -1;

        for (String token : tokens) {
            if (isNumeric(token) && !containsNine(token)) {
                long number = Long.parseLong(token);
                if (number > maxNumber) maxNumber = number;
            }
        }

        return maxNumber;
    }

    private static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    private static boolean containsNine(String str) {
        return str.contains("9");
    }
}
