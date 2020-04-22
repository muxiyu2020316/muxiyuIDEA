package com.muxiyu.RefreshBaseJava;

import java.io.*;

public class TestFile {


    public static void main(String[] args) {
        //TestCutAudio();
        TestFileType();
        TestImageCopy();
    }
    static void TestCutAudio(){
        FileInputStream fileInputStream=null;
        FileOutputStream fileOutputStream=null;
        //文件列表等价于FileInputStream fileInputStream=new FileInputStream("G:/星月神话.mp3")
        String FileListName[]={"E:/星月神话.mp3","E:/我只在乎你.mp3"};
       //设置byte数组，每次往输出流中传入16K的内容
        byte[] by=new byte[1024*16];
        try{
            //混合两个音频,染护输出结合的音频
            fileOutputStream =new FileOutputStream("E://星月.mp3");
            for (int i = 0; i <2 ; i++) {
              int count=0;
              fileInputStream=new FileInputStream(FileListName[i]);
             //跳过多少M的内容
                fileInputStream.skip(1024*1024*4);
                while(fileInputStream.read(by)!=-1){
                    fileOutputStream.write(i);
                    count++;
                    System.out.println(count);
                    //要截取中间2MB的内容，每次输入16k的内容，所以输入的次数是1024*2/8
                    if(count == (1024*2/16)){
                        break;
                    }
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    static void TestFileType(){
    }
    static void TestImageCopy(){
        try {
            BufferedInputStream bfi=new BufferedInputStream(new FileInputStream("C:\\Users\\25908\\Pictures\\lili.jpg"));
            BufferedOutputStream bfo=new BufferedOutputStream(new FileOutputStream("C:\\Users\\25908\\Pictures\\lilicopy.jpg"));
            int len=0;
            byte[] buff=new byte[1024];
            while((len=bfi.read(buff))!=-1) {
                bfo.write(buff, 0, len);
            }
            bfi.close();
            bfo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}