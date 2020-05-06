package LearnJdbc2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * ���ݿ�ű�,ת��
 * 7.��ʾ��Ч����,2��ʾС����
  drop table if exists act;
  create table act(
  actno bigint,
  balance double(7,2)
 );
 insert into act values(111,10009.2);
 insert into act values(222,10099);
 */
/**
 * jdbc�е��������Զ��ύ��
 * ����Ҫcommit,Ҳû�лع�,ִ��һ��dml�����Զ��ύһ��
 * ����jdbcĬ�ϵ�������Ϊ,ʵ���϶�����Ҫ����������ϲ�����ɵ�,��Ҫ��֤ͬʱ�ɹ���ʧ��
 * ����jdbcֻҪִ��һ�ξ��Զ��ύһ��ʧ��
 * ��������
 * conn.setAutoCommit(false);
 * conn.commit();
 * conn.rollback();
 */
public class Commit {
    static PreparedStatement ps=null;//Ԥ��������ݿ��������
    static Connection conn=null;
    static ResultSet rs=null;
    public static void main(String[] args) {
       commitDB();
    }
    static void commitDB(){
        //jdbc���6��
        try {
            //2��ȡ����
            /**���Զ��ύ�����޸�Ϊ�ֶ��ύ*/
            //��������,�ֶ��ύ
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            //3��ȡԤ��������ݲ�������
            String sql = "update act set balance=? where actno=?";
            ps = conn.prepareStatement(sql);
            //��? ��ֵ
            ps.setDouble(1, 1000);
            ps.setInt(2, 111);
            int count = ps.executeUpdate();
            //��? ��ֵ
            ps.setDouble(1, 1000);
            ps.setInt(2, 222);
            //4ִ��sql
            count += ps.executeUpdate();
            System.out.println(count == 2 ? "�ɹ�" : "ʧ��");
            //����������ⲽ,�����ύ�ɹ���,�����ֶ��ύ
            //�ύ����
            conn.commit();
            //5.��������
        } catch (Exception e) {
            //�ع�����
            if (conn != null) {
                try {
                    //�ֶ��ع�
                    conn.rollback();
                } catch (Exception e2) {
                    System.out.println("�ֶ��ع�ʧ��");
                }
            }
            System.out.println("ת��ʧ��");
        } finally {
            //6�ͷ���Դ
            DBUtil.close(conn,ps,rs);
        }
    }
}
