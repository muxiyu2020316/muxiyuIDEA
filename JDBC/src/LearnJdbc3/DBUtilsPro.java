package LearnJdbc3;

import LearnJdbc2.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ���ݿ���ɾ�ò���ǿ��
 * @ author 3y
 */
public class DBUtilsPro {
    static Connection conn=null;
    static PreparedStatement ps=null;
    static ResultSet rs=null;
    public static void main(String[] args) {
        Object obj[];

        update("insert into admin(username,password) values(?,?)","chuying","000201314");
        quary("select ?,? from admin ",null,"username","password");
    }

    /**
     * ��ɾ��ֻ�д����sql���Ͳ�����ͬ,ֻ���õͰ����Ŵ����������
     * ����Ĳ����ǲ�ȷ����,���Բ��÷��ͷ���,Ҳ����ʹ��Object���ʹ���󲿷�
     * @param sql ,���ݲ�ѯ���
     * @param obj ,����Ĳ���
     * ���ﴫ��Ĳ������ǿ���ʹ��java8��������,�ɱ��������,��ʽObject... obj
     */
    public static void update(String sql,Object... obj){
        int count=0;
        try {
            conn= DBUtil.getConnection();
            //ԭ����ҪԤ�ȶ���һ��sql����,�˴��в�������
            //��ȡԤ�����������
            ps=conn.prepareStatement(sql);
            //���ݴ���Ĳ�������ռλ��������
            for (int i = 0; i <obj.length ; i++) {
                //jdbc ���е��±궼�Ǵ�0��ʼ��
              ps.setObject(i+1,obj[i]);
            }
            //ִ��sql���
            count=ps.executeUpdate();
            System.out.println(count+"�������ܵ�Ӱ��");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,null);
        }
    }

    /**������ģʽ��
     *  1:���ڲ�ѯ�����˵�����õľ��ǰ����ݷ�װ��һ��Bean���󣬷�װ��һ��List���ϡ�
     *  2.���Զ���һ���ӿڣ��õ����߰ѽӿڵ�ʵ���ഫ�ݽ���
     *  3:�ӿڵ��õķ������ǵ����ߴ��ݽ���ʵ����ķ�����
     * @param sql ,sql��ѯ���
     * @param obj ,����Ĳ���
     * @param rsh ,��������,ʹ���˲���ģʽ ResultSetHandler ���ǲ���ģʽ
     * @return ,���ؽ����,��Ӧ����ģʽ����Ĳ���
     * �и�ע������,�������ʹ���˿ɱ����,��ô����Ҫ��������λ��,��Ϊ�ɱ�����ĺ��治�������в���
     */
    public static Object quary(String sql, ResultSetHandler rsh, Object... obj){
        try {
            conn=DBUtil.getConnection();
            ps=conn.prepareStatement(sql);
            //���ݴ��ݽ����Ĳ���������SQLռλ����ֵ
            if (obj!=null){
                for (int i = 0; i <obj.length ; i++) {
                    //jdbc ���е��±궼�Ǵ�0��ʼ��
                    ps.setObject(i+1,obj[i]);
                }
                //��������
                rs=ps.executeQuery();
                //���õ����ߴ��ݽ���ʵ����ķ������Խ�������в���
                return rsh.hanlder(rs);
            }else{
                System.out.println("�봫����Ӧ����!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,rs);
        }
        return rs;
    }
}

