package com.muxiyu.Learn;

import java.util.EmptyStackException;
import java.util.Stack;
public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        showPush(stack,100);
        showPush(stack,200);
        showpop(stack);
        showpop(stack);
        try {
            showpop(stack);
        } catch (EmptyStackException e) {
            System.out.println("empty stack");
        }
        System.out.println("back index"+stack.search(1));
        test(3);
    }
    static void showPush(Stack<Integer> stack,int a){
        stack.push(a);
        System.out.println("push(" + a + ")");
        System.out.println("stack element: " + stack);
        System.out.println("peek "+stack.peek());
    }
    static void showpop(Stack<Integer> st) {
        System.out.print("pop -> ");
        Integer a = st.pop();
        System.out.println(a);
        System.out.println("stack: " + st);
        if (st.isEmpty()==false){
            System.out.println("peek "+st.peek());
        }else{
            System.out.println("堆栈为空 ");
        }
    }
       static void test(int x) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        s1.push(x);
        s2.push(x);
        int p1 = s1.peek();
        int p2 = s2.peek();
        System.out.println(p1==p2);
        System.out.println(s1.peek() == s2.peek());
    }
}
