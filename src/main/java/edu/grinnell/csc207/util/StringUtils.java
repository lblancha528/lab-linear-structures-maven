package edu.grinnell.csc207.util;

import edu.grinnell.csc207.linear.Stack;
import edu.grinnell.csc207.linear.LinkedStack;

import java.io.PrintWriter;

/**
 * Assorted utilities for working with strings.
 * 
 * @author Samuel A. Rebelsky
 * @author Lily Blanchard
 * @author Tiffany Yan
 * @author Moise Milenge
 */ 
public class StringUtils {
  // +------------------+--------------------------------------------
  // | Provided methods |
  // +------------------+
    
  /**
   * Determine whether the parens match in string.
   */
  public static boolean checkMatching(String str) throws Exception {
    Stack<Character> parens = new LinkedStack<Character>();
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) != '(' && str.charAt(i) != ')'
          && str.charAt(i) != '[' && str.charAt(i) != ']') {
            continue;
          } // if
      if (str.charAt(i) == '(' || str.charAt(i) == '[') {
        try{
          parens.push(str.charAt(i));
        } catch (Exception e) {
          e.printStackTrace();
        } // try/catch
      } else if ((str.charAt(i) == ')' || str.charAt(i) == ']')
            && parens.isEmpty()) {
        throw new Exception("Mismatch");
      } else if (str.charAt(i) == ')' && (parens.peek() == '(' )) {
        parens.pop();
      } else if (str.charAt(i) == ']' && (parens.peek() == '[' )) {
        parens.pop();
      } else {
        throw new Exception("no matching paren/bracket");
      } // if
    } // for
    if (!parens.isEmpty()) {
      throw new Exception("Mismatch");
    } // if
    return true;      
  } // checkMatching
} // class StringUtils    

