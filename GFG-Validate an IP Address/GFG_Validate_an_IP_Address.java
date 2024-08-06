class Solution {

    public boolean isValid(String str) {
        // Write your code here
        String[] parts = str.split("\\.");
        
        if (parts.length != 4) return false;

        for (String part : parts) {
            if (!isValidPart(part)) return false;
        }
        
        return true;
    }

    private static boolean isValidPart(String part) {
        try {
            if (part.length() > 1 && part.startsWith("0")) return false;

            int num = Integer.parseInt(part);
            if (num < 0 || num > 255) return false;
        } catch (NumberFormatException e) {
            return false;
        }
        
        return true;
    }
}
