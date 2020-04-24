package Stack;

public class TestStack {

    public static void main(String[] args) {
        Stack stack=new Stack();
        stack.push(1);
        stack.push(12);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        MyStack ms=new MyStack();
        //压入元素
        ms.push(1);
        ms.push(12);
        ms.push(19);
        System.out.println(ms.pop());
        System.out.println(ms.peek());
    }
}
