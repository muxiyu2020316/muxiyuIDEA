package Tree_TBTree;

public class ThreadTreeNode {
    //节点权
    int value;
    //左儿子
    ThreadTreeNode leftNode;
    //右儿子
    ThreadTreeNode rightNode;
    //标识指针类型
    int leftType;
    int rightType;
    public ThreadTreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }

    public ThreadTreeNode getLeftNode() {
        return leftNode;
    }
    public void setLeftNode(ThreadTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public ThreadTreeNode getRightNode() {
        return rightNode;
    }
    public void setRightNode(ThreadTreeNode rightNode) {
        this.rightNode = rightNode;
    }
//前序遍历
    public void fontShow() {
        System.out.print(value+" ");
        //如果左子树不为空
        if(leftNode!=null){
            leftNode.fontShow();
        }
        //如果右子树不为空
        if (rightNode!=null){
            rightNode.fontShow();
        }
    }
//中序遍历
    public void midShow() {
        //如果左子树不为空
        if(leftNode!=null){
            leftNode.midShow();
        }
        //当前节点
        System.out.print(value+" ");
        //如果右子树不为空
        if (rightNode!=null){
            rightNode.midShow();
        }
    }
//后续遍历
    public void afterShow() {
        //如果左子树不为空
        if(leftNode!=null){
            leftNode.afterShow();
        }
        //如果右子树不为空
        if (rightNode!=null){
            rightNode.afterShow();
        }
        //根节点
        System.out.print(value+" ");
    }
//前序查找
    public ThreadTreeNode fontSearch(int i) {
     ThreadTreeNode target=null;
     //对比当前节点
     if(this.value==i){
         return this;
         //当前节点不是
     }else {
         //查找作左儿子
         if(leftNode!=null){
             target=leftNode.fontSearch(i);
         }
         //可能找到也可能找不到
         if(target!=null){
             return target;
         }
         //查找右儿子
         if (rightNode!=null){
             target=rightNode.fontSearch(i);
         }
     }
     //都找不到,就返回空
     return target;
    }
//中旭查找
    public ThreadTreeNode midSearch(int i) {
        ThreadTreeNode target=null;
            //查找作左儿子
            if(leftNode!=null){
                target=leftNode.midSearch(i);
            }
            //可能找到也可能找不到
            if(target!=null){
                return target;
            }
        //对比当前节点
        if(this.value==i){
            return this;
            //当前节点不是
        }
            //查找右儿子
            if (rightNode!=null){
                target=rightNode.midSearch(i);
            }
        //都找不到,就返回空
        return target;
    }
//后续查找
    public ThreadTreeNode afterSearch(int i) {
        ThreadTreeNode target=null;
            //查找作左儿子
            if(leftNode!=null){
                target=leftNode.afterSearch(i);
            }
            //可能找到也可能找不到
            if(target!=null){
                return target;
            }
            //查找右儿子
            if (rightNode!=null){
                target=rightNode.afterSearch(i);
            }
        //对比当前节点
        if(this.value==i){
            return this;
            //当前节点不是
        }
        //都找不到,就返回空
        return target;
    }
    //删除子树
    public void delete(int i) {
        ThreadTreeNode parent=this;//父节点
        //判断左儿子
        if(parent.leftNode!=null&&parent.leftNode.value==i){
            parent.leftNode=null;
            return;
        }
        //判断右儿子
        if(parent.rightNode!=null&&parent.rightNode.value==i){
            parent.rightNode=null;
            return;
        }
        //如不在上述节点中
        //递归查找左树并删除节点
        parent=leftNode;
        if(parent!=null){
            parent.delete(i);
        }
        //递归查找右树并删除节点
        parent=rightNode;
        if(parent!=null){
            parent.delete(i);
        }
    }

}
