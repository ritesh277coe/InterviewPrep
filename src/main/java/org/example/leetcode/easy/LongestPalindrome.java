package org.example.leetcode.easy;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {

    Set<String> seen = new HashSet<>();
    int maxLen = 0;
    String pd = null;

    boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() -1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }

        return true;

    }


    public String longestPalindrome(String s) {
        if (s.length() == 0)
            return null;

        if (seen.add(s) == false)
            return pd;

        if (isPalindrome(s)) {
            int lastLen = maxLen;
            maxLen = Math.max(s.length(), maxLen);

            if (maxLen > lastLen)
                pd = s;

            //System.out.println("pd::" + pd);
            return s;
        }

        //if (s.length() > 2)
        {
            longestPalindrome(s.substring(0, s.length() - 1));
            longestPalindrome(s.substring(1, s.length()));
        }
        return pd;
    }

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        System.out.println(lp.longestPalindrome("ibvjkmpyzsifuxcabqqpahjdeuzaybqsrsmbfplxycsafogotliyvhxjtkrbzqxlyfwujzhkdafhebvsdhkkdbhlhmaoxmbkqiwiusngkbdhlvxdyvnjrzvxmukvdfobzlmvnbnilnsyrgoygfdzjlymhprcpxsnxpcafctikxxybcusgjwmfklkffehbvlhvxfiddznwumxosomfbgxoruoqrhezgsgidgcfzbtdftjxeahriirqgxbhicoxavquhbkaomrroghdnfkknyigsluqebaqrtcwgmlnvmxoagisdmsokeznjsnwpxygjjptvyjjkbmkxvlivinmpnpxgmmorkasebngirckqcawgevljplkkgextudqaodwqmfljljhrujoerycoojwwgtklypicgkyaboqjfivbeqdlonxeidgxsyzugkntoevwfuxovazcyayvwbcqswzhytlmtmrtwpikgacnpkbwgfmpavzyjoxughwhvlsxsgttbcyrlkaarngeoaldsdtjncivhcfsaohmdhgbwkuemcembmlwbwquxfaiukoqvzmgoeppieztdacvwngbkcxknbytvztodbfnjhbtwpjlzuajnlzfmmujhcggpdcwdquutdiubgcvnxvgspmfumeqrofewynizvynavjzkbpkuxxvkjujectdyfwygnfsukvzflcuxxzvxzravzznpxttduajhbsyiywpqunnarabcroljwcbdydagachbobkcvudkoddldaucwruobfylfhyvjuynjrosxczgjwudpxaqwnboxgxybnngxxhibesiaxkicinikzzmonftqkcudlzfzutplbycejmkpxcygsafzkgudy"));
        System.out.println(lp.pd);
    }
}
