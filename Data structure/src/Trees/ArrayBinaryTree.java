package Trees;

public class ArrayBinaryTree {
    //创建一个顺序二叉树
    int []data;

    public ArrayBinaryTree(int[] data) {
        this.data = data;
    }
    public void fontShow(){
        fontShow(0);
    }
    public void midShow(){midShow(0);}
    public void afterShow(){afterShow(0);}
    //前序遍历
    public void fontShow(int index){
        int leftindex=2*index+1;
        int rightindex=2*index+2;
        if (data==null||data.length==0){
            return;
        }
        //先续便利当前节点
        System.out.print(data[index]+" ");
        //2*index+1,处理左子树
        if(leftindex<data.length){
            //递归处理左子树
            fontShow(leftindex);
        }
        //2*index+2,处理右子树
        if(rightindex<data.length){
            //递归处理左子树
            fontShow(rightindex);
        }
    }
    //中序遍历
    public void midShow(int index){
        int leftindex=2*index+1;
        int rightindex=2*index+2;
        if (data==null||data.length==0){
            return;
        }
        //2*index+1,处理左子树
        if(leftindex<data.length){
            //递归处理左子树
            midShow(leftindex);
        }
        //便利当前节点
        System.out.print(data[index]+" ");
        //2*index+2,处理右子树
        if(rightindex<data.length){
            //递归处理左子树
           midShow(rightindex);
        }
    }
    //后序遍历
    public void afterShow(int index){
        int leftindex=2*index+1;
        int rightindex=2*index+2;
        if (data==null||data.length==0){
            return;
        }
        //2*index+1,处理左子树
        if(leftindex<data.length){
            //递归处理左子树
            afterShow(leftindex);
        }
        //2*index+2,处理右子树
        if(rightindex<data.length){
            //递归处理左子树
           afterShow(rightindex);
        }
        //便利当前节点
        System.out.print(data[index]+" ");
    }
}
