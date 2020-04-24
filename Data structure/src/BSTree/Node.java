package BSTree;

public class Node {
    int value;
    Node lnode;
    Node rnode;
    public Node(int value) {
        this.value = value;
    }
    //添加节点
    public void add(Node node) {
        if (node==null){
            return;
        }
        //判断传入的数值是比当前节点大还是小
        //传入值比当前节点小,放在左边
        if(node.value<this.value){
            //如果做子树为空
            if (this.lnode==null){
                this.lnode=node;
            }else{
                //如果不为空,递归添加
                this.lnode.add(node);
            }
        }else{
            //如果右子树为空
            if (this.rnode==null){
                this.rnode=node;
            }else{
                //如果不为空,递归添加
                this.rnode.add(node);
            }
        }
    }
//前序遍历
    public void fontShow(Node node) {
        if (node==null){
            return;
        }
        System.out.print(node.value+" ");
        fontShow(node.lnode);
        fontShow(node.rnode);
    }
//中序遍历
    public void midShow(Node node) {
        if (node==null){
            return;
        }
        midShow(node.lnode);
        System.out.print(node.value+" ");
        midShow(node.rnode);
    }
    public void MidShow() {
        if (lnode!=null){
            lnode.MidShow();
        }
        System.out.print(value+" ");
        if (rnode!=null){
            rnode.MidShow();
        }
    }
//后序遍历
    public void afterShow(Node node) {
        if (node==null){
            return;
        }
        afterShow(node.lnode);
        afterShow(node.rnode);
        System.out.print(node.value+" ");
    }
    //二叉排序树,查找按理也分前中后,原理大体相同,调换第一个比较的元素位置即可
//前序查找
    public Node FontSearch(int value) {
        //判断是否和当前节点数值相同
        if (this.value==value){
            //相同直接返回
            return this;
            //否则判断查找节点和当前节点大小
        }else if(value<this.value){
            //小于,和左子树比较
            if (lnode==null){
                //如做节点为空,返回空
                return null;
            }
            //否则,递归查找,右返回值,无返回空
            return lnode.FontSearch(value);
        }else{
            //大于和右子树比较
            if (rnode==null){
                //如果有节点为空
                return null;
            }
            //否则,递归查找,有返回值,无返回空
            return rnode.FontSearch(value);
        }
    }
//中序查找
    public Node Search(int value) {
    if(value<this.value){
           //小于,和左子树比较
           if (lnode==null){
               //如做节点为空,返回空
               return null;
           }
           //否则,递归查找,右返回值,无返回空
           return lnode.Search(value);
       }        //判断是否和当前节点数值相同
        else if (this.value==value){
            //相同直接返回
            return this;
            //否则判断查找节点和当前节点大小
        } else{
           //大于和右子树比较
           if (rnode==null){
               //如果有节点为空
               return null;
           }
       //否则,递归查找,有返回值,无返回空
           return rnode.Search(value);
       }
    }
//后续查找
    public Node AfterSearch(int value) {
        //判断是否和当前节点数值相同
           if(value<this.value){
            //小于,和左子树比较
            if (lnode==null){
                //如做节点为空,返回空
                return null;
            }
            //否则,递归查找,右返回值,无返回空
            return lnode.AfterSearch(value);
         }else if(value>this.value){
            //大于和右子树比较
            if (rnode==null){
                //如果有节点为空
                return null;
            }
               //否则,递归查找,有返回值,无返回空
               return rnode.AfterSearch(value);
        }else if (this.value==value) {
               //相同直接返回
               return this;
           }
           return null;
    }
//查找父节点
    public Node SearchParent(int value) throws Exception {
        if ((this.lnode!=null&&this.lnode.value==value)||
            (this.rnode!=null&&this.rnode.value==value)){
            return this;
        }else{
            if (value<this.value&&this.lnode!=null){
                return  this.lnode.SearchParent(value);
            }else if(value>this.value&&this.rnode!=null){
                return this.rnode.SearchParent(value);
            }
        }
        throw new Exception("不在查找范围");
        }

}

