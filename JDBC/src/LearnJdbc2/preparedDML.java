package LearnJdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class preparedDML {
    public static void main(String[] args) {
        //jdbc���6��
        PreparedStatement ps=null;//Ԥ��������ݿ��������
        //�ӿ���Ҫ�滻
        Connection conn=null;
        ResultSet rs=null;
        try{
            //1ע������
            Class.forName("com.mysql.jdbc.Driver");
            //2��ȡ����
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/girls",
                    "root","123456");
            //3��ȡԤ��������ݲ�������
            /*String sql="insert into user(loginName,loginPwd,realName) values(?,?,?)";
            ps=conn.prepareStatement(sql);
            ps.setString(1,"ͮ��");
            ps.setString(2,"111111");
            ps.setString(3,"��С��");*/
            /*String sql="update user set loginName=?,loginPwd=? ,realName=? where id=?";
            //��Ԥ����ִ�еõ�ģ��,�����λ�þ���Ч
            ps=conn.prepareStatement(sql);
            ps.setString(1,"��С��");
            ps.setString(2,"12994");
            ps.setString(3,"�ϼ");
            ps.setInt(4,11);*/
            String sql="delete from user where loginName=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,"��С��");
            //4ִ��sql
            int count=ps.executeUpdate();
            System.out.println(count+"���ܵ�Ӱ��");
        }catch(Exception e){
            System.out.println("���ʧ��");
        }finally {
            //6�ͷ���Դ
            try {
                if(rs!=null)
                    rs.close();
            }catch (Exception e2) {
                System.out.println("�ر�ʧ��");
            }
            try {
                if(ps!=null)
                    ps.close();
            }catch (Exception e2) {
                System.out.println("�ر�ʧ��");
            }
            try {
                if(conn!=null)
                    conn.close();
            } catch (Exception e2) {
                System.out.println("�ر�ʧ��");
            }
        }
    }

}
