package BTree;

public class TreeNode {
    //节点权
    int value;
    //左儿子
    TreeNode leftNode;
    //右儿子
    TreeNode rightNode;
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }
    public TreeNode(int value) {
        this.value = value;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }
    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
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
    public TreeNode fontSearch(int i) {
     TreeNode target=null;
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
//中查找
    public TreeNode midSearch(int i) {
        TreeNode target=null;
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
    public TreeNode afterSearch(int i) {
        TreeNode target=null;
            //查找作左儿子
            if(leftNode!=null){
                target=leftNode.afterSearch(i);
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
        //可能找到也可能找不到
        if(target!=null){
            return target;
        }
        //都找不到,就返回空
        return target;
    }
    //删除子树
    public void delete(int i) {
        TreeNode parent=this;//父节点
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
