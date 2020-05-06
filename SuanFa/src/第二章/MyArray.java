package �ڶ���;

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
      * �������Ԫ��
      * @param element �����Ԫ��
      * @param index �����λ��
      */
    public void insert(int element, int index){
        if (index<0||index>size) {
            throw new IndexOutOfBoundsException("��������ʵ��Ԫ�ط�Χ��");
        }
        //���ʵ��Ԫ�شﵽ�����������ޣ���������������
         if(size >= array.length){
             resize();
         }
        //��������ѭ������Ԫ���������Ų1λ
        for (int i = size-1; i >index; i--) {
          array[i+1]=array[i];
        }
        //�ڳ���λ�÷�����Ԫ��
        array[index]=element;
        size+=1;
    }

    /**
     * ��������
     */
    private void resize() {
        int[] arrayNew = new int[array.length*2];
        //�Ӿ����鸴�Ƶ�������
        System.arraycopy(array, 0, arrayNew, 0, array.length);
        array = arrayNew;
    }

    /**
     * �������
     */
    public void output(){
        for(int i=0; i<size; i++){
            System.out.print(array[i]+" ");
         }
        System.out.println();
        }
    /**
     * ����ɾ��Ԫ��
     * @param index ɾ����λ��
     */
    public int delete(int index){
        if (index < 0||index>size) {
            throw new IndexOutOfBoundsException("��������ʵ��Ԫ �ط�Χ��");
        }
        int deleteElement=array[index];
        //��������ѭ������Ԫ���������Ų
        for (int i =index; i <size-1 ; i++) {
            array[i] = array[i+1];
        }
        size--;
        return deleteElement;
    }
    /**
     * ����ɾ��Ԫ��
     * @param index ɾ����λ��
     * ǰ��������Ԫ��û��˳��Ҫ��
     */
    public int deletelimit(int index){
        if (index < 0||index>size) {
            throw new IndexOutOfBoundsException("��������ʵ��Ԫ �ط�Χ��");
        }
        array[index]=array[size];
        int deleteElement=array[index];
        size--;
        return deleteElement;
    }
    /**
     * �����޸�Ԫ��
     * @param element �޸ĵ�Ԫ��
     * @param index �޸ĵ�λ�õ�λ��
     */
    public void update(int index,int element){
        if (index < 0||index>size) {
            throw new IndexOutOfBoundsException("��������ʵ��Ԫ�ط�Χ��");
        }
        array[index]=element;
    }
    /**
     * �������Ԫ��
     * @param element ���Ԫ��
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
     * �������Ԫ��
     * @param index ���Ԫ���±�
     */
    public int get(int index){
        if (index < 0||index>size) {
            throw new IndexOutOfBoundsException("��������ʵ��Ԫ�ط�Χ��");
        }
        return array[index];
    }
}
