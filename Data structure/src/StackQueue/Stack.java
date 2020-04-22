package StackQueue;

public class Stack {
    //站的底层使用数组存储数据
    //创建一个数组
    int elements[]=new int[10];
    //压入元素
    public void push(int element){
        //定义一个新数组
        int []newArr=new int[elements.length+1];
        //把原数组赋值到新元素
        for (int i = 0; i < elements.length; i++) {
            newArr[i]=elements[i];
        }
        //把添加的元素放到新数组中去
        newArr[elements.length]=element;
        //使用新数组替换旧数组
        elements=newArr;
    }
    //取出栈顶元素,不需要告知是哪一个元素
    public  int pop(){
        //栈中没有元素
        if (elements.length==0){
            throw new RuntimeException("栈为空！");
        }
        //取出数组中的最后一个元素
        int element=elements[elements.length-1];
        //创建一个新数组，长度比原数组减一
        int []newArr=new int[elements.length-1];
        //原数组除了最后一个元素都赋值到新数组
        for (int i = 0; i < elements.length-1; i++) {
            newArr[i]=elements[i];
        }
        //使用新数组替换旧数组
        elements=newArr;
        //返回栈顶元素
        return  element;
    }
    //查看栈顶元素
    public  int peek(){
        if (elements.length==0){
            //站内没有元素
            throw new RuntimeException("栈为空！");
        }
        //返回数组的最后鹿一个元素
        return elements[elements.length-1];
    }
    //判断是否为空
    public boolean isEmpty(){
        return elements.length==0;
    }
}
