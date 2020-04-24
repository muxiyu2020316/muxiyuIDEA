package Diagram;

import java.util.Arrays;

public class TestGraph {
    public static void main(String[] args) {
        Vertex v1=new Vertex("a");
        Vertex v2=new Vertex("b");
        Vertex v3=new Vertex("c");
        Vertex v4=new Vertex("d");
        Vertex v5=new Vertex("e");
        //声明图的大小
        VGraph VGraph =new VGraph(5);
        //加入顶点
        VGraph.addVertex(v1);
        VGraph.addVertex(v2);
        VGraph.addVertex(v3);
        VGraph.addVertex(v4);
        VGraph.addVertex(v5);
        //连接边
        VGraph.addEdge("a","b");
        VGraph.addEdge("a","c");
        VGraph.addEdge("b","d");
        VGraph.addEdge("b","c");
        VGraph.addEdge("b","e");

        //打印邻接矩阵,验证
        for (int a[]: VGraph.adjMax){
         System.out.println(Arrays.toString(a));
        }
        VGraph.dfs();
        System.out.println();
        VGraph.DFS(0);
        VGraph.GetNoVertex(1);

    }
}
