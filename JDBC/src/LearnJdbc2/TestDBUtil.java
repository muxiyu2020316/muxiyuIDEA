package LearnJdbc2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ����DBUtil�Ƿ����
 * ����ģ����ѯ
 * ������ɾ�Ĳ�
 */
public class TestDBUtil {
    public static void main(String[] args) {
        //jdbc���6��
        //��ȡ����
        Connection conn=null;
        int count = 0;
        //�ӿ���Ҫ�滻
        PreparedStatement ps=null;//Ԥ��������ݿ��������
        ResultSet rs=null;
        try {
            //��ȡ����
            conn=DB.getConnection();
            //��ȡԤ�����������,��дsql���
            /**ͨ�ò�ѯ
            String sql="select * from admin";
            //��ȡԤ�ȱ������
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("password"));
            }*/
            /**ģ����ѯ
            �ص㣺
            ��һ���ͨ�������ʹ��
                ͨ�����
                % �������ַ�,����0���ַ�
                _ ���ⵥ���ַ�
           */
            //ģ������
            String sql=" select * from user where loginName like ?";
            //��ȡԤ�ȱ������
            ps=conn.prepareStatement(sql);
            ps.setString(1,"A%");
            rs=ps.executeQuery();
                while(rs.next()){
                    System.out.println(rs.getString("loginName"));
                    //System.out.println(rs.getString("loginPwd"));
                }
            /**
             * //����������ݲ���
            String sql="insert into user(loginName,loginPwd,realName) values(?,?,?)";
            ps=conn.prepareStatement(sql);
            for (int i = 0; i <5 ; i++) {
                int rd= (int) (Math.random()*100);
                ps.setString(1,"Akr"+rd);
                ps.setString(2,""+rd*100);
                ps.setString(3,"tongliy"+rd);
               count+=ps.executeUpdate();
            }
            System.out.println(count+"���ܵ�Ӱ��");*/


            /** //���²���
            String sql="update user set loginName=?,loginPwd=? where id=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,"muxiyu");
            ps.setString(2,"11111111");
            ps.setInt(3,12);
            //4ִ��sql
            int count=ps.executeUpdate();
            System.out.println(count+"���ܵ�Ӱ��");
             */
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //�ͷ���Դ
            DB.close(conn,ps,rs);
        }
    }
}