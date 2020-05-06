package LearnJdbc1;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;

public class test {
    public static void main(String[] args) {
        Statement stmt=null;
        Connection conn=null;
        ResultSet rs=null;
        try {
            //1.ע������
            Class.forName("com.mysql.jdbc.Driver");
            //2.��ȡ����
            conn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/girls",
                    "root","123456");
            //3.��ȡ���ݶ���
            stmt= (Statement) conn.createStatement();
            System.out.println(conn);
            //4.ִ��sql
            String sql="select * from boys";
            //ר�Ų�ѯdql���ķ���
            rs=stmt.executeQuery(sql);
            //5.�����ѯ�����,ddl��������,dql��������
            boolean flag=rs.next();
            System.out.println(flag);
            while(rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("boyName");
                String cp = rs.getString("userCP");
                System.out.println("���:"+id+" ������:"+name+" CP:"+cp);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }finally {
            //6.�ͷ���Դ
            try {
                if(rs!=null)
                    rs.close();
            }catch (Exception e2) {
            }
            try {
                if(stmt!=null)
                    stmt.close();
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
