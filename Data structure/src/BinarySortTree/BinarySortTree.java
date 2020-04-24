package BinarySortTree;

public class BinarySortTree {
    Node root;
    //向二叉排序树添加节点
    public void add(Node node){
        if (root==null){
            root=node;
        }else{
            root.add(node);
        }
    }

    public void fontShow() {
        if (root!=null){
            root.fontShow(root);
        }
    }
    public void midShow() {
        if (root!=null){
            root.midShow(root);
        }
    }
    public void MidShow() {
        if (root!=null){
            root.MidShow();
        }
    }
    public void afterShow() {
        if (root!=null){
            root.afterShow(root);
        }
    }
    //查找节点
    public Node FontSearch(int value){
        if (root==null){
            return null;
        }else{
            return  root.FontSearch(value);
        }
    }
    public Node Search(int value){
        if (root==null){
            return null;
        }else{
            return  root.Search(value);
        }
    }
    public Node AfterSearch(int value){
        if (root==null){
            return null;
        }else{
          return  root.AfterSearch(value);
        }
    }
    //删除节点
    public void delete(int value) throws Exception {
    if(root==null){
        return;
    }else{
        //找到这个节点
        Node Target=Search(value);
        //如果没有这个数
        if(Target==null){
            return;
        }
        //否则找到他的父节点
        Node Parent=SearchParent(value);
        //如果要删除的节点是叶子节点
        if (Target.lnode==null&&Target.rnode==null){
            //如果要删除的节点是父节点的左子节点
            if (Parent.lnode.value==value){
                //让父节点的左子节点为空
                Parent.lnode=null;
            }else{
                Parent.rnode=null;
            }
        }else{
            //要删除的是带叶子节点的节点
        }
    }
    }
    //查找父节点
    public Node SearchParent(int value) throws Exception {
        if (root.value==value){
            System.out.println("根节点没有父节点");
            return  null;
        }
        if (root==null){
            return  null;
        }else{
            return root.SearchParent(value);
        }
    }


}
