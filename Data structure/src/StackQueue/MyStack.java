package StackQueue;
//后进先出
public class MyStack {
    //数组存储栈
    int elements[]=new int[10];
    //压入元素
    public void push(int element){
        //创建一个新数组,比前数组长一
        int [] newArr=new int[elements.length+1];
        //原数组的元素复制到新数组
        for (int i = 0; i <elements.length ; i++) {
            newArr[i]=elements[i];
        }
        //添加的元素放到新数组,放到最后一个位置
        newArr[elements.length]=element;
        //新数组替换就数组
        elements=newArr;
    }
    //取出栈顶元素,
    public int pop(){
        if(elements.length==0){
         throw new RuntimeException("栈中没有元素") ;
        }
        //也是取出最后一个元素,长度减少
        int element=elements[elements.length-1];
        //创建新数组
        int [] newArr=new int[elements.length-1];
        //原数组的元素复制到新数组
        for (int i = 0; i <elements.length-1; i++) {
            newArr[i]=elements[i];
        }
        //新数组替换就数组
        elements=newArr;
        //返回栈顶元素
        return element;
    }
    public int peek(){
        if(elements.length==0){
            throw new RuntimeException("栈中没有元素") ;
        }
        return elements[elements.length-1];
    }
    //判断是否为空
    public boolean isEmpty(){
        return elements.length==0;
    }
}
