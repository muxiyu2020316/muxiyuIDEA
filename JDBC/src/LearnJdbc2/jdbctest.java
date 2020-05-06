package LearnJdbc2;

import java.sql.*;
import java.util.ResourceBundle;
public class jdbctest {

    public static void main(String[] args) {
        //ʹ���ʰ���,�����������ļ�
        Statement stmt=null;
        Connection  conn=null;
        ResultSet rs=null;
        ResourceBundle bundle=ResourceBundle.getBundle("db");
        String driver=bundle.getString("driver");
        String url=bundle.getString("url");
        String user=bundle.getString("user");
        String password=bundle.getString("password");
        try {
            //1.ע������
            Class.forName(driver);
            //��ȡ����
            conn=DriverManager.getConnection(url,user,password);
            //��ȡ���ݿ����Ӵ����
            stmt=conn.createStatement();
            //ִ��sql���
            String sql="insert into admin values(22,'ARyu','123456')";
            int count=stmt.executeUpdate(sql);
            System.out.println(count==1?"��ӳɹ�":"ʧ��");
        } catch (Exception e) {
            System.out.println("ʧ��");
        }finally{
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
