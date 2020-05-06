package Synchronized;

/**
 * 懒汉式单例模式
 */
public class DanLiBank {
    public static void main(String[] args) {

    }
}
class Bank{
   private Bank(){
   }
   private  static Bank instance=null;
   /**synchronized静态同步方法
    * public  synchronized  static Bank getInstance()
    * */
   public  synchronized  static Bank getInstance() {
       /**方式2
        * synchronized (Bank.class)
        * */
       /**方式2
        * synchronized (Bank.class)
        * if (instance == null)
        * 这样就认为不是在操作功效数据
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