package com.kl.math.search;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/20 16:01
 * description:
 * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：
 * 每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
 * eg:"eleetminicoworoep"  输出:13 最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。
 * eg: "leetcodeisgreat" 输出:5 最长子字符串是 "leetc" ，其中包含 2 个 e 。
 * eg: "bcbcbc" 输出：6 这个示例中，字符串 "bcbcbc" 本身就是最长的，因为所有的元音 a，e，i，o，u 都出现了 0 次。
    提示：
        1 <= s.length <= 5 x 10^5
        s 只包含小写英文字母。
 */
public class FindTheLongestSubstring {

    public static void main(String[] args){
        String input = "eleetminicoworoep";
        System.out.println(findTheLongestSubstring(input));
    }

    private static int  findTheLongestSubstring(String s) {
        String longestSubStr = "";
        int cursor = 0;
        for(int index = 0; index < s.length(); index ++){
          String temp = doFindLongestSubstr(cursor, s);
          if(temp.length() > longestSubStr.length()){
              longestSubStr = temp;
          }
        }
        return longestSubStr.length();
    }

    private static String doFindLongestSubstr(int cursor, String s) {
        Map<Character, Integer> leftMagicCountMap = new HashMap<>();
        Map<Character, Integer> rightMagicCountMap = new HashMap<>();

        String leftStr = s.substring(0, cursor);
        if(leftStr != null){

        }

        String rightStr = s.substring(cursor);
        if(rightStr != null){

        }
        //todo
        return null;
    }

    private static boolean isMagicChar(char c) {
        return 'a' == c || 'e' == c || 'i' == c || 'o' == c || 'u' == c;
    }

}
