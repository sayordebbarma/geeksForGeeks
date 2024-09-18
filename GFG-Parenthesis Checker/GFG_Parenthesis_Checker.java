class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        // add your code here
        Stack<Character> s = new Stack<>();
        
        for (char c : x.toCharArray()) {
            switch(c) {
                case '(': case '{': case '[':
                    s.push(c);
                    break;
                case ')':
                    if (s.isEmpty() || s.pop() != '(') return false;
                    break;
                case '}':
                    if (s.isEmpty() || s.pop() != '{') return false;
                    break;
                case ']':
                    if (s.isEmpty() || s.pop() != '[') return false;
                    break;
            }
        }
        return s.isEmpty();

    }
}
