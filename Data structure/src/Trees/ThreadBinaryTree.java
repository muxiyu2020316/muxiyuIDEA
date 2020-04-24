package Trees;

public class ThreadBinaryTree {
    ThreadTreeNode root;
    //存储前驱结点
    ThreadTreeNode pre;
//获取根节点
    public ThreadTreeNode getRoot() {
        return root;
    }
//设置根节点
    public void setRoot(ThreadTreeNode root) {
        this.root = root;
    }
//前序线索化二叉树
public void fontthreadNode(){fontthreadNode(root);}
public void fontthreadNode(ThreadTreeNode node){
//当前节点为空,直接返回
    if (node==null){
        return;
    }
//处理当前节点
//如果左指针为空,处理前驱节点
if(node.leftNode==null){
    //让当前节点左指针指向前去节点
    node.leftNode=pre;
    //改变当前节点的类型,默认为0
    node.leftType=1;
  }
    //处理前一个节点的后继节点(右指针)为null,(没有指向右子树)
    if(pre!=null&&pre.rightNode==null){
        //前驱节点的右指针指向当前节点
        pre.rightNode=node;
        //改变前驱节点的右指针类型
        pre.rightType=1;
    }
    //每次处理一个节点,当前节点是下一个节点的前驱节点
    pre=node;
    //处理左子树
    if(node.leftType==0){
    fontthreadNode(node.leftNode);}
    //处理右子树
    if(node.rightType==0){
    fontthreadNode(node.rightNode);}
}
//中序线索化二叉树
public void midthreadNode(){midthreadNode(root);}
public void midthreadNode(ThreadTreeNode node){
//当前节点为空,直接返回
if (node==null){
    return;
}
//处理左子树
    midthreadNode(node.leftNode);
//处理前驱节点
    if(node.leftNode!=null){
        //让当前节点左指针指向前驱结点
        node.leftNode=pre;
        //改变当前节点的类型,默认为0
        node.leftType=1;
    }
    //处理前驱节点的右指针,右指针为null,(没有指向右子树)
    if(pre!=null&&pre.rightNode==null){
        //前驱节点的右指针指向当前节点
        pre.rightNode=node;
        //改变前驱节点的右指针类型
        pre.rightType=1;
    }
//每次处理一个节点,当前节点是下一个节点的前驱节点
    pre=node;
//处理右子树
    midthreadNode(node.rightNode);
}
    public void threadIterate(){threadIterate(root);}
    public void midthreadIterate(){
        //找一个节点,临时存放当前便利节点
        ThreadTreeNode nodes=root;
        while(nodes!=null){
            //循环找最开始的节点,当leftType==1时,就是指向前驱结点
            while(nodes.leftType==0){
                nodes=nodes.leftNode;
            }
            //找到了就打印当前节点的value
            System.out.println(nodes.value);
            //特殊情况,当前节点的右指针有后继节点,后继节点还有后继节点
            while (nodes.rightType==1){
                nodes=nodes.rightNode;
                System.out.println(nodes.value);
            }
            //替换当前便利的节点,继续便利
            nodes=nodes.rightNode;
        }
    }
    //前序遍历线索二叉树,按照后继方式遍历
    public void preThreadIterate(ThreadTreeNode node) {
        while(node != null) {
            while(node.leftType==0) {
                System.out.print(node.value+ ", ");
                node = node.leftNode;
            }
            System.out.print(node.value + ", ");
            node = node.rightNode;
        }
    }
    //中序遍历线索二叉树,按照后继方式遍历（思路：找到最左子节点开始）
    public void threadIterate( ThreadTreeNode node){
        //1、找中序遍历方式开始的节点
        while(node != null && node.leftType==0) {
            node = node.leftNode;
        }
        while(node != null) {
            System.out.print(node.value + " ");
            //如果右指针是线索
            if(node.rightType==1) {
                node = node.rightNode;
            } else {
                //如果右指针不是线索，找到右子树开始的节点
                node = node.rightNode;
                while(node != null && node.leftType==0) {
                    node = node.leftNode;
                }
            }
        }
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
//后序遍历
    public void afterShow() {
        if (root!=null) {
            root.afterShow();
        }
    }

//前序查找
    public ThreadTreeNode fontSearch(int i) {
        return  root.fontSearch(i);
    }
//中序查找
    public ThreadTreeNode midSearch(int i) {
        return root.midSearch(i);
    }
//后续查找
    public ThreadTreeNode afterSearch(int i) {
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
