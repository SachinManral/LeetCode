// import java.util.Stack;

// class Solution {
//     public String removeOuterParentheses(String s) {
//         Stack<Character> stack = new Stack<>();
//         StringBuilder result = new StringBuilder();

//         for (char c : s.toCharArray()) {
//             if (c == '(') {
//                 if (!stack.isEmpty()) {
//                     result.append(c);
//                 }
//                 stack.push(c);
//             } else { 
//                 stack.pop();
//                 if (!stack.isEmpty()) {
//                     result.append(c);
//                 }
//             }
//         }

//         return result.toString();
//     }
// }





class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int open = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (open > 0) {
                    result.append(ch);
                }
                open++;
            } else { 
                open--;
                if (open > 0) {
                    result.append(ch);
                }
            }
        }

        return result.toString();
    }
}
