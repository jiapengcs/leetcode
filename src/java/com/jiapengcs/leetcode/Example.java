package com.jiapengcs.leetcode;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 18-1-19
 */
public class Example {
    String str = new String("good");
    char[] ch = { 'a', 'b', 'c' };

    public static void main(String args[]) {
        Example ex = new Example();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");
        System.out.print(ex.ch);
        ex.test();
    }

    public static void change(String str, char ch[])
    {
        str = "test ok";
        ch[0] = 'g';
    }

    public void add(Byte b)
    {
        b = b++;
    }
    public void test()
    {
        Byte a = 127;
        Byte b = 127;
        add(++a);
        System.out.print(a + " ");
        add(b);
        System.out.print(b + "");
    }
}