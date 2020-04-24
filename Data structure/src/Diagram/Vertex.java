package Diagram;

public class Vertex {
    //顶点类
    private  String value;
    public boolean visited;
    public Vertex(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Vertex{" +"value='" + value + '\'' + '}';
    }
}
