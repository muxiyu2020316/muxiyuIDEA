package Synchronized;

/**
 * ����ʽ����ģʽ
 */
public class DanLiBank {
    public static void main(String[] args) {

    }
}
class Bank{
   private Bank(){
   }
   private  static Bank instance=null;
   /**synchronized��̬ͬ������
    * public  synchronized  static Bank getInstance()
    * */
   public  synchronized  static Bank getInstance() {
       /**��ʽ2
        * synchronized (Bank.class)
        * */
       /**��ʽ2
        * synchronized (Bank.class)
        * if (instance == null)
        * ��������Ϊ�����ڲ�����Ч����
        * */
       if (instance == null) {
           synchronized (Bank.class) {
               if (instance == null) {
                   instance = new Bank();
               }
           }
       }
       return instance;
   }

}