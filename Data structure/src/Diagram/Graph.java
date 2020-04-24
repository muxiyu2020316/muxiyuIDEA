package Diagram;

public class Graph {
    private final Vertex[] vertexList;// 顶点数组
    private final int[][] adjMat;// 邻接矩阵
    private int nVerts;// 当前顶点总数
    private final StackX theStack;
    private final QueueX theQueueX;

    public static void main(String[] args) {
        Graph theGraph = new Graph();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');

        theGraph.addEdge(0, 1);
        theGraph.addEdge(1, 2);
        theGraph.addEdge(0, 3);
        theGraph.addEdge(3, 4);

//        System.out.print("visits->dfs=");
//        theGraph.dfs();
        System.out.print("\nvisits->bfs=");
        theGraph.bfs();
    }
    public Graph() {// 构造图
        int MAX_VERTS = 20;
        vertexList = new Vertex[MAX_VERTS];

        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
        theStack = new StackX();
        theQueueX = new QueueX();
    }
    public void addVertex(char lab) {// 添加顶点
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {// 添加边
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {// 打印数组中v位置下的顶点名
        System.out.print(vertexList[v].lable);
    }

    public int getAdjUnvisitedVertex(int v) {// 获取和v邻接的未访问的顶点
        for (int i = 0; i < nVerts; i++) {
            if (adjMat[v][i] == 1 && vertexList[i].wasVisited == false) {
                return i;
            }
        }
        return -1;
    }
    public void dfs() {// 深度优先搜索
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theStack.push(0);

        while (!theStack.isEmpty()) {
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1) {
                theStack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;// 重置，防止后边再次使用dfs
        }
    }

    public void bfs() {// 广度优先搜索
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theQueueX.insert(0);
        int v2;

        while (!theQueueX.isEmpty()) {
            int v1 = theQueueX.remove();

            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                theQueueX.insert(v2);
            }
        }

        for (int j = 0; j < nVerts; j++) {
            vertexList[j].wasVisited = false;
        }
    }

    class Vertex {
        public char lable;// 名字
        public boolean wasVisited;

        public Vertex(char lab) {
            lable = lab;
            wasVisited = false;
        }
    }
}
