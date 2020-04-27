package RefreshBaseJava;

import java.io.*;

public class TestIo {
    static  DataInputStream dataInputStream;
    static  DataOutputStream dataOutputStream;
    public static void main(String[] args) throws IOException {
    //testRead();
    //testReadLine();
    //testWriter();
    //testDataStream();
    // testFileStream();
    // testFile();
    //testFileClass();
    //System.out.println(testmkdir());
     File dirname = new File("G:\\TestFile\\muxiyu");
     deleteFolder(dirname);

    }
    static void testRead()throws IOException{
        char c;
        //使用System.in创建BuffereadReader
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符, 按下 'q' 键退出。");
        // 读取字符
        do{
            c=(char)bufferedReader.read();
            System.out.println(c);
        }while(c!='q');
    }
    static void testReadLine()throws IOException{
        // 使用 System.in 创建 BufferedReader
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("输入文本内容:");
        System.out.println("输入end结束!");
        do{
            str = bufferedReader.readLine();
            System.out.println(str);
        }while(!str.equals("end"));
    }
    static void testWriter()throws IOException{
        int buffer;
        buffer = 'M';
        System.out.write(buffer);
        System.out.write('\n');
    }
    static void testDataStream()throws IOException{
        dataInputStream=new DataInputStream(new FileInputStream("G:\\TestFile\\muxiyu.txt"));
        dataOutputStream=new DataOutputStream(new FileOutputStream("G:\\TestFile\\jiangxiaobai.txt"));
        BufferedReader doc=new BufferedReader(new InputStreamReader((dataInputStream)));
        String Count;
        while((Count= doc.readLine())!=null){
            //转换成大写
            String temp=Count.toUpperCase();
            System.out.println(temp);
            dataOutputStream.writeBytes(temp+" ");
        }
        //关闭流.释放缓存
        doc.close();
        dataOutputStream.close();
    }
    static void testFileStream()throws IOException{
        try {
            byte bwriter[] = {1, 2, 19, 33, 18, 34, 109};
            OutputStream os = new FileOutputStream("G:\\TestFile\\testfile.txt");
            for (int i = 0; i < bwriter.length; i++) {
                os.write(bwriter[i]); // writes the bytes
            }
            os.close();
            InputStream inputStream = new FileInputStream("G:\\TestFile\\test.txt");
            for (int i = 0; i < inputStream.available(); i++) {
                System.out.print((char) inputStream.read() + " ");
            }
            inputStream.close();
        }catch (IOException e){
            System.out.print("Exception 系统找不到指定的文件");
        }
    }
    static void testFile()throws IOException{
        // 构建FileOutputStream对象,文件不存在会自动新建
        File f = new File("a.txt");
        FileOutputStream fop = new FileOutputStream(f);
        // 构建OutputStreamWriter对象,指定编码,默认为utf-8,windows上是gbk
        OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
        writer.append("沐汐语,我喜欢你!");
        // 写入到缓冲区
        writer.append("\n");
        writer.append("Muxiyu,I love yo forever!");
        // 刷新缓存冲,写入到文件,如果下面已经没有写入的内容了,直接close也会写入
        writer.close();
        fop.flush();
//        关闭写入流,同时会把缓冲区内容写入文件,所以上面的注释掉
//        fop.close();
//        // 关闭输出流,释放系统资源
        //读取输入的内容
        FileInputStream fip = new FileInputStream(f);
        // 构建FileInputStream对象
        InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
        // 构建InputStreamReader对象,编码与写入相同
        StringBuffer sb = new StringBuffer();
        while (reader.ready()) {
            sb.append((char) reader.read());
            // 转成char加到StringBuffer对象中
        }
        System.out.println(sb.toString());
        reader.close();
        // 关闭读取流
        fip.close();
        // 关闭输入流,释放系统资源
    }
    static void testFileClass(){
        String dirname="G:\\TestFile";
        File file1=new File(dirname);
        if(file1.isDirectory()){
            System.out.println("目录名字:"+dirname);
            //文件数组
            String str[]=file1.list();
            for (int i = 0; i < str.length; i++) {
             File file=new File(dirname+str[i]);
             if(file.isDirectory()) {
                 System.out.println(str[i] + "目录");
             }else{
                 System.out.println(str[i] + "文件");
             }
            }
        }else{
            System.out.println(dirname + " 不是目录");
        }
    }
    static boolean testmkdir(){
        String dirname="G:\\TestFile\\彤离";
        File file1=new File(dirname);
        if(file1.mkdir()==true){
            System.out.println("创建一个文件夹，成功!");
        }else {
            System.out.println("创建一个文件夹，失败!");
        }
        return file1.mkdirs();
    }
    static void deleteFolder(File folder){
        // 删除文件及目录
        File[] files=folder.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    deleteFolder(f);
                    System.out.println("目录删除成功!");
                } else {
                    f.delete();
                    System.out.println("文件删除成功!");
                }
            }
        }
        folder.delete();
    }
}
