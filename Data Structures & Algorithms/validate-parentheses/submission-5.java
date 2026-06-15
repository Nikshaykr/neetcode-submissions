class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();

        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (char bracket : s.toCharArray()){
            if (map.containsKey(bracket)){
                if (!stack.isEmpty() && map.get(bracket) == stack.peek()) stack.pop();
                else return false;
            } 
            else stack.push(bracket);
        }
        return stack.isEmpty();
    }
}
