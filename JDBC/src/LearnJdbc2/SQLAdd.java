package LearnJdbc2;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SQLAdd {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("������desc����,asc����");
        System.out.println("������");
        String key=s.nextLine();
        //ִ��sql���
        //jdbc���6��
        Statement ps=null;//Ԥ��������ݿ��������
        //�ӿ���Ҫ�滻
        Connection conn=null;
        ResultSet rs=null;
        try{
            //1ע������
            Class.forName("com.mysql.jdbc.Driver");
            //2��ȡ����
            conn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/girls",
                    "root","123456");
            //3��ȡԤ��������ݲ�������
            ps= conn.createStatement();
            //4ִ��sql
            String sql="select loginPwd from user order by loginPwd "+key;
            //5��������
            rs=ps.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("loginPwd"));
            }
        }catch(Exception e){

        }finally {
            //6�ͷ���Դ
            try {
                if(rs!=null)
                    rs.close();
            }catch (Exception e2) {
            }
            try {
                if(ps!=null)
                    ps.close();
            }catch (Exception e2) {
            }
            try {
                if(conn!=null)
                    conn.close();
            } catch (Exception e2) {
            }
        }
    }
}
