package Tree_TBTree;

public class BinaryTree {
    TreeNode root;
//获取根节点
    public TreeNode getRoot() {
        return root;
    }
//设置根节点
    public void setRoot(TreeNode root) {
        this.root = root;
    }
//前序遍历
    public void fontShow() {
        if(root!=null) {
            root.fontShow();
        }
    }
//中序遍历
    public void midShow() {
        if (root!=null) {
            root.midShow();
        }
    }
//后续便利
    public void afterShow() {
        if (root!=null) {
            root.afterShow();
        }
    }

//谦虚查找
    public TreeNode fontSearch(int i) {
        return  root.fontSearch(i);
    }
//中序查找
    public TreeNode midSearch(int i) {
        return root.midSearch(i);
    }
//后续查找
    public TreeNode afterSearch(int i) {
        return root.afterSearch(i);
    }
    //删除子树
    public void delete(int i) {
        if(root.value==i){
            root=null;
            return;
        }else {
            root.delete(i);
        }
    }

}
