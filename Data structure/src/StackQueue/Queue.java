package StackQueue;
//先进先出
public class Queue {
    //数组存储栈
    int elements[];
    public  Queue(){
        elements=new int[0];
    }
    //压入元素
    public void add(int element){
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
    public int poll(){
        if(elements.length==0){
            throw new RuntimeException("队列中没有元素") ;
        }
        //区第一个
        int element=elements[0];
        //创建新数组
        int [] newArr=new int[elements.length-1];
        //原数组的元素复制到新数组
        for (int i = 0; i <elements.length-1; i++) {
            //第0个不要了
            newArr[i]=elements[i+1];
        }
        //新数组替换就数组
        elements=newArr;
        //返回队头元素
        return element;
    }
    //其他方法类似
}
