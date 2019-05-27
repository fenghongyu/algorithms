package com.algorithms.datastructure.st.myString;

/**
 * T为非空字符串.若主串S中第pos个字符串之后存在与T相等的子串,
 * 则返回第一个这样的子串在S中的位置,否则返回0.
 */
public class StrIndex {

    public static void main(String[] args) {
        System.out.println(getIndex());
    }

    public static int getIndex() {
        String S = "aj";
        String T = "aj";
        int n = S.length();
        int m = T.length();
        int pos = 0;
        while(pos<=n-m+1) {
            String tmp = S.substring(pos,pos+m);
            if(tmp != null && tmp.equals(T)) {
                return pos;
            } else {
                pos++;
            }
        }
        return pos;
    }


}
