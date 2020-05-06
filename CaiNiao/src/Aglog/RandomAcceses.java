package Aglog;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile的使用
 * 实现了datainput dataoutput接口
 * 既可以作为输入也可以作为输出流
 * 用一个类但是需要留个对象,不能同时公用一个管道
 * r:以只读方式打开
 * rW:打开以便读取和写
 * rwd:打开以便读取和写入:同步文件内容的更新
 * rws:打开以便读取和写入;同步文件内容和元数据的更新
 * 输出时对文件内容的覆盖
 * RandomAccessFile作为输出流,写出文件不存在,自动创建,如果存在,则会覆盖(默认从头)
 */
public class RandomAcceses {
    public static void main(String[] args) throws Exception {
      test1();
      test2();
    }
    static void test1(){
        try {
            RandomAccessFile rand1=new
                    RandomAccessFile(new File("a.txt"), "r");//只读
            RandomAccessFile rand2=new
                    RandomAccessFile(new File("B.txt"), "rw");//读写

            //读写
            byte[] buff=new byte[100];
            int len;
            while((len=rand1.read(buff))!=-1){
                rand2.write(buff,0,len);
            }

            rand1.close();
            rand2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void test2() throws Exception {
        RandomAccessFile rand3=new
                RandomAccessFile(new File("c.txt"), "rw");//读写
        /**指针跳掉最后*/
        rand3.seek(3);
        StringBuffer buffer=new StringBuffer((int) new File("c.txt").length());
        /**追加,插入元素*/
        byte b[]=new byte[100];
        int len;
        while ((len=rand3.read(b))!=-1){
            buffer.append(new String(b,0,len));
        }
        //调回指针,写入数据
        rand3.seek(3);
        rand3.write("三生三世十里桃花".getBytes());
        rand3.write(buffer.toString().getBytes());
    }
}
