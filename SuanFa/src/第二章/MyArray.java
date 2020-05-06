package 第二章;

public class MyArray {
    private int[] array;
    private int size;

    public static void main(String[] args) {
        MyArray myArray = new MyArray(10);
        myArray.insert(3,0);
        myArray.insert(7,1);
        myArray.insert(9,2);
        myArray.insert(5,3);
        myArray.insert(6,4);
        myArray.output();
        myArray.update(0,110);
        System.out.println(myArray.findelement(9));
        System.out.println(myArray.get(1));
        myArray.delete(2);
        myArray.output();
        myArray.deletelimit(0);
        myArray.output();
    }
    public MyArray(int capacity){
        this.array=new int[capacity];
        size=0;
    }
    /**
      * 数组插入元素
      * @param element 插入的元素
      * @param index 插入的位置
      */
    public void insert(int element, int index){
        if (index<0||index>size) {
            throw new IndexOutOfBoundsException("超出数组实际元素范围！");
        }
        //如果实际元素达到数组容量上限，则对数组进行扩容
         if(size >= array.length){
             resize();
         }
        //从右向左循环，将元素逐个向右挪1位
        for (int i = size-1; i >index; i--) {
          array[i+1]=array[i];
        }
        //腾出的位置放入新元素
        array[index]=element;
        size+=1;
    }

    /**
     * 数组扩容
     */
    private void resize() {
        int[] arrayNew = new int[array.length*2];
        //从旧数组复制到新数组
        System.arraycopy(array, 0, arrayNew, 0, array.length);
        array = arrayNew;
    }

    /**
     * 输出数组
     */
    public void output(){
        for(int i=0; i<size; i++){
            System.out.print(array[i]+" ");
         }
        System.out.println();
        }
    /**
     * 数组删除元素
     * @param index 删除的位置
     */
    public int delete(int index){
        if (index < 0||index>size) {
            throw new IndexOutOfBoundsException("超出数组实际元 素范围！");
        }
        int deleteElement=array[index];
        //从左向右循环，将元素逐个向左挪
        for (int i =index; i <size-1 ; i++) {
            array[i] = array[i+1];
        }
        size--;
        return deleteElement;
    }
    /**
     * 数组删除元素
     * @param index 删除的位置
     * 前提是数组元素没有顺序要求
     */
    public int deletelimit(int index){
        if (index < 0||index>size) {
            throw new IndexOutOfBoundsException("超出数组实际元 素范围！");
        }
        array[index]=array[size];
        int deleteElement=array[index];
        size--;
        return deleteElement;
    }
    /**
     * 数组修改元素
     * @param element 修改的元素
     * @param index 修改的位置的位置
     */
    public void update(int index,int element){
        if (index < 0||index>size) {
            throw new IndexOutOfBoundsException("超出数组实际元素范围！");
        }
        array[index]=element;
    }
    /**
     * 数组查找元素
     * @param element 查的元素
     */
    public int findelement(int element){
        for (int i = 0; i <size ; i++) {
            if (array[i]==element) {
                return i;
            }
        }
        return -1;
    }
    /**
     * 数组查找元素
     * @param index 查的元素下标
     */
    public int get(int index){
        if (index < 0||index>size) {
            throw new IndexOutOfBoundsException("超出数组实际元素范围！");
        }
        return array[index];
    }
}
