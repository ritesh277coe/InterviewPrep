package org.example.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 242. Valid Anagram
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 */

public class ValidAnagram242 {

   boolean isAnaGram(String str1, String str2) {
       char[] str1Array = str1.toCharArray();
       char[] str2Array = str2.toCharArray();

       Arrays.sort(str1Array);
       Arrays.sort(str2Array);

       if (str1Array.length != str2Array.length)
           return false;

       int i;
       for( i = 0; i < str1Array.length; i++) {
           if (str1Array[i] != str2Array[i])
               break;
       }

       if (i != str1Array.length)
           return false;
       else
           return true;
   }

    boolean isAnaGramSlower(String s, String t) {
       Map<Character, Integer> map = new HashMap<>();

        int i;
        for( i = 0; i < s.length(); i++) {
            Integer count = map.get(s.charAt(i));
            if (count == null) {
                map.put(s.charAt(i), 1);
            } else {
                count = count+1;
                map.put(s.charAt(i), count++);
            }
        }

        for( i = 0; i < t.length(); i++) {
            Integer count = map.get(t.charAt(i));
            if (count == null) {
                return false;
            }

            count = count-1;
            map.put(t.charAt(i), count);
        }

        for( i = 0; i < t.length(); i++) {
            Integer count = map.get(t.charAt(i));
            if (count != 0)
                return false;
        }

        return true;
    }

   public static void main(String[] args) {
       ValidAnagram242 va = new ValidAnagram242();
       System.out.println("Is anagram " + va.isAnaGramSlower("anagram", "nagaram"));
       System.out.println("Is anagram " + va.isAnaGramSlower("cat", "rat"));
       System.out.println("Is anagram " + va.isAnaGramSlower("cat", "atc"));
   }
}
