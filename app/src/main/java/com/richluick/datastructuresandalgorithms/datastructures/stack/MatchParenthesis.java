package com.richluick.datastructuresandalgorithms.datastructures.stack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by rluic on 1/22/2017.
 *
 * Complexity is O(n)
 */
public class MatchParenthesis {

    private static final Map<Character, Character> mathingParenMap = new HashMap<>(); //map closing bracket with corresponding brace
    private static final Set<Character> openingParenSet = new HashSet<>(); //set of opening brackets

    static {
        mathingParenMap.put(')', '(');
        mathingParenMap.put(']', '[');
        mathingParenMap.put('}', '{');
        openingParenSet.addAll(mathingParenMap.values());
    }

    private static boolean hasMatchingParams(String input) {
        try {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);

                //add to stack if opening brace
                if (openingParenSet.contains(c)) {
                    stack.push(c);
                }

                //check if it is a closing bracket
                if (mathingParenMap.containsKey(c)) {
                    Character lastParen = stack.pop();
                    //check if the last opening bracket is equal to the opening bracket
                    if (lastParen != mathingParenMap.get(c)) {
                        return false;
                    }
                }
            }

            //check if we have additional elements
            return stack.isEmpty();
        } catch (StackOverflowException e) {
            e.printStackTrace();
        } catch (StackUnderflowException e) {
            e.printStackTrace();
        }

        return false;
    }
}




