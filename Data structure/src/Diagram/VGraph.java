package Diagram;

import Stack.MyStack;

import java.util.Stack;

public class VGraph {
    private Vertex[] vertex;
    private int currentSize;
    Stack stack=new Stack();
    //当前便利下标
    private int  currentIndex;
    //邻接矩阵(二维数组实现)
    public int [][]adjMax;
    public VGraph(int size) {
       vertex=new Vertex[size];
       adjMax=new int[size][size];
       //使用系统的栈

    }
    //增加一个顶点函数
    public void addVertex(Vertex x){
        vertex[currentSize++]=x;
    }
    //直接添加一条边
    public void addEdge(int start, int end) {
        adjMax[start][end] = 1;
        adjMax[end][start] = 1;
    }

    //增加一条边
    public void addEdge(String v1,String v2){
        int index1=0,index2=0;
        for (int i = 0; i <vertex.length ; i++) {
            if (vertex[i].getValue().equals(v1)){
                index1=i;
                break;
            }
        }
        for (int i = 0; i <vertex.length ; i++) {
            if (vertex[i].getValue().equals(v2)){
                index2=i;
                break;
            }
        }
        //两条边连通.值为1;
        adjMax[index1][index2]=1;
        adjMax[index2][index1]=1;
        adjMax[index1][index1]=1;
        adjMax[index2][index2]=1;

    }

    //获取和v邻接的未访问的顶点
    public int GetNoVertex(int v) {
        for (int i = 0; i <vertex.length ; i++) {
        if (adjMax[currentIndex][i]==1&& !vertex[i].visited){
            //返回没有范本的顶点的下标
            return i;
           }
        }
        return -1;
    }
    //通过判断顶点的值实现实现深度优先搜索
    public void DFS(int v){
     vertex[0].visited=true;
        //打印顶点值
        System.out.println(vertex[0].getValue());
        stack.push(0);
        while(!stack.isEmpty()){
        //取出栈顶元素,未连通的顶点的下标
            v=GetNoVertex((Integer) stack.peek());
            //=-1说明都访问过了
            if(v==-1){
               //就把当前栈顶元素出栈
               stack.pop();
            }else{
                //标记一访问,打印顶点下标,再入栈
                vertex[v].visited=true;
                displayVertex(v);
                stack.push(v);
            }
        }
        //重置，防止后边再次使用dfs
        for (int i = 0; i <vertex.length; i++) {
            vertex[i].visited=false;
        }
    }
    //打印数组中v位置下的顶点名
    public void displayVertex(int v) {
        System.out.println(vertex[v].getValue());
    }
    //通过顶点下标实现深度优先搜索
    public void dfs(){
    //第0个顶点设为以访问状态
        vertex[0].visited=true;
        stack.push(0);
        //打印顶点值
        System.out.println(vertex[0].getValue());
        //遍历
        out:while(!stack.isEmpty()){
            for (int i = currentIndex+1; i <vertex.length; i++) {
              if(adjMax[currentIndex][i]==1&& !vertex[i].visited){
                  //说明边是通的.取出之,压入栈
                  stack.push(i);
                  //标记访问
                  vertex[i].visited=true;
                  System.out.println(vertex[i].getValue());
                  continue out;
              }
            }
            //如果没有可以访问的定点了,那么,弹出栈顶元素
            stack.pop();
            //修改当前位置为站定元素位置
            if (!stack.isEmpty()) {
                currentIndex = (int) stack.peek();
            }
        }
    }

}
