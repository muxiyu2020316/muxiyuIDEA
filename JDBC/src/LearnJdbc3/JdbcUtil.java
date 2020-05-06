package LearnJdbc3;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * jdbc ͨ�ù�����,�ʺϼ���ɾ�Ĳ�
 * ʹ��ǰ�ǵõ���
 */
public class JdbcUtil {
    //������Ĺ��췽������˽�е�,����Ҫnew����,��ֱ�ӵ���
    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs=null;
    static String user="root";
    static String pwd="123456";
    static String url="jdbc:mysql://localhost:3306/girls";
    /**
     * ��̬������������ִ��,ִֻ��һ��,����Ч�ʸ�
     */
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * ��ȡ���ݿ�����
     * @return
     */
    public static Connection getConnection() throws SQLException {
        Connection conn= DriverManager.getConnection(url,user,pwd);
        return conn;
    }
    /** ��ɾ�ĵ�ͨ�÷���
     * @paramString sql  Ҫִ�е�sql
     * @paramObject[] obj    �������͵�����  �������� sqlִ�е�ռλ������
     *��name��age��id��
     *��id��
     *��name��age��
     * Object... �ɱ����,ע����治�����в���
     * */
    public static void Update(String sql,Object... obj){
        try {
            int count;
            conn = getConnection();
            ps = conn.prepareStatement(sql);
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
            close(conn,ps,rs);
        }
    }
    /**
     * c��ѯ��ͨ�÷���
     * @param sql  sql���
     * @param obj �ɱ����
     * @return  ���ؽ����,���ص���һ������
     * ������洢MAP
     */
    public static List<Map<String ,Object>> Query(String sql,Object... obj){
        try {
            conn =getConnection();
            //�п����в���,����Ĳ����� ����ֵ?,������select���������ֵ
            ps=conn.prepareStatement(sql);
            //���ݴ���Ĳ�������ռλ��������
            for (int i = 0; i <obj.length ; i++) {
                //jdbc ���е��±궼�Ǵ�0��ʼ��
                ps.setObject(i+1,obj[i]);
            }

            //ִ��sql��ѯ���
            rs=ps.executeQuery();
        //��Ҫ�洢����,ʹ�ü�ֵ�������,һ��map����һ����Ϣ,���մ洢��list,���ڲ�ѯ
            List<Map<String,Object>> list = new ArrayList<>();
            /**
             * ��ȡ���β�ѯ������ж�����
             * getMetaData(), ��ȡԪ����
             * getColumnCount(),��ȡ����
             */
            int count = rs.getMetaData().getColumnCount();
            while(rs.next()){
                //һ������ ��һ��map ����
             Map<String ,Object> map=new HashMap<>();
                /**
                 * ע��:�����ں����ݱ��ж�����
                 * ͨ��getMetData().getColumnLabel() ��ȡ��
                 * �õ����о��ܾ�һ����ȡmap��key
                 */
                for (int i = 0; i <count ; i++) {
                    String name=rs.getMetaData().getColumnLabel(i+1);
                    map.put(name,rs.getObject(name));
                }
                /*��ÿ�е�map��ŵ� List��*/
                list.add(map);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close(conn,ps,rs);
        }
        return null;
    }
    /**
     * �ر���Դ
     * @param conn ����
     * @param ps ���ݲ�������
     * @param rs   �����
     */
    public static void close(Connection conn, Statement ps, ResultSet rs){
        //�ͷ���Դ
        try {
            if(rs!=null)
                rs.close();
        }catch (Exception e2) {
            System.out.println("rs�ر�ʧ��");
        }
        try {
            if(ps!=null)
                ps.close();
        }catch (Exception e2) {
            System.out.println("stmt�ر�ʧ��");
        }
        try {
            if(conn!=null)
                conn.close();
        } catch (Exception e2) {
            System.out.println("conn�ر�ʧ��");
        }
    }
}
